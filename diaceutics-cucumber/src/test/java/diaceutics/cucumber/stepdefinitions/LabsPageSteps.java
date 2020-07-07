package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.selenium.enums.pageFields.LabsPageFields;
import diaceutics.selenium.pageobject.pages.LabsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class LabsPageSteps {
    private final LabsPage labsPage;

    public LabsPageSteps() {
        labsPage = new LabsPage();
    }

    @Given("Labs page is opened")
    public void labsPageIsOpened() {
        Assert.assertTrue(labsPage.isDisplayed(), "Labs page should be opened");
    }

    @Then("I select {string} lab on Labs page")
    public void iSelectCountryOnFiltersLabsPage(String labName) {
        labsPage.clickByLabLink(labName);
    }

    @Then("All of the following labs for the specific country are displayed on Labs page:")
    public void allOfTheLabsForTheCountryCountryNameAreDisplayed(List<String> labNames) {
        labNames.forEach((labName) -> {
            SoftAssert.getInstance().assertTrue(labsPage.isLabDisplayedIndFilterResults(labName),
                    String.format("Lab %s should be displayed in filter results", labName));
        });
    }

    @When("I Set {string} to {string} and press Search icon on Labs page")
    public void iSetRadiobuttonToAcademicLabAndPressSearchIcon(String field, String value) {
        labsPage.setFieldValue(LabsPageFields.getEnumValue(field), value);
        labsPage.clickSearch();
    }

    @Then("{string} labs are filtered on Labs page")
    public void academicLabAreFiltered(String filter) {
        SoftAssert.getInstance().assertTrue(labsPage.isLabAreFiltered(filter),
                String.format("Labs should be filtered by %s", filter));

    }

    @And("Lab {string} is displayed in filter results on Labs page")
    public void labTestLabIsDisplayedInFilterResults(String labName) {
        Assert.assertTrue(labsPage.isLabDisplayedIndFilterResults(labName),
                String.format("Lab %s should be displayed in filter results", labName));
    }
}
