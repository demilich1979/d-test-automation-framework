package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.EditAssayPageFields;
import diaceutics.selenium.models.Assay;
import diaceutics.selenium.pageobject.pages.EditAssayPage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class EditAssayPageSteps {

    private final EditAssayPage editAssayPage;

    public EditAssayPageSteps() {
        editAssayPage = new EditAssayPage();
    }

    @Given("Edit Assay page is opened")
    public void labProfilesPageIsOpened() {
        Assert.assertTrue(editAssayPage.isDisplayed(), "Edit Assay page should be opened");
    }

    @When("I fill following fields on Edit Assay page and save as {string}:")
    public void fillLabAddressFormOnAddLocationPage(String key, Map<String, String> data) {
        Assay assay = XmlFileStore.get(key);
        data.forEach((field, value) -> {
            if (field.equals("Assay name")) {
                value = value + TimeUtil.getTimestamp();
            }
            String selectedValue = editAssayPage.setFieldValue(EditAssayPageFields.getEnumValue(field), value);
            assay.setReflectionFieldValue(EditAssayPageFields.getEnumValue(field).getModelField(), selectedValue);

        });

        XmlFileStore.store(key, assay);
    }

    @And("I click Save on Edit Assay page")
    public void iClickSaveOnEditAssayPage() {
        editAssayPage.clickSave();
    }

    @Then("Message {string} is displayed on required fields on Edit Assay page")
    public void messagePleaseEnterAnAssayNameIsDisplayedOnRequiredFieldsOnEditAssayPage(String message) {
        Assert.assertTrue(editAssayPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Edit Assay page", message));
    }
}
