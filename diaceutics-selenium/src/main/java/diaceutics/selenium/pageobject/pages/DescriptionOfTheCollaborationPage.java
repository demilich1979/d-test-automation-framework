package diaceutics.selenium.pageobject.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseMarketplaceForm;
import diaceutics.selenium.utilities.ResourceUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class DescriptionOfTheCollaborationPage extends BaseMarketplaceForm {

    private static final String IMAGE_LINK_TEMPLATE = "//div[@class='image-item'][//input[@value='%s']]";

    private final WebElement chooseImage = AqualityServices.getBrowser().getDriver().findElement(
            By.xpath("//body/input[@type='file'and @accept='.jpg, .gif, .png, .jpeg']"));

    public DescriptionOfTheCollaborationPage() {
        super(By.xpath("//h2[contains(text(),'Describe your collaboration')]"), "Description collaboration");
    }

    public boolean isImageUploaded(String fileName) {
        ILink imageLink = getElementFactory().getLink(
                By.xpath(String.format(IMAGE_LINK_TEMPLATE, fileName)), "Image");

        return imageLink.state().waitForDisplayed();
    }

    public void uploadImage(String fileName) {
        AqualityServices.getBrowser().getDriver()
                .executeScript("return arguments[0].style.visibility = 'visible';", chooseImage);

        chooseImage.sendKeys(ResourceUtil.getResourceUrl(fileName));
    }
}

