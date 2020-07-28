package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.gridColumns.LabMappingResultsGridColumns;
import diaceutics.selenium.enums.pageFields.CreateLabPageFields;
import diaceutics.selenium.models.Assay;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.pages.LabMappingResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

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
        Assert.assertTrue(labMappingResultsPage.getLabMappingResultsGrid().isLabDisplayed(lab.getName()),
                String.format("Lab %s should be displayed in Ag Grid on Lab Mapping Results page", lab.getName()));
    }

    @When("I click by {string} in Ag Grid on Lab Mapping Results page")
    public void iClickByLabInAgGridOnLabMappingResultsPage(String key) {
        Lab lab = XmlFileStore.get(key);
        labMappingResultsPage.getLabMappingResultsGrid().clickByLab(lab);
    }

    @Then("Assay {string} with following fields is displayed on Lab Mapping Results page:")
    public void assayAssayWithFollowingFieldsIsDisplayedOnLabMappingResultsPage(String key, List<String> fields) {
        Assay expectedAssay = XmlFileStore.get(key);
        fields.forEach(field -> {
            String actualValue = labMappingResultsPage.getLabMappingResultsGrid()
                    .getColumnValue(LabMappingResultsGridColumns.getEnumValue(field));
            String expectedValue = expectedAssay
                    .getReflectionFieldValue(LabMappingResultsGridColumns.getEnumValue(field).getModelField());
            SoftAssert.getInstance().assertEquals(
                    actualValue,
                    expectedValue,
                    String.format("Value %s for %s is not correct on Lab Mapping Results page",
                            actualValue, expectedAssay.getAssayName()));
        });
    }
}
