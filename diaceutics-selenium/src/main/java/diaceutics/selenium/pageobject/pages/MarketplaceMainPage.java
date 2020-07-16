package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class MarketplaceMainPage extends BaseForm {

    private static final String LINK_OF_THE_MIDDLE_TEMPLATE = "//a[contains(@class,'btn-primary')][contains(text(),'%s')]";
    private static final String LINK_OF_THE_BOTTOM_TEMPLATE = "//div[@class='pt-2 text-size-default']//a[contains(text(),'%s')]";

    public MarketplaceMainPage() {
        super(By.xpath("//div[contains(@class,'jumbotron-holder')]"), "Marketplace");
    }

    public void clickByLinkOnTheMiddleOfThePage(String linkName) {
        IButton link = getElementFactory().getButton(
                By.xpath(String.format(LINK_OF_THE_MIDDLE_TEMPLATE, linkName)), linkName);

        link.clickAndWait();
    }

    public void clickByLInkOnTheBottomOfThePage(String linkName) {
        ILink link = getElementFactory().getLink(
                By.xpath(String.format(LINK_OF_THE_BOTTOM_TEMPLATE, linkName)), linkName);

        link.clickAndWait();
    }
}
