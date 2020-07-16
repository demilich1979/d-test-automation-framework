package diaceutics.selenium.pageobject.forms;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class OrganizationEditIdentityForm extends BaseForm {

    public OrganizationEditIdentityForm() {
        super(By.name("organization_edit_identity"), "Organization Edit Identity");
    }
}
