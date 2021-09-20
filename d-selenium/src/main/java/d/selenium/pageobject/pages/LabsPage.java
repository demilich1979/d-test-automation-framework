package diaceutics.selenium.pageobject.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.Attributes;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.Link;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

import java.util.List;

public class LabsPage extends BaseForm {

    private static final String LAB_TEMPLATE = "//div[contains(@class,'result')]//div//a[.='%s']";
    private static final String LAB_TYPE_TEMPLATE = "//div[contains(@class,'result')]//div//span[..//a]/span[1]";
    private final ILink nextLink = getElementFactory().getLink(
            By.xpath("//div[@class='navigationButtons']//span[.='Next >']"), "Next");

    private final ILink firstLink = getElementFactory().getLink(
            By.xpath("//div[@class='navigationButtons']//span[.='First']"), "First");

    public LabsPage() {
        super(By.xpath("//h3[.='Filters']"), "Labs");
    }

    public void clickByLabLink(String labName) {
        ILink labLink = getElementFactory().getLink(
                By.xpath(String.format(LAB_TEMPLATE, labName)),
                labName);

        labLink.clickAndWait();
    }

    public boolean isLabAreFiltered(String filter) {
        List<Link> labTypeLinks = getElementFactory().findElements(By.xpath
                (LAB_TYPE_TEMPLATE), ElementType.LINK);
        return AqualityServices.getConditionalWait()
                .waitFor(() -> labTypeLinks.stream().allMatch(lab -> lab.getText().equals(filter)));
    }

    public boolean isLabDisplayedIndFilterResults(String labName) {
        firstLink.clickAndWait();
        ILink labLink = getElementFactory().getLink(By.xpath(String.format(LAB_TEMPLATE, labName)), labName);
        while (!labLink.state().waitForDisplayed()
                && !nextLink.getAttribute(Attributes.CLASS.toString()).contains("disabled")) {
            nextLink.clickAndWait();
        }

        return labLink.state().isDisplayed();
    }

}
