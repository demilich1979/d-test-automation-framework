package diaceutics.selenium.forms.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.Link;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.forms.BaseForm;
import org.openqa.selenium.By;

public class FiltersLabsPage extends BaseForm {

    private static final String LAB_TEMPLATE = "//div[contains(@class,'result')]//div//a[.='%s']";
    private static final String RADIO_BUTTON_TEMPLATE = "//label[contains(@class,'radioOptionContainer')][.//span[text()='%s']]";
    private static final String LAB_TYPE_TEMPLATE = "//div[contains(@class,'result')]//div//span[..//a]";
    private final IButton btnSearch = getElementFactory().getButton(By.id("icons/icon-search"), "Search");

    public FiltersLabsPage() {
        super(By.xpath("//h3[.='Filters']"), "CountryLabProfile");
    }

    public void clickByLabLink(String labName) {
        ILink countryLink = getElementFactory().getLink(
                By.xpath(String.format(LAB_TEMPLATE, labName)),
                labName);

        countryLink.clickAndWait();
    }

    public void clickRadioButton(String value) {
        IRadioButton radioButton = getElementFactory().getRadioButton(
                By.xpath(String.format(RADIO_BUTTON_TEMPLATE, value)),
                String.format("RadioButton %s", value));
        radioButton.click();
    }

    public void clickSearch() {
        btnSearch.clickAndWait();
    }

    public boolean isLabAreFiltered(String filter) {
        List<Link> labs = getElementFactory().findElements(By.xpath
                (LAB_TYPE_TEMPLATE), ElementType.LINK);
        return AqualityServices.getConditionalWait()
                .waitFor(() -> labs.stream().allMatch(lab -> lab.getText().equals(filter)));
    }

}
