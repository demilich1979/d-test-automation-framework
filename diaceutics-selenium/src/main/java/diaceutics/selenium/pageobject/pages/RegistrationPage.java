package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.PersonalDetailsForm;
import org.openqa.selenium.By;

public class RegistrationPage extends BaseForm {

    public RegistrationPage() {
        super(By.id("form-registerlogin"), "Registration");
    }

    public PersonalDetailsForm getPersonalDetailsForm() {
        return new PersonalDetailsForm();
    }

}
