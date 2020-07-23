package diaceutics.selenium.pageobject.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseMarketplaceForm;
import diaceutics.selenium.utilities.ResourceUtil;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class DescriptionOfTheCollaborationPage extends BaseMarketplaceForm {

    private final IButton selectFilesBtn = getElementFactory().getButton(
            By.xpath("//div[@id='listing-images-upload']//button[contains(@class,'select-files')]"), "Select files");

    public DescriptionOfTheCollaborationPage() {
        super(By.xpath("//h2[contains(text(),'Describe your collaboration')]"), "Description collaboration");
    }

//    public void uploadFile(String fileName) {
//
////        AqualityServices.getBrowser().getDriver()
////                .executeScript("return arguments[0].setAttribute('class','visible');", chooseFile);
//        AqualityServices.getBrowser().getDriver()
//                .executeScript("document.getElementById('imageInput').setAttribute('class','visible');");
////        WebElement chooseFile = AqualityServices.getBrowser().getDriver().findElement(By.id("imageInput"));
//        IButton selectFilesBtn = getElementFactory().getButton(
//                By.xpath("//*[@type='file']"), "Select files");
//        selectFilesBtn.sendKeys(ResourceUtil.getResourcePath(fileName));
//
//        AqualityServices.getBrowser().refresh();
//    }

    public boolean isImageAdded(String image) {
        ILink imageLink = getElementFactory().getLink(By.xpath("//div[@class='image-item'][//input[@value='TestImage.png']]"), "Image");
        return imageLink.state().waitForDisplayed();
    }

//    @SneakyThrows
//    public void uploadFile(String fileName) {
//        selectFilesBtn.click();
//        StringSelection ss = new StringSelection(ResourceUtil.getResourcePath(fileName));
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//        Robot robot = new Robot();
//        robot.delay(250);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.delay(50);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//
//    }

    public void uploadFile(String fileName) {
        WebElement chooseFile = AqualityServices.getBrowser().getDriver().findElement(By.id("imageInput"));
        AqualityServices.getBrowser().getDriver()
                .executeScript("document.getElementById('imageInput').setAttribute('class','visible');");
        String u=ResourceUtil.getResourceUrl(fileName);

        chooseFile.sendKeys(u);

    }
}
