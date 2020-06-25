package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.AddPlatformFormFields;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.models.Location;
import diaceutics.selenium.pageobject.pages.LabProfilePage;
import diaceutics.selenium.models.Platform;
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

    @When("I click on Add Platform on Lab Profile Page")
    public void iClickOnAddPlatformOnLabProfilePage() {
        labProfilePage.clickAddPlatform();
    }

    @Then("Add Platform form is opened")
    public void addPlatformFormIsOpened() {
        Assert.assertTrue(labProfilePage.getAddPlatformForm().isDisplayed(), "Add Platform form should be opened");
    }

    @When("I fill following fields on Add Platform form and save as {string}:")
    public void iFillFollowingFieldsOnAddPlatformFormAndSaveAsNewPlatform(String key, Map<String, String> data) {
        Platform platform = new Platform();
        data.forEach((field, value) -> {
            String selectedValue = labProfilePage.getAddPlatformForm().setFieldValue(AddPlatformFormFields.getEnumValue(field), value);
            platform.setReflectionFieldValue(AddPlatformFormFields.getEnumValue(field).getModelField(), selectedValue);
        });

        labProfilePage.getAddPlatformForm().clickAddPlatform();
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

    @When("I sort data by alphabet in {string} column")
    public void iSortDataByAlphabetInPlatformManufacturedColumn(String column) {
        labProfilePage.clickSortColumn(column);
    }

    @Then("Data in {string} column sorted according to alphabet")
    public void dataInPlatformManufacturedColumnSortedAccordingToAlphabet(String column) {
        SoftAssert.getInstance().assertTrue(labProfilePage.isDataInColumnInPlatformGridSorted(column),
                String.format("Data in %s column should be sorted according to alphabet", column));
    }

    @When("I click on Edit button for the {string} platform on Lab Profile Page")
    public void onLabProfilePageClickOnEditButtonForTheNewPlatformPlatform(String key) {
        Platform platform = XmlFileStore.get(key);
        labProfilePage.clickEditPlatform(platform);
    }

    @And("I set {string} value for platform {string} and save changes")
    public void modifyPlatformAndSaveChanges(String value, String key) {
        Platform platform = XmlFileStore.get(key);
        String newValue = labProfilePage.getEditPlatformForm().setFieldValue(value);
        platform.setPlatform(newValue);
        XmlFileStore.store(key, platform);
        labProfilePage.getEditPlatformForm().clickSaveChanges();
    }

    @When("On the Lab Profile page I click on Delete button for the {string} platform")
    public void onTheLabProfilePageClickOnDeleteButtonForTheNewPlatformPlatform(String key) {
        Platform platform = XmlFileStore.get(key);
        labProfilePage.clickDeletePlatform(platform);
    }

    @And("I click Confirm")
    public void clickConfirm() {
        labProfilePage.getConfirmForm().clickConfirm();
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

    @When("I count the number of platforms in the Platforms grid and save as {string}")
    public void iCountTheNumberOfPlatformsInThePlatformsGridAndSaveAsNumberOfPlatforms(String key) {
        String numberOfPlatformsFromGrid = labProfilePage.getNumberOfPlatformsFromGrid();
        scenarioContext.add(key, numberOfPlatformsFromGrid);
    }

    @Then("{string} in Platform grid must be the same as a number stated in the Platforms grid title")
    public void numberOfPlatformsInPlatformGridMustBeTheSameAsANumberStatedInThePlatformsGridTitle(String key) {
        String numberOfPlatformsFromGrid = scenarioContext.get(key);
        Assert.assertEquals(numberOfPlatformsFromGrid,
                labProfilePage.getNumberOfPlatformsFromHead(),
                "The number of rows in Platform grid must be the same as a number stated in the Platforms grid title");
    }

    @When("I click Edit Details on Lab Profile Page")
    public void iClickOnEditDetailsOnLabProfilePage() {
        labProfilePage.clickEditDetails();
    }

    @And("Lab {string} is displayed on Lab Profile page")
    public void labLabIsDisplayedOnLabProfilePage(String key) {
        Lab lab = scenarioContext.get(key);
        Assert.assertTrue(labProfilePage.isLabDisplayedOnPage(lab),
                String.format("Lab %s should be displayed on Lab Profile page", lab.getName()));
    }

    @When("I click Add a location On Lab Profile page")
    public void iClickAddALocationOnLabProfilePage() {
        labProfilePage.clickAddLocation();
    }

    @Then("{string} message is displayed on Lab Profile page")
    public void newLocationAddedMessageIsDisplayedOnLabProfilePage(String message) {
        Assert.assertTrue(labProfilePage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Lab Profile page", message));
    }

    @And("Location {string} is displayed on Locations form on on Lab Profile page")
    public void locationLocationIsDisplayedOnLocationsFormOnOnLabProfilePage(String key) {
        Location location = XmlFileStore.get(key);
        Assert.assertTrue(labProfilePage.getLocationsForm().isLocationDisplayed(location),
                String.format("Location %s should be displayed on Lab Profile page", location.getLocationName()));
    }

    @When("I click Edit location {string} on Lab Profile Page")
    public void iClickEditLocationLocationOnLabProfilePage(String key) {
        Location location = XmlFileStore.get(key);
        labProfilePage.getLocationsForm().clickEditLocation(location);
    }

}
