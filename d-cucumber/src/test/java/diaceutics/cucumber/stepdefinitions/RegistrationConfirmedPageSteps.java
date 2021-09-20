package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.RegistrationConfirmedPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class RegistrationConfirmedPageSteps {

    private final RegistrationConfirmedPage registrationConfirmedPage;

    public RegistrationConfirmedPageSteps() {
        registrationConfirmedPage = new RegistrationConfirmedPage();
    }

    @Given("Registration Confirmed page is opened")
    public void registerConfirmedPageIsOpened() {
        Assert.assertTrue(registrationConfirmedPage.isDisplayed(), "Registration Confirmed page should be opened");
    }

    @And("Message {string} is displayed on Registration Confirmed page")
    public void messagePleaseEnterAValueIsDisplayedRegistrationConfirmedPage(String message) {
        Assert.assertTrue(registrationConfirmedPage.isMessageDisplayed(message),
                String.format("Message %s should be displayed on Registration Confirmed page", message));
    }

    @When("I click Back to dxrx-marketplace on Registration Confirmed page")
    public void iClickBackToDxrxMarketplaceOnRegistrationConfirmedPage() {
        registrationConfirmedPage.clickBackToMarketplaceLink();
    }
}
