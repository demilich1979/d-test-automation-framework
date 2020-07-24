package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseMarketplaceForm;
import diaceutics.selenium.pageobject.forms.PresentationOfTheCollaborationForm;
import org.openqa.selenium.By;

public class EditCollaborationPage extends BaseMarketplaceForm {

    public EditCollaborationPage() {
        super(By.id("asideNavAccordion"), "Edit collaboration");
    }

    public PresentationOfTheCollaborationForm getPresentationOfTheCollaborationForm() {
        return new PresentationOfTheCollaborationForm();
    }
}
