package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.AddALocationPageFields;
import diaceutics.selenium.models.Location;
import diaceutics.selenium.pageobject.pages.AddALocationPage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.Map;


public class AddALocationPageSteps {

    private final AddALocationPage addALocationPage;
    private final ScenarioContext scenarioContext;

    @Inject
    public AddALocationPageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        addALocationPage = new AddALocationPage();
    }

    @Given("Add a location page is opened")
    public void labProfilesPageIsOpened() {
        Assert.assertTrue(addALocationPage.isDisplayed(), "Add a location page should be opened");
    }

    @When("I fill following fields on Add a location page and save as {string}:")
    public void fillLabAddressFormOnAddLocationPage(String key, Map<String, String> data) {
        Location location = new Location();
        data.forEach((field, value) -> {
            if (field.equals("Location name")) {
                value = value + TimeUtil.getTimestamp();
            }
            addALocationPage.setFieldValue(AddALocationPageFields.getEnumValue(field), value);
            location.setReflectionFieldValue(AddALocationPageFields.getEnumValue(field).getModelField(), value);

        });

        XmlFileStore.store(key, location);
    }

    @And("I click Add a location on Add a location page")
    public void iClickAddALocationOnAddALocationPage() {
        addALocationPage.clickAddLocation();
    }

    @Then("Message {string} is displayed on Add a location page")
    public void messageSomeItemsBelowNeedYourAttentionDisplayedOnAddALocationPage(String message) {
        Assert.assertTrue(addALocationPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Add a location page", message));
    }

    @And("Message {string} is displayed on required fields on Add a location page")
    public void messagePleaseEnterAValueDisplayedOnRequiredFieldsOnAddALocationPage(String message) {
        Assert.assertTrue(addALocationPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Add a location page", message));
    }
}
