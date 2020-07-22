package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class CollaborationsPage extends BaseForm {

    public CollaborationsPage() {
        super(By.xpath("//div[@class='container']//div[@class='flashes']"), "Collaborations");
    }

}
