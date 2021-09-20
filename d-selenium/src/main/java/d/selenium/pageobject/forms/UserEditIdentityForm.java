package diaceutics.selenium.pageobject.forms;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class UserEditIdentityForm extends BaseForm {

    public UserEditIdentityForm() {
        super(By.xpath("//h2[.='Identity']"), "Identity");
    }

}
