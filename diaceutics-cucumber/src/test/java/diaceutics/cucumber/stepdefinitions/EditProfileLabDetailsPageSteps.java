package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.selenium.enums.pageFields.EditProfileLabDetailsPageFields;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.pages.EditProfileLabDetailsPage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.Map;

public class EditProfileLabDetailsPageSteps {

    private final EditProfileLabDetailsPage editProfileLabDetailsPage;
    private final ScenarioContext scenarioContext;

    @Inject
    public EditProfileLabDetailsPageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        editProfileLabDetailsPage = new EditProfileLabDetailsPage();
    }

    @Given("Edit Profile Lab Details page is opened")
    public void editProfileLabDetailsPageIsOpened() {
        Assert.assertTrue(editProfileLabDetailsPage.isDisplayed(), "Edit Profile Lab Details page should be opened");
    }


    @When("I fill following fields on Edit Profile Lab Details page and save as {string}:")
    public void iChangeLabDetailsFormUsingFollowingDataAndSavaAsLab(String key, Map<String, String> data) {
        Lab lab = new Lab();
        data.forEach((field, value) -> {
            if (field.equals("Name")) {
                value = value + TimeUtil.getTimestamp();
            }
            String selectedValue = editProfileLabDetailsPage.setFieldValue(EditProfileLabDetailsPageFields.getEnumValue(field), value);
            lab.setReflectionFieldValue(EditProfileLabDetailsPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        scenarioContext.add(key, lab);

    }

    @And("I click Save on Edit Profile Lab Details page")
    public void iClickSaveEditProfilePage() {
        editProfileLabDetailsPage.clickSave();
    }

    @And("I click Return to profile on Edit Profile Lab Details page")
    public void iClickReturnToProfileOnEditProfilePage() {
        editProfileLabDetailsPage.clickReturnToProfile();
    }

    @Then("Message {string} is displayed on Edit Profile Lab Details page")
    public void labUpdatedMessageIsDisplayedOnEditProfilePage(String message) {
        Assert.assertTrue(editProfileLabDetailsPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Edit Profile Lab Details page", message));
    }

    @And("Message {string} is displayed on required fields on Edit Profile Lab Details page")
    public void messagePleaseInputACountryDisplayedOnRequiredFieldsOnEditProfilePage(String message) {
        Assert.assertTrue(editProfileLabDetailsPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Edit Profile Lab Details page", message));
    }

    @When("I clear {string} field on Edit Profile Lab Details page")
    public void iClearNameFieldOnLabProfilePage(String field) {
        editProfileLabDetailsPage.setFieldValue(EditProfileLabDetailsPageFields.getEnumValue(field), "1");
        editProfileLabDetailsPage.sendKeys(EditProfileLabDetailsPageFields.getEnumValue(field), Keys.BACK_SPACE);
    }

    @When("I change Edit Profile Lab Details page using following data:")
    public void iChangeEditProfileFormUsingFollowingData(Map<String, String> data) {
        data.forEach((field, value) -> {
            editProfileLabDetailsPage.setFieldValue(EditProfileLabDetailsPageFields.getEnumValue(field), value);
        });
    }

    @Then("I click Add new location on Edit Profile page")
    public void iClickAddNewLocationOnEditProfilePage() {
        editProfileLabDetailsPage.clickAddNewLocation();
    }
}
