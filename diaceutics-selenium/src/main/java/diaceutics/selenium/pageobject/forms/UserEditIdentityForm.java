package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class UserEditIdentityForm extends BaseForm {

    public UserEditIdentityForm() {
        super(By.xpath("//h2[.='Identity']"), "Identity");
    }

    public String getFieldValue(FormFieldInterface field) {
        String value = "";
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
}
