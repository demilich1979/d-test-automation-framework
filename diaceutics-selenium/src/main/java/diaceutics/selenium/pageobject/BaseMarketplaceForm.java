package diaceutics.selenium.pageobject;

import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import org.openqa.selenium.By;

public abstract class BaseMarketplaceForm extends BaseForm {

    public static final String CHECKBOX_TEMPLATE = "//label[@for='%s']";

    protected BaseMarketplaceForm(By locator, String name) {
        super(locator, name);
    }

    @Override
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
                ICheckBox checkBox = getElementFactory().getCheckBox(
                        By.xpath(String.format(CHECKBOX_TEMPLATE, field.getLocator())), field.getFriendlyName());
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

}
