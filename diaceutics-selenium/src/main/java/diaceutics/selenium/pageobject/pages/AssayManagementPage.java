package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.elements.ComboboxJs;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AssayManagementPage extends BaseForm {

    private static final String COUNTRY_TEMPLATE = "//div[contains(@class,'byCountry')]//span/a[.='%s']";
    private final ComboboxJs allCountriesCombobox = getElementFactory().getCustomElement(
            ComboboxJs.class,
            By.xpath("//ui-select[@placeholder='Country']//span[@class='ng-arrow-wrapper']"),
            "All Countries");

    public AssayManagementPage() {
        super(By.id("titleArea"), "Assay Management");
    }

    public void clickByCountryLink(String countryName) {
        ILink countryLink = getElementFactory().getLink(
                By.xpath(String.format(COUNTRY_TEMPLATE, countryName)),
                String.format("Country %s", countryName));

        countryLink.clickAndWait();
    }

    public void chooseCountry(String country) {
        allCountriesCombobox.selectByText(country);
    }

}
