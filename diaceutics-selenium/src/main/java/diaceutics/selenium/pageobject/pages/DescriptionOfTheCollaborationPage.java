package diaceutics.selenium.pageobject.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseMarketplaceForm;
import diaceutics.selenium.utilities.JavaScriptUtil;
import diaceutics.selenium.utilities.ResourceUtil;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class DescriptionOfTheCollaborationPage extends BaseMarketplaceForm {

    private static final String FILE_LINK_TEMPLATE = "//div[contains(@class,'item') and @data-filename][//input[@value='%s']]";
    private static final String INPUT_TEMPLATE = "//body/input[@type='file' and contains(@accept,'%s')]";
    private static final String ALERT_MESSAGE_TEMPLATE = "//h6[contains(text(),'%s')]";
    private final ILink videosLink = getElementFactory().getLink(By.id("videos-tab"), "Videos");
    private final IButton addVideoBtn = getElementFactory().getButton(By.id("video-add-button"), "Add video");

    public DescriptionOfTheCollaborationPage() {
        super(By.xpath("//h2[contains(text(),'Describe your collaboration')]"), "Description collaboration");
    }

    public void uploadFile(String fileName) {
        String extension = FilenameUtils.getExtension(fileName);
        WebElement chooseFile = AqualityServices.getBrowser().getDriver().findElement(
                By.xpath(String.format(INPUT_TEMPLATE, extension)));

        JavaScriptUtil.makeElementStyleVisible(chooseFile);
        chooseFile.sendKeys(ResourceUtil.getResourceUrl(fileName));
    }

    public boolean isFileUploaded(String fileName) {
        ILink imageLink = getElementFactory().getLink(
                By.xpath(String.format(FILE_LINK_TEMPLATE, fileName)), fileName);

        return imageLink.state().waitForDisplayed();
    }

    public void clickByVideos() {
        videosLink.clickAndWait();
        videosLink.getJsActions().scrollIntoView();
    }

    public void clickAddVideo() {
        addVideoBtn.clickAndWait();
    }

    @Override
    public boolean isAlertMessageDisplayed(String message) {
        ILabel alertLink = getElementFactory().getLabel(
                By.xpath(String.format(ALERT_MESSAGE_TEMPLATE, message)), message);
        return alertLink.state().waitForDisplayed();
    }
}
