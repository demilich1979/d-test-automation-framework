package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class LabAddressPage extends BaseForm {

    public LabAddressPage() {
        super(By.xpath("//h3[contains(text(),'Lab Address')]"), "Lab Address");
    }

}
