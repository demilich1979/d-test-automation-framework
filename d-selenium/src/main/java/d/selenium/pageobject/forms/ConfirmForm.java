package diaceutics.selenium.pageobject.forms;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class ConfirmForm extends BaseForm {

    public ConfirmForm() {
        super(By.xpath("//div[contains(@class,'header')]//span[.='Confirm']"), "Confirm");
    }
}
