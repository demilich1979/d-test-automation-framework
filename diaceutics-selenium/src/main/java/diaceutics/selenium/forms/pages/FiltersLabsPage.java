package diaceutics.selenium.forms.pages;

import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.forms.BaseForm;
import org.openqa.selenium.By;

public class FiltersLabsPage extends BaseForm {

    private static final String LAB_TEMPLATE = "//div[contains(@class,'result')]//div//a[.='%s']";

    public FiltersLabsPage() {
        super(By.xpath("//h3[.='Filters']"), "CountryLabProfile");
    }

    public void clickByLabLink(String labName) {
        ILink countryLink = getElementFactory().getLink(
                By.xpath(String.format(LAB_TEMPLATE, labName)),
                labName);

        countryLink.clickAndWait();
    }

}
