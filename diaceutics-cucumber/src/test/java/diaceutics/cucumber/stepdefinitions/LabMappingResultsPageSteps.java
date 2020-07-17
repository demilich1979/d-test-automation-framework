package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.pages.LabMappingResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LabMappingResultsPageSteps {

    private final LabMappingResultsPage labMappingResultsPage;

    public LabMappingResultsPageSteps() {
        labMappingResultsPage = new LabMappingResultsPage();
    }

    @Then("Lab Mapping Results page is opened")
    public void labMappingSearchIsOpened() {
        Assert.assertTrue(labMappingResultsPage.isDisplayed(), "Lab Mapping Results page should be opened");
    }

    @And("Lab {string} is displayed in Ag Grid on Lab Mapping Results page")
    public void labLabIsDisplayedInAgGridOnLabMappingResultsPage(String key) {
        Lab lab = XmlFileStore.get(key);
        Assert.assertTrue(labMappingResultsPage.getAgGrid().isLabDisplayed(lab.getName()),
                String.format("Lab %s should be displayed in Ag Grid on Lab Mapping Results page", lab.getName()));
    }
}
