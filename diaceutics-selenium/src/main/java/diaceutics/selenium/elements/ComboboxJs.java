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

    public ComboboxJs(By locator, String name, ElementState state) {
        super(locator, name, state);
    }

    protected String getElementType() {
        return this.getLocalizationManager().getLocalizedMessage("loc.comboboxJs");
    }

    public void selectByText(String value) {
        this.clickAndWait();
        if (value.equals("random")) {
            value = getRandomValue();
        }

        ILink optionLink = getElementFactory().getLink(
                By.xpath(String.format("%s[.='%s']/parent::div", getLocator(), value)), value);

        optionLink.clickAndWait();
    }

    public String getRandomValue() {
        List<String> options = getStringListOptions();
        int randomIndex = new Random().nextInt(options.size());
        return options.get(randomIndex);
    }

    public List<String> getStringListOptions() {
        this.clickAndWait();
        List<String> options = new ArrayList<>();
        List<IElement> optionLinks = getElementFactory().findElements(
                By.xpath(String.format("%s[contains(@class,'ng-option-label')]", getLocator())), ElementType.LINK);

        if (optionLinks.size() > 0) {
            optionLinks.forEach(option -> {
                options.add(option.getText());
            });
        }
        return options;
    }
}
