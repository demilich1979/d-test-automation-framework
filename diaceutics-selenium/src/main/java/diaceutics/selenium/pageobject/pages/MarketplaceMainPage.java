package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class MarketplaceMainPage extends BaseForm {

    private static final String BUTTON_TEMPLATE = "//a[contains(@class,'btn-primary')][contains(text(),'%s')]";

    public MarketplaceMainPage() {
        super(By.xpath("//div[contains(@class,'jumbotron-holder')]"), "Marketplace");
    }

    public void clickByButton(String buttonName) {
        IButton btn = getElementFactory().getButton(By.xpath(
                String.format(BUTTON_TEMPLATE, buttonName)),
                buttonName);

        btn.clickAndWait();
    }
}
