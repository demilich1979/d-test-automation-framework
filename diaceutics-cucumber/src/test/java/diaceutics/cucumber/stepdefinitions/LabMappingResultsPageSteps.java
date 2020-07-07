package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.pages.LabMappingResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import javax.inject.Inject;

public class LabMappingResultsPageSteps {

    private final LabMappingResultsPage labMappingResultsPage;
    private final ScenarioContext scenarioContext;

    @Inject
    public LabMappingResultsPageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        labMappingResultsPage = new LabMappingResultsPage();
    }

    @Then("Lab Mapping Results page is opened")
    public void labMappingSearchIsOpened() {
        Assert.assertTrue(labMappingResultsPage.isDisplayed(), "Lab Mapping Results page should be opened");
    }

    @And("Lab {string} is displayed in Ag Grid on Lab Mapping Results page")
    public void labLabIsDisplayedInAgGridOnLabMappingResultsPage(String key) {
        Lab lab = scenarioContext.get(key);
        Assert.assertTrue(labMappingResultsPage.getAgGrid().isLabDisplayed(lab.getName()),
                String.format("Lab %s should be displayed in Ag Grid on Lab Mapping Results page", lab.getName()));
    }
}
