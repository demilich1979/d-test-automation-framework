package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AddBiomarkerForm extends BaseForm {

    private final IButton btnSaveChanges = getElementFactory().getButton(
            By.xpath("//div[@class='addBiomarkerModal']//button[.='Save changes']"), "Save changes");

    public AddBiomarkerForm() {
        super(By.xpath("//div[contains(@class,'header')]//span[.='Add Biomarker']"), "Add Biomarker");
    }

    public void clickSaveChanges() {
        btnSaveChanges.clickAndWait();
    }

}
