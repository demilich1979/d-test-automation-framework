package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import diaceutics.selenium.elements.ComboboxJs;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class LabsPage extends BaseForm {

    private static final String COUNTRY_TEMPLATE = "//div[contains(@class,'byCountry')]//span/a[.='%s']";

    private final IButton btnCreateLab = getElementFactory().getButton(By.xpath("//button[.='Create a Lab']"), "Create a Lab");
    private final IButton btnSearch = getElementFactory().getButton(By.name("search"), "Search");
    private final ITextBox searchField = getElementFactory().getTextBox(
            By.xpath("//ui-search/input[contains(@placeholder,'Enter keywords')]"), "Search field");

    private final ComboboxJs allCountriesCombobox = getElementFactory().getCustomElement(
            ComboboxJs.class,
            By.xpath("//ui-select[@placeholder='Country']//span[@class='ng-arrow-wrapper']"),
            "All Countries");

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

    public void chooseCountry(String country) {
        allCountriesCombobox.selectByText(country);
    }

    public void clickSearch() {
        btnSearch.clickAndWait();
    }

    public void putTextInSearchField(String text) {
        searchField.clearAndType(text);
    }

}
