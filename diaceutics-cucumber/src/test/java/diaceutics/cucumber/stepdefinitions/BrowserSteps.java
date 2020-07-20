package diaceutics.cucumber.stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.When;

public class BrowserSteps {

    @When("I click back on browser")
    public void iClickBackOnBrowser() {
        AqualityServices.getBrowser().goBack();
    }

}
