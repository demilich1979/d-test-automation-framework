package diaceutics.selenium.forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import diaceutics.selenium.forms.AddPlatformForm;
import org.openqa.selenium.By;

public class LabProfilePage extends Form {

    private final IButton btnAddPlatform = getElementFactory().getButton(
            By.xpath("//div[contains(@class,'titleArea')]//button[.='Add platform']"), "Add platform");

    private final IButton btnSortColumnPlatformManufactured = getElementFactory().getButton(
            By.id("icons/icon-chevron-up"), "Add platform");

    public LabProfilePage() {
        super(By.id("viewLabContainer"), "LabProfile");
    }

    public AddPlatformForm getAddPlatformForm() {
        return new AddPlatformForm();
    }

    public void clickAddPlatform() {
        btnAddPlatform.clickAndWait();
    }

    public void clickSortColumnPlatformManufactured() {
        btnSortColumnPlatformManufactured.clickAndWait();
    }

}
