package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.selenium.enums.pageFields.FiltersPageFields;
import diaceutics.selenium.pageobject.pages.FiltersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.List;

public class FiltersPageSteps {
    private final FiltersPage filtersPage;

    @Inject
    public FiltersPageSteps() {
        filtersPage = new FiltersPage();
    }

    @Given("Filters page is opened")
    public void filtersPageIsOpened() {
        Assert.assertTrue(filtersPage.isDisplayed(), "Filters page should be opened");
    }

    @Then("I select {string} lab on Filters Labs page")
    public void iSelectCountryOnFiltersLabsPage(String labName) {
        filtersPage.clickByLabLink(labName);
    }

    @Then("All of the following labs for the specific country are displayed:")
    public void allOfTheLabsForTheCountryCountryNameAreDisplayed(List<String> labNames) {
        labNames.forEach((labName) -> {
            SoftAssert.getInstance().assertTrue(filtersPage.isLabDisplayedIndFilterResults(labName),
                    String.format("Lab %s should be displayed in filter results", labName));
        });
    }

    @When("I Set {string} to {string} and press Search icon")
    public void iSetRadiobuttonToAcademicLabAndPressSearchIcon(String field, String value) {
        filtersPage.setFieldValue(FiltersPageFields.getEnumValue(field), value);
        filtersPage.clickSearch();
    }

    @Then("{string} labs are filtered")
    public void academicLabAreFiltered(String filter) {
        SoftAssert.getInstance().assertTrue(filtersPage.isLabAreFiltered(filter),
                String.format("Labs should be filtered by %s", filter));

    }

    @And("Lab {string} is displayed in filter results")
    public void labTestLabIsDisplayedInFilterResults(String labName) {
        Assert.assertTrue(filtersPage.isLabDisplayedIndFilterResults(labName),
                String.format("Lab %s should be displayed in filter results", labName));
    }
}
