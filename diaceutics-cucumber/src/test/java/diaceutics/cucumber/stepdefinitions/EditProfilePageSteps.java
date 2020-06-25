package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.selenium.enums.pageFields.CreateLabPageFields;
import diaceutics.selenium.enums.pageFields.EditProfilePageFields;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.pages.EditProfilePage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.Map;


public class EditProfilePageSteps {

    private final EditProfilePage editProfilePage;
    private final ScenarioContext scenarioContext;

    @Inject
    public EditProfilePageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        editProfilePage = new EditProfilePage();
    }

    @Given("Edit Profile page is opened")
    public void labProfilesPageIsOpened() {
        Assert.assertTrue(editProfilePage.isDisplayed(), "EditProfile page should be opened");
    }


    @When("I change Edit Profile form using following data and sava as {string}:")
    public void iChangeLabDetailsFormUsingFollowingDataAndSavaAsLab(String key, Map<String, String> data) {
        Lab lab = new Lab();
        data.forEach((field, value) -> {
            if (field.equals("Name")) {
                value = value + TimeUtil.getTimestamp();
            }
            editProfilePage.setFieldValue(EditProfilePageFields.getEnumValue(field), value);
            lab.setReflectionFieldValue(EditProfilePageFields.getEnumValue(field).getModelField(), value);
        });

        scenarioContext.add(key, lab);

    }

    @And("I click Save on Edit Profile page")
    public void iClickSaveEditProfilePage() {
        editProfilePage.clickSave();
    }

    @And("I click Return to profile on Edit Profile page")
    public void iClickReturnToProfileOnEditProfilePage() {
        editProfilePage.clickReturnToProfile();
    }

    @Then("{string} message is displayed on Edit Profile page")
    public void labUpdatedMessageIsDisplayedOnEditProfilePage(String message) {
        Assert.assertTrue(editProfilePage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Edit Profile page", message));
    }

    @And("Message {string} displayed on required fields on Edit Profile page")
    public void messagePleaseInputACountryDisplayedOnRequiredFieldsOnEditProfilePage(String message) {
        Assert.assertTrue(editProfilePage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Edit Profile page", message));
    }

    @When("I clear {string} field on Lab Profile Page")
    public void iClearNameFieldOnLabProfilePage(String field) {
        editProfilePage.setFieldValue(EditProfilePageFields.getEnumValue(field), "1");
        editProfilePage.sendKeys(EditProfilePageFields.getEnumValue(field), Keys.BACK_SPACE);
    }

    @When("I change Edit Profile form using following data:")
    public void iChangeEditProfileFormUsingFollowingData(Map<String, String> data) {
        data.forEach((field, value) -> {
            editProfilePage.setFieldValue(EditProfilePageFields.getEnumValue(field), value);
        });
    }
}
