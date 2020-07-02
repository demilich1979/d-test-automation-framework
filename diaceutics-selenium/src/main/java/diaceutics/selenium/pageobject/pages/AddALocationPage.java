package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AddALocationPage extends BaseForm {

    public AddALocationPage() {
        super(By.xpath("//h1[.='Add a location']"), "Add a location");
    }

}
