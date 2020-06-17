package diaceutics.selenium.forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LabsPage extends Form {

    private static final String COUNTRY_TEMPLATE = "//div[contains(@class,'byCountry')]//span/a[.='%s']";

    private final IButton btnCreateLab = getElementFactory().getButton(By.xpath("//button[text()='Create a Lab']"), "Create a Lab");

    public LabsPage() {
        super(By.id("titleArea"), "Labs");
    }

    public void clickCreateLab() {
        btnCreateLab.clickAndWait();
    }

    public void clickByCountryLink(String countryName) {
        ILink countryLink = getElementFactory().getLink(
                By.xpath(String.format(COUNTRY_TEMPLATE, countryName)),
                String.format("Country %s", countryName));

        countryLink.clickAndWait();
    }

}
