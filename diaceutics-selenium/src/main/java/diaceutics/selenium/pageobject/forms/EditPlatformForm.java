package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.elements.ComboboxJs;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class EditPlatformForm extends BaseForm {

    private final IButton btnSaveChanges = getElementFactory().getButton(
            By.xpath("//form//button[.='Save changes']"), "Save changes");

    private final ComboboxJs platformCombobox = getElementFactory().getCustomElement(
            ComboboxJs.class,
            By.xpath("//div[./label[text()='Platform']]//div[@class='selectContainer']//ng-select[@role='listbox']//span[@class='ng-arrow-wrapper']"),
            "Platform");

    public EditPlatformForm() {
        super(By.xpath("//div[contains(@class,'header')]//span[.='Edit platform']"), "Edit platform");
    }

    public void clickSaveChanges() {
        btnSaveChanges.clickAndWait();
    }

    public String setFieldValue(String value) {
        if (value.equals("random")) {
            value = platformCombobox.getRandomValue();
        }
        return platformCombobox.selectByText(value);
    }
}
