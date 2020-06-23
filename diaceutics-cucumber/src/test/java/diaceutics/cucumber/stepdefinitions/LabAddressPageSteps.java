package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.selenium.enums.pageFields.CreateLabPageFields;
import diaceutics.selenium.enums.pageFields.LabAddressPageFields;
import diaceutics.selenium.forms.pages.LabAddressPage;
import diaceutics.selenium.models.Lab;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.inject.Inject;
import java.util.Map;

import static org.testng.Assert.assertTrue;

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
        assertTrue(labAddressPage.isDisplayed(), "Lab Address page page should be opened");
    }

    @When("I fill Lab Address form using following data and sava as {string}:")
    public void fillCreateLabPage(String key, Map<String, String> data) {
        Lab lab = scenarioContext.get(key);
        data.forEach((field, value) -> {
            labAddressPage.setFieldValue(LabAddressPageFields.getEnumValue(field), value);
            lab.setReflectionFieldValue(LabAddressPageFields.getEnumValue(field).getModelField(), value);
        });

        scenarioContext.add(key, lab);
    }

    @And("I click Finish on Lab Address page")
    public void iClickFinishOnLabAddressPage() {
        labAddressPage.clickFinish();
    }
}
