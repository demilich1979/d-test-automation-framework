package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.EditAssayPageFields;
import diaceutics.selenium.models.Assay;
import diaceutics.selenium.models.Biomarker;
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
    public void editAssayPageIsOpened() {
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

    @And("I click {string} on Edit Assay page")
    public void iClickOnEditAssayPage(String buttonName) {
        editAssayPage.clickByButton(buttonName);
    }

    @Then("Message {string} is displayed on required fields on Edit Assay page")
    public void messagePleaseEnterAnAssayNameIsDisplayedOnRequiredFieldsOnEditAssayPage(String message) {
        Assert.assertTrue(editAssayPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Edit Assay page", message));
    }

    @Then("Biomarker {string} is not displayed in Biomarker grid on Edit Assay page")
    public void biomarkerBiomarkerIsNotAddedToBiomarkerGridOnEditAssayPage(String key) {
        Biomarker biomarker = XmlFileStore.get(key);
        Assert.assertFalse(editAssayPage.isBiomarkerAdded(biomarker),
                String.format("Biomarker %s should not be displayed in Biomarker grid on Add an Assay page",
                        biomarker.getBiomarker()));
    }

    @Then("Biomarker {string} is added to Biomarker grid on Edit Assay page")
    public void biomarkerBiomarkerIsAddedToBiomarkerGridOnEditAssayPage(String key) {
        Biomarker biomarker = XmlFileStore.get(key);
        Assert.assertTrue(editAssayPage.isBiomarkerAdded(biomarker),
                String.format("Biomarker %s should be added added to Biomarker grid on Add an Assay page",
                        biomarker.getBiomarker()));
    }

    @Then("Message {string} is displayed on Edit Assay page")
    public void messageIsDisplayedOnEditAssayPage(String message) {
        Assert.assertTrue(editAssayPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Edit Assay page", message));
    }

    @Then("The default biomarker input should not be visible on Edit Assay page")
    public void theDefaultBiomarkerInputShouldNotBeVisibleOnEditAssayPage() {
        Assert.assertTrue(editAssayPage.isDefaultBiomarkerInputDisplayed(),
                "The default biomarker input is visible on Edit Assay page");
    }

    @Then("Add Biomarker form is opened on Edit Assay page")
    public void addBiomarkerFormIsOpenedOnEditAssayPage() {
        Assert.assertTrue(editAssayPage.getAddBiomarkerForm().isDisplayed(),
                "Add Biomarker form should be opened on Edit Assay page");
    }

    @And("Commercial assay Biomarkers are added to this assay {string}")
    public void commercialAssayBiomarkersFromAssayIsDisplayedOnEditAssayPage(String key) {
        Assay assay = XmlFileStore.get(key);
        Assert.assertTrue(editAssayPage.isCommercialAssayBiomarkerAdded(assay),
                String.format("Commercial assay Biomarkers %s should be added to this assay %s",
                        assay.getCommercialAssays(), assay.getAssayName()));
    }
}
