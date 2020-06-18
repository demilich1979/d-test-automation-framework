package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.selenium.enums.pageFields.AddPlatformFormFields;
import diaceutics.selenium.forms.pages.LabProfilePage;
import diaceutics.selenium.models.Platform;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.Map;

public class LabProfilePageSteps {
    private final LabProfilePage labProfilePage;
    private final ScenarioContext scenarioContext;

    @Inject
    public LabProfilePageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        labProfilePage = new LabProfilePage();
    }

    @Given("LabProfile page is opened")
    public void labProfilesPageIsOpened() {
        Assert.assertTrue(labProfilePage.isDisplayed(), "LabProfile page should be opened");
    }

    @When("I click on Add Platform on Lab Profile Page")
    public void iClickOnAddPlatformOnLabProfilePage() {
        labProfilePage.clickAddPlatform();
    }

    @Then("Add Platform form is opened")
    public void addPlatformFormIsOpened() {
        Assert.assertTrue(labProfilePage.getAddPlatformForm().isDisplayed(), "Add Platform form should be opened");
    }

    @When("I fill following fields on Add Platform Form and save as {string}:")
    public void iFillFollowingFieldsOnAddPlatformFormAndSaveAsNewPlatform(String key, Map<String, String> data) {
        Platform platform = new Platform();
        data.forEach((field, value) -> {
            String selectedValue = labProfilePage.getAddPlatformForm().setFieldValue(AddPlatformFormFields.getEnumValue(field), value);
            platform.setReflectionFieldValue(AddPlatformFormFields.getEnumValue(field).getModelField(), selectedValue);
        });

        labProfilePage.getAddPlatformForm().clickAddPlatform();
        scenarioContext.add(key, platform);
    }

    @And("Field {string} does not contains value from {string}")
    public void fieldPlatformDoesNotContainsValueFromNewPlatform(String field, String key) {
        Platform platform = scenarioContext.get(key);
        String value = platform.getReflectionFieldValue(AddPlatformFormFields.getEnumValue(field).getModelField());
        Assert.assertFalse(labProfilePage.getAddPlatformForm().isFieldContainsValue(AddPlatformFormFields.getEnumValue(field), value),
                String.format("value %S should not be in the %s field", value, field));

    }

    @Then("{string} added in Platforms table")
    public void platformAddedInPlatformsTable(String key) {
        Platform platform = scenarioContext.get(key);

        Assert.assertTrue(labProfilePage.isPlatformAdded(platform),
                String.format("Platform with values %s, %s should be added in Platforms table",
                        platform.getPlatformManufacturer(), platform.getPlatform()));

    }

    @When("I sort data by alphabet in {string} column")
    public void iSortDataByAlphabetInPlatformManufacturedColumn(String column) {
        labProfilePage.clickSortColumn(column);
    }

    @Then("Data in {string} column sorted according to alphabet")
    public void dataInPlatformManufacturedColumnSortedAccordingToAlphabet(String column) {
        SoftAssert.getInstance().assertTrue(labProfilePage.isDataInColumnInPlatformGridSorted(column),
                String.format("Data in %s column should be sorted according to alphabet", column));
    }

    @Then("On Lab Profile page check numbers of platforms in the grid")
    public void onLabProfilePageCheckNumbersOfPlatformsInTheGrid() {
        Assert.assertEquals(labProfilePage.getNumberOfPlatformsFromGrid(),
                labProfilePage.getNumberOfPlatformsFromHead(),
                "The number of rows in Platform grid must be the same as a number stated in the Platforms grid title");

    }

    @When("On Lab Profile Page click on Edit button for the {string} platform")
    public void onLabProfilePageClickOnEditButtonForTheNewPlatformPlatform(String key) {
        Platform platform = scenarioContext.get(key);
        labProfilePage.clickEditButton(platform);
    }


}
