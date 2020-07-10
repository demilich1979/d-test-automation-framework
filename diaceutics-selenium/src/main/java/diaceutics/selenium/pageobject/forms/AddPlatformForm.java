package diaceutics.selenium.pageobject.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.elements.ComboboxJs;
import diaceutics.selenium.enums.pageFields.AddPlatformFormFields;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

import java.util.List;

public class AddPlatformForm extends BaseForm {

    private final IButton addPlatformBtn = getElementFactory().getButton(
            By.xpath("//form//button[.='Add platform']"), "Add platform");

    public AddPlatformForm() {
        super(By.xpath("//div[contains(@class,'header')]//span[.='Add platform']"), "Add platform");
    }

    public void clickAddPlatform() {
        addPlatformBtn.clickAndWait();
    }

    public boolean isFieldContainsValue(AddPlatformFormFields field, String value) {
        ComboboxJs comboboxJs = getElementFactory().getCustomElement(
                ComboboxJs.class, By.xpath(String.format(BaseForm.COMBOBOX_JS_TEMPLATE, field.getLocator())), "comboboxJs");
        List<String> options = comboboxJs.getStringListOptions();

        return AqualityServices.getConditionalWait()
                .waitFor(() -> options.stream().anyMatch(option -> option.equals(value)));
    }

}
