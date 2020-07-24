package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.PresentationOfTheCollaborationFormFields;
import diaceutics.selenium.models.Collaboration;
import diaceutics.selenium.pageobject.pages.EditCollaborationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;


public class EditCollaborationSteps {

    private final EditCollaborationPage editCollaborationPage;

    public EditCollaborationSteps() {
        editCollaborationPage = new EditCollaborationPage();
    }

    @Then("Edit collaboration page is opened")
    public void editCollaborationPageIsOpened() {
        Assert.assertTrue(editCollaborationPage.isDisplayed(),
                "Edit collaboration page should be opened");
    }

    @And("Collaboration {string} with following fields is displayed on Edit collaboration page")
    public void collaborationWithFollowingFieldsIsDisplayedOnEditCollaborationPage(String key, List<String> fields) {
        Collaboration collaboration = XmlFileStore.get(key);
        fields.forEach(field -> {
            String actualValue = editCollaborationPage.getPresentationOfTheCollaborationForm()
                    .getFieldValue(PresentationOfTheCollaborationFormFields.getEnumValue(field));
            String expectedValue = collaboration
                    .getReflectionFieldValue(PresentationOfTheCollaborationFormFields.getEnumValue(field).getModelField());
            SoftAssert.getInstance().assertEquals(
                    actualValue,
                    expectedValue,
                    String.format("Value %s for %s is not correct on Edit collaboration page", actualValue, field));
        });

    }
}
