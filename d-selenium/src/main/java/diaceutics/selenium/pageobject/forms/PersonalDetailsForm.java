package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.*;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import diaceutics.selenium.pageobject.BaseMarketplaceForm;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends BaseMarketplaceForm {

    private final IButton registerBtn = getElementFactory().getButton(By.id("button-register"), "Register");

    public PersonalDetailsForm() {
        super(By.id("user_registration_firstName"), "Personal Details");
    }

    @Override
    public String setFieldValue(FormFieldInterface field, String value) {
        switch (field.getFieldType()) {
            case TEXT:
                ITextBox textBox = getElementFactory().getTextBox(By.id(field.getLocator()), field.getFriendlyName());
                textBox.clearAndType(value);
                if (field.getFriendlyName().equals("COMPANY NAME")) {
                    ILink link = getElementFactory().getLink(
                            By.xpath("//div[@class='tt-suggestion tt-selectable']"), field.getFriendlyName());
                    link.clickAndWait();
                }

                break;

            case COMBOBOX:
                IComboBox comboBox = getElementFactory().getComboBox(By.id(field.getLocator()), field.getFriendlyName());
                comboBox.selectByText(value);

                break;

            case CHECKBOX:
                ICheckBox checkBox = getElementFactory().getCheckBox(
                        By.xpath(String.format(BaseMarketplaceForm.CHECKBOX_TEMPLATE, field.getLocator())), field.getFriendlyName());
                boolean shouldBeChecked = Boolean.parseBoolean(value);
                if (shouldBeChecked) {
                    checkBox.click();
                }

                break;

            default:
                break;
        }

        return value;
    }

    public void clickRegister() {
        registerBtn.clickAndWait();
    }

}
