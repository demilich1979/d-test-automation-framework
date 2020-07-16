package diaceutics.selenium.pageobject;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.Link;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import diaceutics.selenium.elements.ComboboxJs;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import diaceutics.selenium.utilities.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

public abstract class BaseForm extends Form {

    public static final String COMBOBOX_JS_TEMPLATE = "%s//span[@class='ng-arrow-wrapper']";
    private static final String TEXT_TEMPLATE = "//input[..//label[text()='%s']]";
    private static final String RADIO_BUTTON_TEMPLATE = "%s//label[contains(@class,'radioOptionContainer')][.//span[text()='%s']]";
    private static final String ALERT_MESSAGE_TEMPLATE = "//ui-alert//span[contains(text(),'%s')]";
    private static final String REQUIRED_FIELD_ALERT_MESSAGE_TEMPLATE = "//ui-validation-container//li[contains(text(),'%s')]";
    private static final String TEXT_AREA_TEMPLATE = "//ui-text-area[.//label[text()='%s']]//textarea";
    private static final String CHECKBOX_TEMPLATE = "//ui-checkbox-group//label[contains(text(),'%s')]";
    private static final String CHECK_CHECKBOX_TEMPLATE = CHECKBOX_TEMPLATE + "/input";
    private static final String CHECK_COMBOBOX_TEMPLATE = "%s//input";
    private static final String SEARCH_FIELD_TEMPLATE = "//ui-search/input[contains(@placeholder,'%s')]";
    private static final String BUTTON_TEMPLATE = "//button[.='%s']";

    private final IButton searchBtn = getElementFactory().getButton(By.name("search"), "Search");
    public final ILabel labelSmallSpinner = getElementFactory().getLabel(
            By.xpath("//ui-spinner[contains(@class,'small')]"), "Small Spinner");

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

            case TEXT_AREA:
                ITextBox textBoxArea = getElementFactory().getTextBox(
                        By.xpath(String.format(TEXT_AREA_TEMPLATE, field.getLocator())), field.getFriendlyName());

                textBoxArea.clearAndType(value);
                break;

            case COMBOBOX_JS:
                ComboboxJs comboboxJs = getElementFactory().getCustomElement(
                        ComboboxJs.class, By.xpath(String.format(COMBOBOX_JS_TEMPLATE, field.getLocator())),
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

            case CHECKBOX:
                ICheckBox checkBox = getElementFactory().getCheckBox(
                        By.xpath(String.format(CHECKBOX_TEMPLATE, field.getLocator())),
                        field.getFriendlyName());

                boolean shouldBeChecked = Boolean.parseBoolean(value);
                boolean isChecked = AqualityServices.getBrowser().getDriver().findElement(
                        By.xpath(String.format(CHECK_CHECKBOX_TEMPLATE, field.getLocator()))).isSelected();

                if (shouldBeChecked != isChecked) {
                    checkBox.check();
                }

                break;

            case NUMBER:
                ITextBox numberBox = getElementFactory().getTextBox(
                        By.xpath(field.getLocator()), field.getFriendlyName());

                numberBox.clearAndType(value);
                break;

            default:
                break;
        }

        return value;
    }

    public String getFieldValue(FormFieldInterface field) {
        String value = null;
        switch (field.getFieldType()) {
            case TEXT:
                ITextBox textBox = getElementFactory().getTextBox(By.id(field.getLocator()), field.getFriendlyName());
                value = textBox.getValue();
                break;

            case COMBOBOX:
                IComboBox comboBox = getElementFactory().getComboBox(By.id(field.getLocator()), field.getFriendlyName());
                value = comboBox.getSelectedText();
                break;

            default:
                break;
        }

        return value;
    }

    public boolean isAlertMessageDisplayed(String message) {
        ILabel alertLink = getElementFactory().getLabel(
                By.xpath(String.format(ALERT_MESSAGE_TEMPLATE, message)), message);
        return alertLink.state().waitForDisplayed();
    }

    public boolean isMessageDisplayedOnRequiredFields(String message) {
        List<Link> alertLink = getElementFactory().findElements(
                By.xpath(String.format(REQUIRED_FIELD_ALERT_MESSAGE_TEMPLATE, message)), ElementType.LINK);
        return alertLink.size() > 0;
    }

    public void sendKeys(FormFieldInterface field, Keys key) {
        ITextBox textBox = getElementFactory().getTextBox(
                By.xpath(String.format(TEXT_TEMPLATE, field.getLocator())), field.getFriendlyName());
        textBox.sendKeys(key);
    }

    public boolean isFieldEnabled(FormFieldInterface field) {
        boolean value = false;
        switch (field.getFieldType()) {
            case TEXT:
                ITextBox textBox = getElementFactory().getTextBox(
                        By.xpath(String.format(TEXT_TEMPLATE, field.getLocator())), field.getFriendlyName());

                value = textBox.state().isEnabled();
                break;

            case COMBOBOX_JS:
                ComboboxJs comboboxJs = getElementFactory().getCustomElement(
                        ComboboxJs.class, By.xpath(String.format(CHECK_COMBOBOX_TEMPLATE, field.getLocator())),
                        field.getFriendlyName());

                value = comboboxJs.state().isEnabled();

                break;
            default:
                break;
        }

        return value;
    }

    public void putTextInSearchField(String text, String searchFieldName) {
        ITextBox searchField = getElementFactory().getTextBox(
                By.xpath(String.format(SEARCH_FIELD_TEMPLATE, searchFieldName)), searchFieldName);
        searchField.clearAndType(text);
    }

    public void clickSearch() {
        searchBtn.clickAndWait();
    }

    public void clickByButton(String buttonName) {
        IButton btn = getElementFactory().getButton(By.xpath(String.format(BUTTON_TEMPLATE, buttonName)), buttonName);
        btn.clickAndWait();
    }

}
