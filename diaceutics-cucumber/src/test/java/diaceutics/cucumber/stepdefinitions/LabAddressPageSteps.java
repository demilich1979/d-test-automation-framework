package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.selenium.enums.pageFields.LabAddressPageFields;
import diaceutics.selenium.models.Location;
import diaceutics.selenium.pageobject.pages.LabAddressPage;
import diaceutics.selenium.models.Lab;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.Map;


public class LabAddressPageSteps {
    private final LabAddressPage labAddressPage;
    private final ScenarioContext scenarioContext;

    @Inject
    public LabAddressPageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        labAddressPage = new LabAddressPage();
    }

    @Then("Lab Address page is opened")
    public void checkCreateLabPageIsOpened() {
        Assert.assertTrue(labAddressPage.isDisplayed(), "Lab Address page page should be opened");
    }

    @When("I fill following fields on Lab Address page and save as {string}:")
    public void fillCreateLabPage(String key, Map<String, String> data) {
        Lab lab = scenarioContext.get(key);
        Location location = new Location();
        data.forEach((field, value) -> {
            String selectedValue = labAddressPage.setFieldValue(LabAddressPageFields.getEnumValue(field), value);
            location.setReflectionFieldValue(LabAddressPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        lab.addLocation(location);
        scenarioContext.add(key, lab);
    }

    @And("I click {string} on Lab Address page")
    public void iClickFinishOnLabAddressPage(String buttonName) {
        labAddressPage.clickByButton(buttonName);
    }

    @Then("Message {string} is displayed on Lab Address page")
    public void messageSomeItemsBelowNeedYourAttentionDisplayedOnLabAddressPage(String message) {
        Assert.assertTrue(labAddressPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Lab Address page", message));
    }

    @And("Message {string} is displayed on required fields on Lab Address page")
    public void messagePleaseEnterAValueDisplayedOnRequiredFieldsOnLabAddressPage(String message) {
        Assert.assertTrue(labAddressPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Lab Address page", message));
    }
}
