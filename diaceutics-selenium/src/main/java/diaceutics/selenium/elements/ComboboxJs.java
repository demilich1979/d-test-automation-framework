package diaceutics.selenium.elements;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.Element;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILink;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComboboxJs extends Element implements IElement {

    private final List<IElement> optionLinks = getElementFactory().findElements(
            By.xpath("//span[contains(@class,'ng-option')]"), ElementType.LINK);

    public ComboboxJs(By locator, String name, ElementState state) {
        super(locator, name, state);
    }

    protected String getElementType() {
        return this.getLocalizationManager().getLocalizedMessage("loc.comboboxJs");
    }

    public String selectByText(String value) {
        this.clickAndWait();
        ILink optionLink = getElementFactory().getLink(
                By.xpath(String.format("//div[@role='option']//span[text()='%s']", value)), value);

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
