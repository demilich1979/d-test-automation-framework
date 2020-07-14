package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.utilities.ResourceUtil;
import org.openqa.selenium.By;

public class CompanyLogoForm extends BaseForm {

    private final IButton registerBtn = getElementFactory().getButton(
            By.xpath("//div[contains(@class,'flex-row')]//button[contains(text(),'Register')]"), "Register");

    private final IButton selectFilesBtn = getElementFactory().getButton(
            By.xpath("//button[contains(@class,'select-files')]"), "selectFiles");

    private final ILabel logoLabel = getElementFactory().getLabel(
            By.xpath("//div[@class='dz-image']"), "selectFiles");

    public CompanyLogoForm() {
        super(By.xpath("//h2[.='Company logo']"), "Company logo");
    }

    public void clickRegister() {
        registerBtn.clickAndWait();
    }

    public void selectFile(String fileName) {
        selectFilesBtn.sendKeys(ResourceUtil.getResourcePath(fileName));
        logoLabel.state().waitForDisplayed();
    }

}
