package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.SearchResultsPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;


public class SearchResultsPageSteps {

    private final SearchResultsPage searchResultsPage;

    public SearchResultsPageSteps() {
        searchResultsPage = new SearchResultsPage();
    }

    @Then("SearchResults page is opened")
    public void marketplaceMainPageIsOpened() {
        Assert.assertTrue(searchResultsPage.isDisplayed(), "SearchResults page should be opened");
    }

}
