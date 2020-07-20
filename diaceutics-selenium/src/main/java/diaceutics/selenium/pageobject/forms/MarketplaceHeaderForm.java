package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class MarketplaceHeaderForm extends BaseForm {

    private static final String LINK_TEMPLATE = "//ul[contains(@class,'justify-content-lg-end')]//a[contains(text(),'%s')]";
    private static final String USER_MENU_TEMPLATE = "//div[contains(@class,'dropdown-menu')]//a[contains(text(),'%s')]";

    private final ILink userLink = getElementFactory().getLink(By.id("user-dropdown"), "User");

    public MarketplaceHeaderForm() {
        super(By.xpath("//header[contains(@class,'header-bar')]"), "Marketplace Header");
    }

    public void clickByLink(String linkName) {
        ILink link = getElementFactory().getLink(By.xpath(String.format(LINK_TEMPLATE, linkName)), linkName);
        link.clickAndWait();
    }

    public boolean isUserLogin() {
        return userLink.state().waitForDisplayed();
    }

    public void openUserMenu(String menu) {
        userLink.clickAndWait();
        ILink menuLink = getElementFactory().getLink(
                By.xpath(String.format(USER_MENU_TEMPLATE, menu)), menu);
        menuLink.clickAndWait();
    }

}
