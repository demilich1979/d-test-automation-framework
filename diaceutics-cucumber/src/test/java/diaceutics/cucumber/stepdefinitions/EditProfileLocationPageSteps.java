package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.EditProfileLocationPageFields;
import diaceutics.selenium.models.Location;
import diaceutics.selenium.pageobject.pages.EditProfileLocationPage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class EditProfileLocationPageSteps {

    private final EditProfileLocationPage editProfileLocationPage;

    @Inject
    public EditProfileLocationPageSteps() {
        editProfileLocationPage = new EditProfileLocationPage();
    }

    @Given("Edit Profile Location page is opened")
    public void labProfilesPageIsOpened() {
        Assert.assertTrue(editProfileLocationPage.isDisplayed(), "EditProfile Location page should be opened");
    }

    @When("I fill following fields on Edit Profile Location page and save as {string}:")
    public void iSetFieldsOnEditProfileLocationPageUsingFollowingDataAndSaveAsLocation(String key, Map<String, String> data) {
        Location location = new Location();
        data.forEach((field, value) -> {
            if (field.equals("Location name")) {
                value = value + TimeUtil.getTimestamp();
            }
            String selectedValue = editProfileLocationPage.setFieldValue(EditProfileLocationPageFields.getEnumValue(field), value);
            location.setReflectionFieldValue(EditProfileLocationPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, location);
    }

    @And("I click Save on Edit Profile Location page")
    public void iClickSaveOnEditProfileLocationPage() {
        editProfileLocationPage.clickSave();
    }

    @Then("Message {string} is displayed on Edit Profile Location page")
    public void messageLocationUpdatedIsDisplayedOnEditProfileLocationPage(String message) {
        Assert.assertTrue(editProfileLocationPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Edit Profile Location page", message));
    }

    @When("I click Return to profile on Edit Profile Location page")
    public void iClickReturnToProfileOnEditProfileLocationPage() {
        editProfileLocationPage.clickReturnToProfile();
    }

    @When("I clear following fields on Edit Profile Location page:")
    public void iClearFollowingFieldsOnEditProfileLocationPage(List<String> fields) {
        fields.forEach((field) -> {
            editProfileLocationPage.setFieldValue(EditProfileLocationPageFields.getEnumValue(field), "1");
            editProfileLocationPage.sendKeys(EditProfileLocationPageFields.getEnumValue(field), Keys.BACK_SPACE);
        });
    }

    @And("Message {string} is displayed on required fields on Edit Profile Location page")
    public void messagePleaseEnterAValueIsDisplayedOnRequiredFieldsOnEditProfileLocationPage(String message) {
        Assert.assertTrue(editProfileLocationPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Edit Profile Location page", message));
    }
}
