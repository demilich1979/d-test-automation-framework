package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class EditAssayPage extends BaseForm {

    private final IButton btnSave = getElementFactory().getButton(
            By.xpath("//form//button[.='Save']"), "Save");

    public EditAssayPage() {
        super(By.xpath("//h1[.='Edit assay']"), "Edit assay");
    }

    public void clickSave() {
        btnSave.clickAndWait();
    }

}
