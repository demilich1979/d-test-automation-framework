package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.selenium.enums.pageFields.CreateLabPageFields;
import diaceutics.selenium.pageobject.pages.CreateLabPage;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.inject.Inject;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class CreateLabsPageSteps {
    private final CreateLabPage createLabPage;
    private final ScenarioContext scenarioContext;

    @Inject
    public CreateLabsPageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        createLabPage = new CreateLabPage();
    }

    @Then("Create a Lab page is opened")
    public void checkCreateLabPageIsOpened() {
        assertTrue(createLabPage.isDisplayed(), "Create a Lab page should be opened");
    }

    @When("I fill first Create a Lab form using following data and sava as {string}:")
    public void fillCreateLabPage(String key, Map<String, String> data) {
        Lab lab = new Lab();
        data.forEach((field, value) -> {
            if (field.equals("Name")) {
                value = value + TimeUtil.getTimestamp();
            }
            createLabPage.setFieldValue(CreateLabPageFields.getEnumValue(field), value);
            lab.setReflectionFieldValue(CreateLabPageFields.getEnumValue(field).getModelField(), value);
        });

        scenarioContext.add(key, lab);
    }

    @And("I click Next on Create a Lab page")
    public void iClickNextOnCreateALabPage() {
        createLabPage.clickNext();
    }

    @Then("Message {string} displayed on Create a Lab page")
    public void someItemsBelowNeedYourAttentionMessageAppearsOnCreateALabPage(String message) {
        assertTrue(createLabPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Create a Lab page",message));
    }

    @And("Message {string} displayed on required fields on Create a Lab page")
    public void messagePleaseInputACountryDisplayedOnRequiredFieldsOnCreateALabPage(String message) {
        assertTrue(createLabPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Create a Lab page",message));
    }
}
