package diaceutics.selenium.pageobject.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.Link;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

import java.util.List;

public class FiltersPage extends BaseForm {

    private static final String LAB_TEMPLATE = "//div[contains(@class,'result')]//div//a[.='%s']";
    private static final String LAB_TYPE_TEMPLATE = "//div[contains(@class,'result')]//div//span[..//a]/span[1]";
    private final IButton btnSearch = getElementFactory().getButton(By.name("search"), "Search");

    public FiltersPage() {
        super(By.xpath("//h3[.='Filters']"), "CountryLabProfile");
    }

    public void clickByLabLink(String labName) {
        ILink countryLink = getElementFactory().getLink(
                By.xpath(String.format(LAB_TEMPLATE, labName)),
                labName);

        countryLink.clickAndWait();
    }

    public void clickSearch() {
        btnSearch.clickAndWait();
    }

    public boolean isLabAreFiltered(String filter) {
        List<Link> labTypeLinks = getElementFactory().findElements(By.xpath
                (LAB_TYPE_TEMPLATE), ElementType.LINK);
        return AqualityServices.getConditionalWait()
                .waitFor(() -> labTypeLinks.stream().allMatch(lab -> lab.getText().equals(filter)));
    }

    public boolean isLabDisplayedIndFilterResults(String labName) {
        List<IElement> labLink = getElementFactory().findElements(By.xpath
                (String.format(LAB_TEMPLATE, labName)), ElementType.LINK);
        return labLink.size() > 0;
    }

}
