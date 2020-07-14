package diaceutics.selenium.elements;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.Element;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILink;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComboboxJs extends Element implements IElement {

    public ComboboxJs(By locator, String name, ElementState state) {
        super(locator, name, state);
    }

    protected String getElementType() {
        return this.getLocalizationManager().getLocalizedMessage("loc.combobox");
    }

    public String selectByText(String value) {
        this.clickAndWait();
        ILink optionLink = getElementFactory().getLink(
                By.xpath(String.format("//div[@role='option']//span[normalize-space(text())='%s']", value)), value);
        int count = 0;
        while (!optionLink.state().isDisplayed() && count < 100) {
            Actions act = new Actions(AqualityServices.getBrowser().getDriver());
            act.sendKeys(Keys.ARROW_DOWN).perform();
            count++;
        }
        optionLink.clickAndWait();
        return value;
    }

    public String getRandomValue() {
        List<String> options = getStringListOptions();
        int randomIndex = new Random().nextInt(options.size());
        return options.get(randomIndex);
    }

    public List<String> getStringListOptions() {
        this.clickAndWait();
        List<IElement> optionLinks = getElementFactory().findElements(
                By.xpath("//span[contains(@class,'ng-option')]"), ElementType.LINK);
        List<String> options = new ArrayList<>();
        if (optionLinks.size() > 0) {
            optionLinks.forEach(option -> {
                options.add(option.getText());
            });
        }
        this.clickAndWait();
        return options;
    }
}
