package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class RegisterPage extends BaseForm {

    private final IButton registerBtn = getElementFactory().getButton(By.id("button-register"), "Register");

    public RegisterPage() {
        super(By.name("user_registration"), "Register");
    }

    public String setFieldValue(FormFieldInterface field, String value) {
        switch (field.getFieldType()) {
            case TEXT:
                ITextBox textBox = getElementFactory().getTextBox(By.id(field.getLocator()), field.getFriendlyName());
                textBox.clearAndType(value);

                break;

            case COMBOBOX:
                IComboBox comboBox = getElementFactory().getComboBox(By.id(field.getLocator()), field.getFriendlyName());
                comboBox.selectByText(value);

                break;

            case CHECKBOX:
                ICheckBox checkBox = getElementFactory().getCheckBox(By.xpath(field.getLocator()), field.getFriendlyName());
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
