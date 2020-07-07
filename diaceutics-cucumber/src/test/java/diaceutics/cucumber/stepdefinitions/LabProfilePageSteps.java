package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.*;
import diaceutics.selenium.models.*;
import diaceutics.selenium.pageobject.pages.LabProfilePage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class LabProfilePageSteps {

    private final LabProfilePage labProfilePage;
    private final ScenarioContext scenarioContext;

    @Inject
    public LabProfilePageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        labProfilePage = new LabProfilePage();
    }

    @Given("Lab Profile page is opened")
    public void labProfilesPageIsOpened() {
        Assert.assertTrue(labProfilePage.isDisplayed(), "LabProfile page should be opened");
    }

    @Then("Add Platform form is opened")
    public void addPlatformFormIsOpened() {
        Assert.assertTrue(labProfilePage.getAddPlatformForm().isDisplayed(), "Add Platform form should be opened");
    }

    @When("I fill following fields on Add Platform form and save as {string}:")
    public void iFillFollowingFieldsOnAddPlatformFormAndSave(String key, Map<String, String> data) {
        Platform platform = new Platform();
        data.forEach((field, value) -> {
            String selectedValue = labProfilePage.getAddPlatformForm().setFieldValue(AddPlatformFormFields.getEnumValue(field), value);
            platform.setReflectionFieldValue(AddPlatformFormFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, platform);
    }

    @And("Field {string} does not contains value from {string}")
    public void fieldPlatformDoesNotContainsValueFromNewPlatform(String field, String key) {
        Platform platform = XmlFileStore.get(key);
        String value = platform.getReflectionFieldValue(AddPlatformFormFields.getEnumValue(field).getModelField());
        Assert.assertFalse(labProfilePage.getAddPlatformForm().isFieldContainsValue(AddPlatformFormFields.getEnumValue(field), value),
                String.format("Value %S should not be in the %s field", value, field));

    }

    @Then("Platform {string} added to Platforms grid")
    public void platformAddedInPlatformsTable(String key) {
        Platform platform = XmlFileStore.get(key);
        Assert.assertTrue(labProfilePage.isPlatformAdded(platform),
                String.format("Platform with values %s, %s should be added in Platforms table",
                        platform.getPlatformManufacturer(), platform.getPlatform()));

    }

    @When("I sort data by alphabet in {string} column on {string} Grid")
    public void iSortDataByAlphabetInPlatformManufacturedColumn(String column, String gridName) {
        labProfilePage.clickSortColumnInGrid(column, gridName);
    }

    @Then("Data in {string} column on {string} Grid sorted according to alphabet")
    public void dataInPlatformManufacturedColumnSortedAccordingToAlphabet(String column, String gridName) {
        SoftAssert.getInstance().assertTrue(labProfilePage.isDataInColumnInGridSorted(column, gridName),
                String.format("Data in %s column should be sorted according to alphabet", column));
    }

    @When("I click on Edit button for the {string} platform on Lab Profile Page")
    public void onLabProfilePageClickOnEditButtonForTheNewPlatformPlatform(String key) {
        Platform platform = XmlFileStore.get(key);
        labProfilePage.clickEditPlatform(platform);
    }

    @And("I fill following fields on Edit Platform form and save as {string}:")
    public void iFillFollowingFieldsOnEditPlatformFormAndSave(String key, Map<String, String> data) {
        Platform platform = XmlFileStore.get(key);
        data.forEach((field, value) -> {
            String selectedValue = labProfilePage.getEditPlatformForm().setFieldValue(AddPlatformFormFields.getEnumValue(field), value);
            platform.setReflectionFieldValue(AddPlatformFormFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, platform);
    }

    @When("On the Lab Profile page I click on Delete button for the {string} platform")
    public void onTheLabProfilePageClickOnDeleteButtonForTheNewPlatformPlatform(String key) {
        Platform platform = XmlFileStore.get(key);
        labProfilePage.clickDeletePlatform(platform);
    }

    @And("I click {string} on Confirm form")
    public void clickConfirm(String buttonName) {
        labProfilePage.getConfirmForm().clickByButton(buttonName);
    }

    @Then("Edit platform form is opened")
    public void editPlatformFormIsOpened() {
        Assert.assertTrue(labProfilePage.getEditPlatformForm().isDisplayed(), "Edit platform form should be opened");
    }

    @Then("Confirm form is opened")
    public void confirmFormIsOpened() {
        Assert.assertTrue(labProfilePage.getConfirmForm().isDisplayed(), "Confirm form should be opened");
    }

    @Then("Platform {string} is not present on the Lab Profile page")
    public void platformNewPlatformIsNotPresentOnTheLabProfilePage(String key) {
        Platform platform = XmlFileStore.get(key);
        Assert.assertFalse(labProfilePage.isPlatformAdded(platform),
                String.format("Platform with values %s, %s should not present on the Lab Profile page",
                        platform.getPlatformManufacturer(), platform.getPlatform()));
    }

    @When("I count the number of platforms in the {string} grid and save as {string}")
    public void iCountTheNumberOfPlatformsInThePlatformsGridAndSaveAsNumberOfPlatforms(String gridName, String key) {
        String numberOfPlatformsFromGrid = labProfilePage.getNumberOfRowsInGrid(gridName);
        scenarioContext.add(key, numberOfPlatformsFromGrid);
    }

    @Then("{string} must be the same as a number stated in the {string} Grid title")
    public void numberOfPlatformsInPlatformGridMustBeTheSameAsANumberStatedInThePlatformsGridTitle(String key, String gridName) {
        String numberOfPlatformsFromGrid = scenarioContext.get(key);
        Assert.assertEquals(numberOfPlatformsFromGrid,
                labProfilePage.getNumberOfRowsFromGridHead(gridName),
                "The number of rows in Platform grid must be the same as a number stated in the Platforms grid title");
    }

    @When("I click Edit Details on Lab Profile Page")
    public void iClickOnEditDetailsOnLabProfilePage() {
        labProfilePage.clickEditDetails();
    }

    @And("Lab {string} with following fields is displayed on Lab Profile page")
    public void labLabIsDisplayedOnLabProfilePage(String key, List<String> fields) {
        Lab expectedLab = scenarioContext.get(key);
        Lab actualLab = labProfilePage.getLabFromPage();

        fields.forEach(field -> {
            String actualValue = actualLab.getReflectionFieldValue(CreateLabPageFields.getEnumValue(field).getModelField());
            String expectedValue = expectedLab.getReflectionFieldValue(CreateLabPageFields.getEnumValue(field).getModelField());
            SoftAssert.getInstance().assertEquals(
                    actualValue,
                    expectedValue,
                    String.format("Value %s for %s is not correct on Lab Profile page", actualValue, expectedLab.getName()));
        });
    }

    @Then("{string} message is displayed on Lab Profile page")
    public void newLocationAddedMessageIsDisplayedOnLabProfilePage(String message) {
        Assert.assertTrue(labProfilePage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Lab Profile page", message));
    }

    @And("Location {string} is displayed on Locations form on on Lab Profile page")
    public void locationLocationIsDisplayedOnLocationsFormOnOnLabProfilePage(String key) {
        Location location = XmlFileStore.get(key);
        List<String> locationFieldValues = labProfilePage.getLocationsForm().getLocationFieldValues(location);

        for (int i = 0; i < locationFieldValues.size(); i++) {
            String actualValue = locationFieldValues.get(i);
            String expectedValue = location.getReflectionFieldValue(location.getFields()[i]);
            SoftAssert.getInstance().assertEquals(
                    actualValue,
                    expectedValue,
                    String.format("Value %s for %s is not correct on Lab Profile page", expectedValue, location.getLocationName()));
        }
    }

    @When("I click Edit location {string} on Lab Profile Page")
    public void iClickEditLocationLocationOnLabProfilePage(String key) {
        Location location = XmlFileStore.get(key);
        labProfilePage.getLocationsForm().clickEditLocation(location);
    }

    @When("I click on {string} on Lab Profile Page")
    public void iClickOnAddVolumeOnLabProfilePage(String buttonName) {
        labProfilePage.clickAdd(buttonName);
    }

    @Then("Log patient volume form is opened")
    public void logPatientVolumeFormIsOpenedOnLabProfilePage() {
        Assert.assertTrue(labProfilePage.getLogPatientVolumeForm().isDisplayed(), "Log patient volume form should be opened");
    }

    @When("I fill following fields on Log patient volume form and save as {string}:")
    public void iFillFollowingFieldsOnLogPatientVolumeFormAndSaveAsVolume(String key, Map<String, String> data) {
        Volume volume = new Volume();
        data.forEach((field, value) -> {
            String selectedValue = labProfilePage.getLogPatientVolumeForm().setFieldValue(LogPatientVolumeFields.getEnumValue(field), value);
            volume.setReflectionFieldValue(LogPatientVolumeFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, volume);
    }

    @Then("Message {string} for {string} is displayed on Log patient volume form")
    public void messageYourVolumeHasBeenAddedForDiseaseAndBiomarkerForVolumeIsDisplayedOnLogPatientVolumeForm(String messageTemplate, String key) {
        Volume volume = XmlFileStore.get(key);
        String message = String.format(messageTemplate, volume.getDisease(), volume.getBiomarker());
        Assert.assertTrue(labProfilePage.getLogPatientVolumeForm().isMessageForVolumeDisplayed(message, volume),
                String.format("Message %s should be displayed on Log patient volume form",
                        message));
    }

    @When("I click {string} on Log patient volume form")
    public void iClickDoneOnLogPatientVolumeForm(String buttonName) {
        labProfilePage.getLogPatientVolumeForm().clickByButton(buttonName);
    }

    @And("Volume {string} is added to Volumes grid on Lab Profile page")
    public void volumeVolumeIsAddedToVolumesGridOnLabProfilePage(String key) {
        Volume volume = XmlFileStore.get(key);
        Assert.assertTrue(labProfilePage.isVolumeAdded(volume),
                String.format("Volume with values %s, %s, %s, %s should be added in Volumes grid",
                        volume.getTimePeriod(),
                        volume.getDisease(),
                        volume.getBiomarker(),
                        volume.getVolume()));
    }

    @When("I fill following fields on Log patient volume form using data from {string}:")
    public void iFillFollowingFieldsOnLogPatientVolumeFormUsingDataFromVolume(String key, List<String> fields) {
        Volume volume = XmlFileStore.get(key);
        fields.forEach(field -> {
            labProfilePage.getLogPatientVolumeForm().setFieldValue(LogPatientVolumeFields.getEnumValue(field),
                    volume.getReflectionFieldValue(LogPatientVolumeFields.getEnumValue(field).getModelField()));
        });
    }

    @Then("Message {string} is displayed on Log patient volume form")
    public void messageAVolumeAlreadyExistsForThisCriteriaAndTimePeriodIsDisplayedOnLogPatientVolumeForm(String message) {
        Assert.assertTrue(labProfilePage.getLogPatientVolumeForm().isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Log patient volume form", message));
    }

    @When("I click on Edit button for the {string} volume on Lab Profile Page")
    public void iClickOnEditButtonForTheVolumeVolumeOnLabProfilePage(String key) {
        Volume volume = XmlFileStore.get(key);
        labProfilePage.clickEditVolume(volume);
    }

    @Then("Edit patient volume form is opened")
    public void editPatientVolumeFormIsOpened() {
        Assert.assertTrue(labProfilePage.getEditPatientVolumeForm().isDisplayed(), "Edit patient volume form should be opened");
    }

    @When("I fill following fields on Edit patient volume form and save as {string}:")
    public void iFillFollowingFieldsOnEditPatientVolumeFormAndSaveAsVolume(String key, Map<String, String> data) {
        Volume volume = XmlFileStore.get(key);
        data.forEach((field, value) -> {
            String selectedValue = labProfilePage.getEditPatientVolumeForm().setFieldValue(EditPatientVolumeFields.getEnumValue(field), value);
            volume.setReflectionFieldValue(EditPatientVolumeFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, volume);
    }

    @And("I click {string} on Edit patient volume form")
    public void iClickUpdateVolumeOnEditPatientVolumeForm(String buttonName) {
        labProfilePage.getEditPatientVolumeForm().clickByButton(buttonName);
    }

    @Then("Message {string} for {string} is displayed on Edit patient volume form")
    public void messageVolumeHasBeenAddedForDiseaseAndBiomarkerForVolumeIsDisplayedOnEditPatientVolumeForm(String messageTemplate, String key) {
        Volume volume = XmlFileStore.get(key);
        String message = String.format(messageTemplate, volume.getDisease(), volume.getBiomarker());
        Assert.assertTrue(labProfilePage.getEditPatientVolumeForm().isMessageForVolumeDisplayed(message, volume),
                String.format("Message %s should be displayed on Log patient volume form",
                        message));
    }

    @And("Assay {string} is displayed in Assays grid on Lab Profile page")
    public void assayAssayIsAddedToAssaysGridOnLabProfilePage(String key) {
        Assay assay = XmlFileStore.get(key);
        Assert.assertTrue(labProfilePage.isAssayAdded(assay),
                String.format("Assay %s should be added in Assay grid", assay.getAssayName()));

    }

    @When("I click on Assay {string} in Assays grid on Lab Profile Page")
    public void iClickOnAssayAssayInAssaysGridOnLabProfilePage(String key) {
        Assay assay = XmlFileStore.get(key);
        labProfilePage.clickByAssay(assay);
    }

    @When("I put a Assay {string} on search field {string} and press Search icon on Lab Profile page")
    public void iPutAAssayAssayOnSearchFieldEnterKeywordsAndPressSearchIconOnLabProfilePage(String key, String searchFieldName) {
        Assay assay = XmlFileStore.get(key);
        labProfilePage.putTextInSearchField(assay.getAssayName(), searchFieldName);
        labProfilePage.clickSearch();
    }

    @And("I click {string} on Edit Platform")
    public void iClickSaveChangesOnEditPlatform(String buttonName) {
        labProfilePage.getEditPlatformForm().clickByButton(buttonName);
    }

    @And("I click Add platform on Add Platform")
    public void iClickAddPlatformOnAddPlatform() {
        labProfilePage.getAddPlatformForm().clickAddPlatform();
    }

}
