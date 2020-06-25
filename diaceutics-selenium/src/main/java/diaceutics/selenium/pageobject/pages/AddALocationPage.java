package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AddALocationPage extends BaseForm {

    private final IButton btnAddLocation = getElementFactory().getButton(
            By.xpath("//form//button[.='Add Location']"), "Add Location");

    public AddALocationPage() {
        super(By.xpath("//h1[.='Add a location']"), "Add a location");
    }

    public void clickAddLocation() {
        btnAddLocation.clickAndWait();
    }

}
