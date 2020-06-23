package diaceutics.selenium.pageobject;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.Link;
import aquality.selenium.elements.interfaces.IRadioButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import diaceutics.selenium.elements.ComboboxJs;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import diaceutics.selenium.utilities.JavaScriptUtil;
import org.openqa.selenium.By;

import java.util.List;

public abstract class BaseForm extends Form {

    public static final String COMBOBOX_TEMPLATE =
            "//div[./label[text()='%s']]//div[@class='selectContainer']//ng-select[@role='listbox']//span[@class='ng-arrow-wrapper']";

    private static final String TEXT_TEMPLATE = "//input[..//label[text()='%s']]";
    private static final String RADIO_BUTTON_TEMPLATE =
            "//ui-radio-group[./label[.='%s']]//label[contains(@class,'radioOptionContainer')][.//span[text()='%s']]";

    private static final String ALERT_MESSAGE_TEMPLATE = "//ui-alert//span[contains(text(),'%s')]";
    private static final String REQUIRED_FIELD_ALERT_MESSAGE_TEMPLATE = "//ui-validation-container//li[contains(text(),'%s')]";

    protected BaseForm(By locator, String name) {
        super(locator, name);
    }

    @Override
    public boolean isDisplayed() {
        AqualityServices.getConditionalWait().waitFor(JavaScriptUtil::waitForAngular);
        return super.isDisplayed();
    }

    public String setFieldValue(FormFieldInterface field, String value) {
        switch (field.getFieldType()) {
            case TEXT:
                ITextBox textBox = getElementFactory().getTextBox(
                        By.xpath(String.format(TEXT_TEMPLATE, field.getLocator())), field.getFriendlyName());

                textBox.clearAndType(value);
                break;

            case COMBOBOX:
                ComboboxJs comboboxJs = getElementFactory().getCustomElement(
                        ComboboxJs.class, By.xpath(String.format(COMBOBOX_TEMPLATE, field.getLocator())),
                        field.getFriendlyName());

                if (value.equals("random")) {
                    value = comboboxJs.getRandomValue();
                }

                comboboxJs.selectByText(value);
                break;

            case RADIO:
                IRadioButton radioButton = getElementFactory().getRadioButton(
                        By.xpath(String.format(RADIO_BUTTON_TEMPLATE, field.getLocator(), value)),
                        field.getFriendlyName());

                radioButton.click();
                break;

            default:
                break;
        }

        return value;
    }

    public boolean isAlertMessageDisplayed(String message) {
        List<Link> alertLink = getElementFactory().findElements(
                By.xpath(String.format(ALERT_MESSAGE_TEMPLATE, message)), ElementType.LINK);
        return alertLink.size() > 0;
    }

    public boolean isMessageDisplayedOnRequiredFields(String message) {
        List<Link> alertLink = getElementFactory().findElements(
                By.xpath(String.format(REQUIRED_FIELD_ALERT_MESSAGE_TEMPLATE, message)), ElementType.LINK);
        return alertLink.size() > 0;
    }

}
