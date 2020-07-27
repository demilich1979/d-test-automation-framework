package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseMarketplaceForm;
import diaceutics.selenium.pageobject.forms.CategoriesOfTheCollaborationForm;
import diaceutics.selenium.pageobject.forms.PresentationOfTheCollaborationForm;
import org.openqa.selenium.By;

public class EditCollaborationPage extends BaseMarketplaceForm {

    private static final String LINK_TEMPLATE = "//li[@class='mb-1']//a[contains(text(),'%s')]";

    public EditCollaborationPage() {
        super(By.id("asideNavAccordion"), "Edit collaboration");
    }

    public PresentationOfTheCollaborationForm getPresentationOfTheCollaborationForm() {
        return new PresentationOfTheCollaborationForm();
    }

    public CategoriesOfTheCollaborationForm getCategoriesOfTheCollaborationForm() {
        return new CategoriesOfTheCollaborationForm();
    }

    public void clickLink(String linkName){
        ILink link = getElementFactory().getLink(
                By.xpath(String.format(LINK_TEMPLATE, linkName)), linkName);

        link.clickAndWait();
    }
}
