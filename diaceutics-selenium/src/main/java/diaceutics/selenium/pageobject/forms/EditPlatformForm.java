package diaceutics.selenium.pageobject.forms;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class EditPlatformForm extends BaseForm {

    public EditPlatformForm() {
        super(By.xpath("//div[contains(@class,'header')]//span[.='Edit platform']"), "Edit platform");
    }

}
