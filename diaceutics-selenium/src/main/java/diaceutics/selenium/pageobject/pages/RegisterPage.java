package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.CompanyLogoForm;
import diaceutics.selenium.pageobject.forms.PersonalDetailsForm;
import org.openqa.selenium.By;

public class RegisterPage extends BaseForm {

    public RegisterPage() {
        super(By.id("form-registerlogin"), "Register");
    }

    public PersonalDetailsForm getPersonalDetailsForm() {
        return new PersonalDetailsForm();
    }

    public CompanyLogoForm getCompanyLogoForm() {
        return new CompanyLogoForm();
    }
}
