package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.forms.pages.FiltersLabsPage;
import diaceutics.selenium.models.Lab;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.List;

public class FiltersLabsPageSteps {
    private final FiltersLabsPage filtersLabsPage;
    private final ScenarioContext scenarioContext;

    @Inject
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

    @Then("All of the following labs for the specific country are displayed:")
    public void allOfTheLabsForTheCountryCountryNameAreDisplayed(List<String> keys) {
        keys.forEach((labKey) -> {
            Lab createLabInfo = XmlFileStore.get(labKey);
            SoftAssert.getInstance().assertTrue(filtersLabsPage.isLabDisplayedIndFilterResults(createLabInfo.getName()),
                    String.format("Lab %s should be displayed in filter results", createLabInfo.getName()));
        });
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

    @And("Lab {string} is displayed in filter results")
    public void labTestLabIsDisplayedInFilterResults(String labName) {
        Assert.assertTrue(filtersLabsPage.isLabDisplayedIndFilterResults(labName),
                String.format("Lab %s should be displayed in filter results", labName));
    }
}
