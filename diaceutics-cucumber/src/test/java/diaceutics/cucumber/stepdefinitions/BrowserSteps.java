package diaceutics.cucumber.stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class BrowserSteps {

    @When("I click back on browser")
    public void iClickBackOnBrowser() {
        AqualityServices.getBrowser().goBack();
    }

    @And("I select last window")
    public void iSelectLastWindow() {
        for (String tab : AqualityServices.getBrowser().getDriver().getWindowHandles()) {
            AqualityServices.getBrowser().getDriver().switchTo().window(tab);
        }
    }
}
