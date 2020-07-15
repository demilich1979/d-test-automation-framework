package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.forms.MarketplaceHeaderForm;
import io.cucumber.java.en.Then;

public class MarketplaceHeaderFormSteps {

    private final MarketplaceHeaderForm marketplaceHeaderForm;

    public MarketplaceHeaderFormSteps() {
        marketplaceHeaderForm = new MarketplaceHeaderForm();
    }

    @Then("User should be logged in")
    public void userTestUserShouldBeLoggedIn() {
        marketplaceHeaderForm.isUserLogin();
    }

}
