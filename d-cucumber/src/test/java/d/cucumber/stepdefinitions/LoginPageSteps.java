package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.models.User;
import diaceutics.selenium.pageobject.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginPageSteps {

    private final LoginPage loginPage;

    public LoginPageSteps() {
        loginPage = new LoginPage();
    }

    @Given("Login page is opened")
    public void loginPageIsOpened() {
        Assert.assertTrue(loginPage.isDisplayed(), "login page should be opened");
    }

    @When("I login as {string} user")
    public void iLoginAsUser(String key) {
        User user = XmlFileStore.get(key);
        loginPage.logInAs(user);
    }

    @When("I click continue on Login page")
    public void iClickContinueOnLoginPage() {
        loginPage.clickContinue();
    }

    @Then("Message {string} is displayed on Login page")
    public void messageWrongEmailOrPasswordIsDisplayedOnLoginPage(String message) {
        Assert.assertTrue(loginPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on Login page", message));

    }

    @Then("Alert message {string} is displayed on Login page")
    public void alertMessagePleaseFillOutThisFieldIsDisplayedOnLoginPage(String message) {
        Assert.assertTrue(loginPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Login page", message));
    }
}
