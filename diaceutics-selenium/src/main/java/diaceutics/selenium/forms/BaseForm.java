package diaceutics.selenium.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IRadioButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import diaceutics.selenium.elements.ComboboxJs;
import diaceutics.selenium.enums.pageFields.CreateLabPageFields;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import diaceutics.selenium.utilities.JavaScriptUtil;
import org.openqa.selenium.By;


public abstract class BaseForm extends Form {

    private static final String COMBOBOX_TEMPLATE =
        "//div[./label[text()='%s']]//div[@class='selectContainer']//ng-select[@role='listbox']//span[@class='ng-arrow-wrapper']";

    private static final String TEXT_TEMPLATE = "//input[..//label[text()='%s']]";
    private static final String RADIO_BUTTON_TEMPLATE =
            "//ui-radio-group[./label[.='%s']]//label[contains(@class,'radioOptionContainer')][.//span[text()='%s']]";

    protected BaseForm(By locator, String name) {
        super(locator, name);
    }

    @Override
    public boolean isDisplayed() {
        AqualityServices.getConditionalWait().waitFor(JavaScriptUtil::waitForAngular);
        return super.isDisplayed();
    }

    public void setFieldValue(FormFieldInterface field, String value) {
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

    }



}
