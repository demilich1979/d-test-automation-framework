package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.forms.MarketplaceHeaderForm;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MarketplaceHeaderFormSteps {

    private final MarketplaceHeaderForm marketplaceHeaderForm;

    public MarketplaceHeaderFormSteps() {
        marketplaceHeaderForm = new MarketplaceHeaderForm();
    }

    @Then("User should be logged in")
    public void userTestUserShouldBeLoggedIn() {
        Assert.assertTrue(marketplaceHeaderForm.isUserLogin(), "User should be logged in");
    }

    @Then("I click {string} on user menu on Marketplace header")
    public void iClickLogoutOnUserMenuOnMarketplaceHeader(String menu) {
        marketplaceHeaderForm.openUserMenu(menu);
    }

    @Then("User should be logout")
    public void userShouldBeLogout() {
        Assert.assertFalse(marketplaceHeaderForm.isUserLogin(), "User should be logout");
    }

    @When("I click {string} on Marketplace header")
    public void iClickLoginOnMarketplaceHeader(String linkName) {
        marketplaceHeaderForm.clickByLink(linkName);
    }
}
