package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.UserEditIdentityForm;
import org.openqa.selenium.By;

public class MyProfilePage extends BaseForm {

    public MyProfilePage() {
        super(By.name("user"), "My profile");
    }

    public UserEditIdentityForm getUserEditIdentityForm() {
        return new UserEditIdentityForm();
    }

}
