package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AssayDescriptionPage extends BaseForm {

    private final ILink editDetailsLink = getElementFactory().getLink(
            By.xpath("//a//span[.='Edit Details']"), "Edit Details");

    public AssayDescriptionPage() {
        super(By.xpath("//h4[.='Assay description']"), "Assay description");
    }

    public void clickEditDetails() {
        editDetailsLink.clickAndWait();
    }
}
