package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AddCollaborationsPage extends BaseForm {

    public AddCollaborationsPage() {
        super(By.xpath("//div[@class='main mb-4_5 is-expanded']"), "Collaborations");
    }

}
