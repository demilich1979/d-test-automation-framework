package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AddAnAssayPage extends BaseForm {

    private final IButton btnAddBiomarker = getElementFactory().getButton(
            By.xpath("//form//button[.='Add Biomarker']"), "Add Biomarker");

    public AddAnAssayPage() {
        super(By.xpath("//h1[.='Add an assay']"), "Add a location");
    }

    public void clickAddBiomarker() {
        btnAddBiomarker.clickAndWait();
    }

}
