package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.selenium.forms.pages.FiltersLabsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FiltersLabsPageSteps {
    private final FiltersLabsPage filtersLabsPage;
    private final ScenarioContext scenarioContext;

    public FiltersLabsPageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
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

    @Then("All of the labs for the country {string} are displayed")
    public void allOfTheLabsForTheCountryCountryNameAreDisplayed(String key) {
        String country = scenarioContext.get(key);
//to do
    }

    @When("I Set radiobutton to {string} and press Search icon")
    public void iSetRadiobuttonToAcademicLabAndPressSearchIcon(String value) {
        filtersLabsPage.clickRadioButton(value);
        filtersLabsPage.clickSearch();
    }

    @Then("{string} lab are filtered")
    public void academicLabAreFiltered(String filter) {
        SoftAssert.getInstance().assertTrue(filtersLabsPage.isLabAreFiltered(filter),
                String.format("Labs should be filtered by %s", filter));

    }
}
