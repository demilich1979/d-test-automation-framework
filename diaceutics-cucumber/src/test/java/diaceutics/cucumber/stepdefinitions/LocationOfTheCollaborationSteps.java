package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.LocationOfTheCollaborationPageFields;
import diaceutics.selenium.models.Collaboration;
import diaceutics.selenium.pageobject.pages.LocationOfTheCollaborationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;


public class LocationOfTheCollaborationSteps {

    private final LocationOfTheCollaborationPage locationOfTheCollaborationPage;

    public LocationOfTheCollaborationSteps() {
        locationOfTheCollaborationPage = new LocationOfTheCollaborationPage();
    }

    @Then("Location of the collaboration page is opened")
    public void descriptionCollaborationPageIsOpened() {
        Assert.assertTrue(locationOfTheCollaborationPage.isDisplayed(),
                "Location of the collaboration page should be opened");
    }

    @When("I fill following fields on Location of the collaboration page and save as {string}:")
    public void iFillFollowingFieldsOnLocationOfTheCollaborationPageAndSaveAsCollaboration(String key, Map<String, String> data) {
        Collaboration collaboration = XmlFileStore.get(key);
        data.forEach((field, value) -> {
            String selectedValue = locationOfTheCollaborationPage.setFieldValue(LocationOfTheCollaborationPageFields.getEnumValue(field), value);
            collaboration.setReflectionFieldValue(LocationOfTheCollaborationPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, collaboration);
    }

    @And("I click {string} on Location of the collaboration page")
    public void iClickPublishACollaborationOnLocationOfTheCollaborationPage(String buttonName) {
        locationOfTheCollaborationPage.clickByButton(buttonName);
    }
}
