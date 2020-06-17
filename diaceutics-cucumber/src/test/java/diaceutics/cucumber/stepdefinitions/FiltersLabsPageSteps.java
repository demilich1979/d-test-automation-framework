package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.forms.pages.FiltersLabsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class FiltersLabsPageSteps {
    private final FiltersLabsPage filtersLabsPage;

    public FiltersLabsPageSteps() {
        filtersLabsPage = new FiltersLabsPage();
    }

    @Given("Filters Labs page is opened")
    public void filtersLabsPageIsOpened() {
        Assert.assertTrue(filtersLabsPage.isDisplayed(), "Filters labs page should be opened");
    }

    @Then("I select {string} lab on Filters Labs page")
    public void iSelectCountryOnFiltersLabsPage(String labName) {
        filtersLabsPage.clickByLabLink(labName);
    }
}
