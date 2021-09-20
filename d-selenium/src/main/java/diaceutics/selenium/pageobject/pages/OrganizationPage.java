package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.OrganizationEditIdentityForm;
import org.openqa.selenium.By;

public class OrganizationPage extends BaseForm {

    private static final String LINK_TEMPLATE = "//span[contains(text(),'%s')]";

    public OrganizationPage() {
        super(By.id("main-form"), "Organization");
    }

    public OrganizationEditIdentityForm getOrganizationEditIdentityForm() {
        return new OrganizationEditIdentityForm();
    }

    public void clickByLink(String linkName) {
        ILink link = getElementFactory().getLink(By.xpath(String.format(LINK_TEMPLATE, linkName)), linkName);
        link.clickAndWait();
    }
}
