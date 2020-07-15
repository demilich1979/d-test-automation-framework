package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AssayDetailsPage extends BaseForm {

    private final ILink editDetailsLink = getElementFactory().getLink(
            By.xpath("//a//span[.='Edit Details']"), "Edit Details");

    public AssayDetailsPage() {
        super(By.xpath("//h3[.='Assay details']"), "Assay details");
    }

    public void clickEditDetails() {
        editDetailsLink.clickAndWait();
    }
}
