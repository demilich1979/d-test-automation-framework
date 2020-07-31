package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.AddAnAssayPageFields;
import diaceutics.selenium.enums.pageFields.AddBiomarkerFormFields;
import diaceutics.selenium.models.Assay;
import diaceutics.selenium.models.Biomarker;
import diaceutics.selenium.pageobject.pages.AddAnAssayPage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class AddAnAssayPageSteps {

    private final AddAnAssayPage addAnAssayPage;

    public AddAnAssayPageSteps() {
        addAnAssayPage = new AddAnAssayPage();
    }

    @Given("Add an Assay page is opened")
    public void addAnAssayPageIsOpened() {
        Assert.assertTrue(addAnAssayPage.isDisplayed(), "Add an Assay page should be opened");
    }

    @When("I fill following fields on Add an Assay page and save as {string}:")
    public void fillLabAddressFormOnAddLocationPage(String key, Map<String, String> data) {
        Assay assay = new Assay();
        data.forEach((field, value) -> {
            if (field.equals("Assay name")) {
                value = value + TimeUtil.getTimestamp();
            }
            String selectedValue = addAnAssayPage.setFieldValue(AddAnAssayPageFields.getEnumValue(field), value);
            selectedValue = field.equals("Turn around time (TaT)") ? selectedValue + " days" : selectedValue;
            assay.setReflectionFieldValue(AddAnAssayPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        assay.setClassifications(assay.addClassifications());
        XmlFileStore.store(key, assay);
    }

    @And("I click {string} on Add an Assay page")
    public void iClickOnAddAnAssayPage(String buttonName) {
        addAnAssayPage.clickByButton(buttonName);
    }

    @Then("Add Biomarker form is opened on Add an Assay page")
    public void addBiomarkerFormIsOpened() {
        Assert.assertTrue(addAnAssayPage.getAddBiomarkerForm().isDisplayed(),
                "Add Biomarker form should be opened on Add an Assay page");
    }

    @And("I click Save changes on Add Biomarker form")
    public void iClickSaveChangesOnAddBiomarkerForm() {
        addAnAssayPage.getAddBiomarkerForm().clickSaveChanges();
    }

    @And("Biomarker from {string} is added to Biomarker grid on Add an Assay page")
    public void biomarkerBiomarkerIsAddedToBiomarkerDiseaseGridOnAddAnAssayPage(String key) {
        Assay assay = XmlFileStore.get(key);
        Biomarker biomarker = assay.getBiomarkers().get(0);
        Assert.assertTrue(addAnAssayPage.isBiomarkerAdded(biomarker),
                String.format("Biomarker %s should be added added to Biomarker grid on Add an Assay page",
                        biomarker.getBiomarker()));
    }

    @Then("Message {string} is displayed on Add an Assay page")
    public void messageSomeItemsBelowNeedYourAttentionIsDisplayedOnAddAnAssayPage(String message) {
        Assert.assertTrue(addAnAssayPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Add an Assay page", message));
    }

    @And("Message {string} is displayed on required fields on Add an Assay page")
    public void messageOnRequiredFieldsOnAddAnAssayPage(String message) {
        Assert.assertTrue(addAnAssayPage.isMessageDisplayedOnRequiredFields(message),
                String.format("Message %s should be displayed on required fields on Add an Assay page", message));
    }

    @Then("Field {string} should be disabled on Add an Assay page")
    public void fieldSendOutLabShouldBeDisabledOnAddAnAssayPage(String field) {
        Assert.assertFalse(addAnAssayPage.isFieldEnabled(AddAnAssayPageFields.getEnumValue(field)),
                String.format("Field %s should be disabled on Add an Assay page", field));
    }

    @Then("Field {string} should be enabled on Add an Assay page")
    public void fieldPanelNameShouldBeEnabledOnAddAnAssayPage(String field) {
        Assert.assertTrue(addAnAssayPage.isFieldEnabled(AddAnAssayPageFields.getEnumValue(field)),
                String.format("Field %s should be enabled on Add an Assay page", field));
    }

    @When("I fill following fields on Add Biomarker form and save to {string}:")
    public void iFillFollowingFieldsOnAddBiomarkerFormAndSaveAsBiomarkerForAssayForLab(
            String assayKey,
            Map<String, String> data) {
        Assay assay = XmlFileStore.get(assayKey);
        Biomarker biomarker = new Biomarker();
        data.forEach((field, value) -> {
            String selectedValue = addAnAssayPage.getAddBiomarkerForm().setFieldValue(AddBiomarkerFormFields.getEnumValue(field), value);
            biomarker.setReflectionFieldValue(AddBiomarkerFormFields.getEnumValue(field).getModelField(), selectedValue);
        });

        assay.addBiomarker(biomarker);
        XmlFileStore.store(assayKey, assay);
    }

    @And("I click {string} on Add Biomarker form")
    public void iClickDoneOnAddBiomarkerForm(String buttonName) {
        addAnAssayPage.getAddBiomarkerForm().clickByButton(buttonName);
    }

    @Then("The following values should be available for {string} field on Add an Assay page:")
    public void theFollowingValuesShouldBeAvailableForCommercialAssaysFieldOnAddAnAssayPage(String field, List<String> values) {
        List<String> options = addAnAssayPage.getListOptionsFromField(AddAnAssayPageFields.getEnumValue(field));
        values.forEach(value -> {
            SoftAssert.getInstance().assertTrue(options.contains(value),
                    String.format("Value %s should be available for %s field on Add an Assay page", value, field));
        });

    }
}
