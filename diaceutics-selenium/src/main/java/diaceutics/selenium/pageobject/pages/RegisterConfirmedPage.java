package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class RegisterConfirmedPage extends BaseForm {

    public RegisterConfirmedPage() {
        super(By.xpath("//h1[.='Registration confirmed']"), "Register confirmed");
    }

}
