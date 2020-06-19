package diaceutics.selenium.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import diaceutics.selenium.elements.ComboboxJs;
import diaceutics.selenium.enums.pageFields.AddPlatformFormFields;
import org.openqa.selenium.By;

import java.util.List;

public class AddPlatformForm extends Form {
    private static final String FIELD_TEMPLATE = "//div[./label[text()='%s']]//div[@class='selectContainer']//ng-select[@role='listbox']//span[@class='ng-arrow-wrapper']";

    private final IButton btnAddPlatform = getElementFactory().getButton(
            By.xpath("//form//button[.='Add platform']"), "Add platform");

    public AddPlatformForm() {
        super(By.xpath("//div[contains(@class,'header')]//span[.='Add platform']"), "Add platform");
    }

    public void clickAddPlatform() {
        btnAddPlatform.clickAndWait();
    }

    public String setFieldValue(AddPlatformFormFields field, String value) {
        ComboboxJs comboboxJs = getElementFactory().getCustomElement(
                ComboboxJs.class, By.xpath(String.format(FIELD_TEMPLATE, field.getLocator())), "comboboxJs");

        return comboboxJs.selectByText(value);
    }

    public boolean isFieldContainsValue(AddPlatformFormFields field, String value) {
        ComboboxJs comboboxJs = getElementFactory().getCustomElement(
                ComboboxJs.class, By.xpath(String.format(FIELD_TEMPLATE, field.getLocator())), "comboboxJs");
        List<String> options = comboboxJs.getStringListOptions();

        return AqualityServices.getConditionalWait()
                .waitFor(() -> options.stream().anyMatch(option -> option.equals(value)));
    }

}
