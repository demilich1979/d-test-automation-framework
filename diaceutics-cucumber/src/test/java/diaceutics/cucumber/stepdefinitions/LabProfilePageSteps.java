package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
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
            labProfilePage.getAddPlatformForm().setFieldValue(AddPlatformFormFields.getEnumValue(field), value);
            platform.setReflectionFieldValue(AddPlatformFormFields.getEnumValue(field).getModelField(), value);
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

    @Then("I sort data by alphabet in Platform manufactured column in Platforms table on Lab Profile Page")
    public void iSortDataByAlphabetOnPlatformsTableOnLabProfilePage() {
        labProfilePage.clickSortColumnPlatformManufactured();
    }
}
