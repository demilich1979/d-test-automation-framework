package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.DescriptionOfTheCollaborationPageFields;
import diaceutics.selenium.models.Collaboration;
import diaceutics.selenium.pageobject.pages.DescriptionOfTheCollaborationPage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
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
        Collaboration collaboration = XmlFileStore.get(key);
        if (collaboration == null) {
            collaboration = new Collaboration();
        }
        Collaboration finalCollaboration = collaboration;
        data.forEach((field, value) -> {
            if (field.equals("TITLE")) {
                value = value + TimeUtil.getTimestamp();
            }
            String selectedValue = descriptionOfTheCollaborationPage.setFieldValue(DescriptionOfTheCollaborationPageFields.getEnumValue(field), value);
            finalCollaboration.setReflectionFieldValue(DescriptionOfTheCollaborationPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, collaboration);
    }

    @When("I click {string} on Description collaboration page")
    public void iClickProceedToStepOfOnDescriptionCollaborationPage(String buttonName) {
        descriptionOfTheCollaborationPage.clickByButton(buttonName);
    }

    @And("I upload file {string} on Description collaboration page")
    public void iUploadFileOnDescriptionCollaborationPage(String fileName) {
        descriptionOfTheCollaborationPage.uploadFile(fileName);
    }

    @Then("File {string} is uploaded on Description collaboration page")
    public void fileIsUploadedOnDescriptionCollaborationPage(String fileName) {
        Assert.assertTrue(descriptionOfTheCollaborationPage.isFileUploaded(fileName),
                String.format("File %s should be added on Description collaboration page", fileName));
    }

    @And("I click by Videos on Description collaboration page")
    public void iClickByVideosOnDescriptionCollaborationPage() {
        descriptionOfTheCollaborationPage.clickByVideos();
    }

    @Then("Error container is displayed for following fields on Description collaboration page:")
    public void errorContainerIsDisplayedForFollowingFieldsOnDescriptionCollaborationPage(List<String> fields) {
        fields.forEach((field) -> SoftAssert.getInstance().assertTrue(descriptionOfTheCollaborationPage
                        .isErrorContainerDisplayedForField(DescriptionOfTheCollaborationPageFields.getEnumValue(field)),
                String.format("Error container for field - %s should be displayed", field)));
    }

    @Then("Error container is not displayed for following fields on Description collaboration page:")
    public void errorContainerIsNotDisplayedForFollowingFieldsOnDescriptionCollaborationPage(List<String> fields) {
        fields.forEach((field) -> SoftAssert.getInstance().assertFalse(descriptionOfTheCollaborationPage
                        .isErrorContainerDisplayedForField(DescriptionOfTheCollaborationPageFields.getEnumValue(field)),
                String.format("Error container for field - %s is displayed", field)));
    }

    @Then("Message {string} is displayed on Description collaboration page")
    public void alertMessageIsDisplayedOnDescriptionCollaborationPage(String message) {
        Assert.assertTrue(descriptionOfTheCollaborationPage.isAlertMessageDisplayed(message),
                String.format("Message %s should be displayed on Create a Lab page", message));
    }

    @And("I click Add video on Description collaboration page")
    public void iClickAddVideoOnDescriptionCollaborationPage() {
        descriptionOfTheCollaborationPage.clickAddVideo();
    }
}
