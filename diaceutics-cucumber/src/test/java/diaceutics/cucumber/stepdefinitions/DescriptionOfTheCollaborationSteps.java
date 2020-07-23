package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.DescriptionOfTheCollaborationPageFields;
import diaceutics.selenium.models.Collaboration;
import diaceutics.selenium.pageobject.pages.DescriptionOfTheCollaborationPage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class DescriptionOfTheCollaborationSteps {

    private final DescriptionOfTheCollaborationPage descriptionOfTheCollaborationPage;

    public DescriptionOfTheCollaborationSteps() {
        descriptionOfTheCollaborationPage = new DescriptionOfTheCollaborationPage();
    }

    @Then("Description collaboration page is opened")
    public void descriptionCollaborationPageIsOpened() {
        Assert.assertTrue(descriptionOfTheCollaborationPage.isDisplayed(), "Description collaboration page should be opened");
    }

    @When("I fill following fields on Description of the collaboration page and save as {string}:")
    public void iFillFollowingFieldsOnDescriptionCollaborationPageAndSaveAsCollaboration(String key, Map<String, String> data) {
        Collaboration collaboration = new Collaboration();
        data.forEach((field, value) -> {
            if (field.equals("TITLE")) {
                value = value + TimeUtil.getTimestamp();
            }
            String selectedValue = descriptionOfTheCollaborationPage.setFieldValue(DescriptionOfTheCollaborationPageFields.getEnumValue(field), value);
            collaboration.setReflectionFieldValue(DescriptionOfTheCollaborationPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, collaboration);
    }

    @And("I add image {string} on Description collaboration page")
    public void iAddImageTestImagePngOnDescriptionCollaborationPage(String fileName) {
        descriptionOfTheCollaborationPage.uploadFile(fileName);

    }

    @Then("Image {string} is added on Description collaboration page")
    public void imageIsAddedOnDescriptionCollaborationPage(String image) {
        Assert.assertTrue(descriptionOfTheCollaborationPage.isImageAdded(image),
                "Image should be added on Description collaboration page");
    }

    @When("I click {string} on Description collaboration page")
    public void iClickProceedToStepOfOnDescriptionCollaborationPage(String buttonName) {
        descriptionOfTheCollaborationPage.clickByButton(buttonName);
    }
}
