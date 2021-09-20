package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.Label;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

import java.util.List;

public class RegistrationConfirmedPage extends BaseForm {

    private static final String MESSAGE_TEMPLATE = "//section//div[.='%s']";
    private final ILink backToMarketplaceLink = getElementFactory().getLink(
            By.xpath("//a[contains(text(),'Back to dxrx-marketplace')]"),
            "Back to dxrx-marketplace");

    public RegistrationConfirmedPage() {
        super(By.xpath("//div[@class='ulp-box-inner _prompt-box']"), "Register confirmed");
    }

    public boolean isMessageDisplayed(String message) {
        List<Label> messageLink = getElementFactory().findElements(
                By.xpath(String.format(MESSAGE_TEMPLATE, message)), ElementType.LABEL);
        return messageLink.size() > 0;
    }

    public void clickBackToMarketplaceLink() {
        backToMarketplaceLink.clickAndWait();
    }
}
