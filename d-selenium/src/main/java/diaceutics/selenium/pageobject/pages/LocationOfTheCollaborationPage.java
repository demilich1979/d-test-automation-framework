package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseMarketplaceForm;
import org.openqa.selenium.By;

public class LocationOfTheCollaborationPage extends BaseMarketplaceForm {

    public LocationOfTheCollaborationPage() {
        super(By.xpath("//h2[contains(text(),'Location of the collaboration')]"), "Location of the collaboration");
    }
}
