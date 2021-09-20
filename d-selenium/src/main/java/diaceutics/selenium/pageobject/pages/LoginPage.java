package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import diaceutics.selenium.models.User;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class LoginPage extends BaseForm {

    private final ITextBox usernameTxb = getElementFactory().getTextBox(By.id("username"), "Username");
    private final ITextBox passwordTxb = getElementFactory().getTextBox(By.id("password"), "Password");
    private final IButton continueBtn = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Continue");

    public LoginPage() {
        super(By.xpath("//main[contains(@class,'login')]"), "Login");
    }

    public void logInAs(User user) {
        usernameTxb.clearAndType(user.getEmail());
        passwordTxb.clearAndType(user.getPassword());
        clickContinue();
    }

    public void clickContinue() {
        continueBtn.clickAndWait();
    }

    public boolean isAlertMessageDisplayed(String message) {
        String isRequire = usernameTxb.getAttribute("required");
        String actualMessage = usernameTxb.getAttribute("validationMessage");
        return isRequire.equals("true")&& actualMessage.equals(message);
    }
}
