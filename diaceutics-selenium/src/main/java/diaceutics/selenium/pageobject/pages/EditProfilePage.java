package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;


public class EditProfilePage extends BaseForm {

    private final IButton btnSave = getElementFactory().getButton(
            By.xpath("//form[.//app-lab-details-form]//button[.='Save']"), "Save");

    private final ILink linkReturnToProfile = getElementFactory().getLink(
            By.xpath("//ui-alert//span/a[.='Return to profile']"), "Return to profile");

    private final IButton btnAddNewLocation = getElementFactory().getButton(
            By.xpath("//div[contains(@class,'buttons')]//ul[contains(@class,'tabButtons')]"), "Add new location");

    public EditProfilePage() {
        super(By.xpath("//h1[.='Edit Profile']"), "Edit Profile");
    }

    public void clickSave() {
        btnSave.clickAndWait();
    }

    public void clickReturnToProfile() {
        linkReturnToProfile.clickAndWait();
    }

    public void clickAddNewLocation() {
        btnAddNewLocation.clickAndWait();
    }

}
