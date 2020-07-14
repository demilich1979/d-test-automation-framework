package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {

    public HomePage() {
        super(By.id("main"), "Home");
    }

}
