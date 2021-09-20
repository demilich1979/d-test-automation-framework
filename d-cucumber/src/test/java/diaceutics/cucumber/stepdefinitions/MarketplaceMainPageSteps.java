package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.LabAddressPageFields;
import diaceutics.selenium.enums.pageFields.MarketplaceMainPageFields;
import diaceutics.selenium.models.MarketplaceSearchTemplate;
import diaceutics.selenium.pageobject.pages.MarketplaceMainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

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

    @When("I fill following fields on Search form on Marketplace Main page and save as {string}:")
    public void iFillFollowingFieldsOnSearchFormOnMarketplaceMainPageAndSave(String key, Map<String, String> data) {
        MarketplaceSearchTemplate template = new MarketplaceSearchTemplate();
        data.forEach((field, value) -> {
            String selectedValue = marketplaceMainPage.setFieldValue(MarketplaceMainPageFields.getEnumValue(field), value);
            template.setReflectionFieldValue(MarketplaceMainPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, template);
    }

    @And("I click Search on Search form on Marketplace Main page")
    public void iClickSearchOnSearchFormOnMarketplaceMainPage() {
        marketplaceMainPage.clickSearch();
    }
}
