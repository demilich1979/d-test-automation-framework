package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.RegisterConfirmedPage;
import io.cucumber.java.en.Given;
import org.testng.Assert;


public class RegisterConfirmedPageSteps {

    private final RegisterConfirmedPage registerConfirmedPage;

    public RegisterConfirmedPageSteps() {
        registerConfirmedPage = new RegisterConfirmedPage();
    }

    @Given("Register Confirmed page is opened")
    public void registerConfirmedPageIsOpened() {
        Assert.assertTrue(registerConfirmedPage.isDisplayed(), "Register Confirmed page should be opened");
    }

}
