package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class CreateLabPage extends BaseForm {

    public CreateLabPage() {
        super(By.xpath("//h1[text()='Create a Lab']"), "Create a Lab");
    }

}
