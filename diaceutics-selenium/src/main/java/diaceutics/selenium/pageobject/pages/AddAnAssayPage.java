package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AddAnAssayPage extends BaseForm {

    private static final String ADD_BUTTON_TEMPLATE = "//form//button[.='Add Assay']";

    public AddAnAssayPage() {
        super(By.xpath("//h1[.='Add an assay']"), "Add a location");
    }
    public void clickAdd(String buttonName) {
        IButton btnAdd = getElementFactory().getButton(
                By.xpath(String.format(ADD_BUTTON_TEMPLATE, buttonName)), buttonName);

        btnAdd.clickAndWait();
    }

}
