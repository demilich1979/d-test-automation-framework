package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.MarketplaceMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MarketplaceMainPageSteps {

    private final MarketplaceMainPage marketplaceMainPage;

    public MarketplaceMainPageSteps() {
        marketplaceMainPage = new MarketplaceMainPage();
    }

    @Given("Marketplace Main page is opened")
    public void marketplaceMainPageIsOpened() {
        Assert.assertTrue(marketplaceMainPage.isDisplayed(), "Marketplace Main page should be opened");
    }

    @When("I click {string} on Marketplace Main page")
    public void iClickLoginOnMarketplaceMainPage(String buttonName) {
        marketplaceMainPage.clickByLinkOnTheMiddleOfThePage(buttonName);
    }

    @When("I click link {string} on the bottom of the Marketplace Main page")
    public void iClickLinkLoginOnTheBottomOfTheMarketplaceMainPage(String linkName) {
        marketplaceMainPage.clickByLInkOnTheBottomOfThePage(linkName);
    }
}
