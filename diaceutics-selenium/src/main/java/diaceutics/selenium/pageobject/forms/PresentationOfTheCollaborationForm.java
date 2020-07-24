package diaceutics.selenium.pageobject.forms;

import diaceutics.selenium.pageobject.BaseMarketplaceForm;
import org.openqa.selenium.By;

public class PresentationOfTheCollaborationForm extends BaseMarketplaceForm {

    public PresentationOfTheCollaborationForm() {
        super(By.xpath("//li//span[contains(text(),'Presentation')]"), "Presentation of the collaboration");
    }

}
