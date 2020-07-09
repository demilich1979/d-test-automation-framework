package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;


public class EditProfileLabDetailsPage extends BaseForm {

    private final IButton saveBtn = getElementFactory().getButton(
            By.xpath("//form[.//app-lab-details-form]//button[.='Save']"), "Save");

    private final ILink returnToProfileLink = getElementFactory().getLink(
            By.xpath("//ui-alert//span/a[.='Return to profile']"), "Return to profile");

    private final IButton addNewLocationBtn = getElementFactory().getButton(
            By.xpath("//div[contains(@class,'buttons')]//ul[contains(@class,'tabButtons')]"), "Add new location");

    public EditProfileLabDetailsPage() {
        super(By.xpath("//div/h2[.='Lab Details']"), "Edit Profile Lab Details");
    }

    public void clickSave() {
        saveBtn.clickAndWait();
    }

    public void clickReturnToProfile() {
        returnToProfileLink.clickAndWait();
    }

    public void clickAddNewLocation() {
        addNewLocationBtn.clickAndWait();
    }

}
