package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.CreateLabPageFields;
import diaceutics.selenium.pageobject.pages.CreateLabPage;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class CreateLabsPageSteps {
    private final CreateLabPage createLabPage;

    public CreateLabsPageSteps() {
        createLabPage = new CreateLabPage();
    }

    @Then("Create a Lab page is opened")
    public void createLabsPageIsOpened() {
        Assert.assertTrue(createLabPage.isDisplayed(), "Create a Lab page should be opened");
    }

    @When("I fill following fields on Create a Lab page and save as {string}:")
    public void fillCreateLabPage(String key, Map<String, String> data) {
        Lab lab = new Lab();
        data.forEach((field, value) -> {
            if (field.equals("Name")) {
                value = value + TimeUtil.getTimestamp();
            }
            String selectedValue = createLabPage.setFieldValue(CreateLabPageFields.getEnumValue(field), value);
            lab.setReflectionFieldValue(CreateLabPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, lab);
    }

    @And("I click {string} on Create a Lab page")
    public void iClickNextOnCreateALabPage(String buttonName) {
        createLabPage.clickByButton(buttonName);
    }

    @Then("Message {string} is displayed on Create a Lab page")
    public void someItemsBelowNeedYourAttentionMessageAppearsOnCreateALabPage(String message) {
        Assert.assertTrue(createLabPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Create a Lab page", message));
    }

    @And("Message {string} is displayed on required fields on Create a Lab page")
    public void messagePleaseInputACountryDisplayedOnRequiredFieldsOnCreateALabPage(String message) {
        Assert.assertTrue(createLabPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Create a Lab page", message));
    }
}
