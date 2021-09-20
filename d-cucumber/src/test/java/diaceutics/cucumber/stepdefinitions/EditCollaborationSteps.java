package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.PresentationOfTheCollaborationFormFields;
import diaceutics.selenium.models.Collaboration;
import diaceutics.selenium.pageobject.pages.EditCollaborationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @And("Collaboration {string} with following fields is displayed on Presentation form on Edit collaboration page")
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

    @When("I click {string} on Edit collaboration page")
    public void iClickCategoriesOnEditCollaborationPage(String linkName) {
        editCollaborationPage.clickLink(linkName);
    }

    @Then("Categories form on Edit collaboration page is opened")
    public void categoriesFormOnEditCollaborationPageIsOpened() {
        Assert.assertTrue(editCollaborationPage.getCategoriesOfTheCollaborationForm().isDisplayed(),
                "Categories form on Edit collaboration page should be opened");
    }

    @And("Categories are displayed for Collaboration {string} on Categories form on Edit collaboration page")
    public void categoriesAreDisplayedForCollaborationCollaborationOnCategoriesFormOnEditCollaborationPage(String key) {
        Collaboration collaboration = XmlFileStore.get(key);
        String actualValue = editCollaborationPage.getCategoriesOfTheCollaborationForm().getCategories();
        String expectedValue = collaboration.getReflectionFieldValue("type");
        SoftAssert.getInstance().assertEquals(
                actualValue,
                expectedValue,
                String.format("Value %s for categories is not correct on Edit collaboration page", actualValue));
    }
}
