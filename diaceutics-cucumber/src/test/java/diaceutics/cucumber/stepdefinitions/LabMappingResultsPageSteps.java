package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.AGGridLabSummaryFormFields;
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

    @And("Lab {string} is displayed in AG-Grid Lab summary on Lab Mapping Results page")
    public void labLabIsDisplayedInAgGridOnLabMappingResultsPage(String key) {
        Lab lab = XmlFileStore.get(key);
        Assert.assertTrue(labMappingResultsPage.getLabMappingResultsGrid().isLabDisplayed(lab),
                String.format("Lab %s should be displayed in Ag Grid on Lab Mapping Results page", lab.getName()));
    }

    @When("I click by {string} in AG-Grid Lab summary on Lab Mapping Results page")
    public void iClickByLabInAgGridOnLabMappingResultsPage(String key) {
        Lab lab = XmlFileStore.get(key);
        labMappingResultsPage.getLabMappingResultsGrid().clickByExpandedLab(lab);
    }

    @Then("Assay {string} with following fields is displayed in AG-Grid Lab summary on Lab Mapping Results page:")
    public void assayWithFollowingFieldsIsDisplayedOnLabMappingResultsPage(String key, List<String> fields) {
        Assay expectedAssay = XmlFileStore.get(key);
        fields.forEach(field -> {
            String expectedValue = field.equals("Biomarkers") ? expectedAssay.getBiomarkers().get(0).getBiomarker() :
                    expectedAssay.getReflectionFieldValue(AGGridLabSummaryFormFields.getEnumValue(field).getModelField());

            String actualValue = labMappingResultsPage.getLabMappingResultsGrid()
                    .getFieldValue(AGGridLabSummaryFormFields.getEnumValue(field));

            SoftAssert.getInstance().assertEquals(
                    actualValue,
                    expectedValue,
                    String.format("Value %s for %s is not correct on Lab Mapping Results page",
                            actualValue, field));
        });
    }

    @And("Label {string} is displayed for Lab {string} in AG-Grid Lab summary on Lab Mapping Results page")
    public void labelIsDisplayedForLabLabInAGGridLabSummaryOnLabMappingResultsPage(String label, String key) {
        Lab lab = XmlFileStore.get(key);
        Assert.assertTrue(labMappingResultsPage.getLabMappingResultsGrid().isLabelDisplayedForLab(label,lab),
                String.format("Label %s for %s should be displayed in AG-Grid Lab summary on Lab Mapping Results page",
                        label, lab.getName()));
    }
}
