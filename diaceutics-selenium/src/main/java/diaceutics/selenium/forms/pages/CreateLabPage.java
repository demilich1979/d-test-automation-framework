package diaceutics.selenium.forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IRadioButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import diaceutics.selenium.elements.ComboboxJs;
import diaceutics.selenium.enums.pageFields.CreateLabPageFields;
import org.openqa.selenium.By;

public class CreateLabPage extends Form {
    private static final String COMBOBOX_TEMPLATE =
            "//div[./label[text()='%s']]//div[@class='selectContainer']//ng-select[@role='listbox']//span[@class='ng-arrow-wrapper']";

    private static final String TEXT_TEMPLATE = "//input[..//label[text()='%s']]";
    private static final String RADIO_BUTTON_TEMPLATE =
            "//ui-radio-group[./label[.='%s']]//label[contains(@class,'radioOptionContainer')][.//span[text()='%s']]";

    private final IButton btnNext = getElementFactory().getButton(By.xpath("//button[.='Next']"), "Next");

    public CreateLabPage() {
        super(By.xpath("//h1[text()='Create a Lab']"), "Create a Lab");
    }

    public void setFieldValue(CreateLabPageFields field, String value) {
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

    public void clickNext() {
        btnNext.clickAndWait();
    }

}
