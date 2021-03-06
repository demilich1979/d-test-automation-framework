package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class EditProfileLocationPage extends BaseForm {

    private final IButton saveBtn = getElementFactory().getButton(
            By.xpath("//ui-tab//div[not(@hidden)]//app-edit-address//button[.='Save']"), "Save");

    private final ILink returnToProfileLink = getElementFactory().getLink(
            By.xpath("//ui-alert//span/a[.='Return to profile']"), "Return to profile");

    public EditProfileLocationPage() {
        super(By.xpath("//ui-tab//div[not(@hidden)]//app-edit-address/h2[.='Location']"), "Edit Profile Location");
    }

    public void clickSave() {
        saveBtn.clickAndWait();
    }

    public void clickReturnToProfile() {
        returnToProfileLink.clickAndWait();
    }

}
