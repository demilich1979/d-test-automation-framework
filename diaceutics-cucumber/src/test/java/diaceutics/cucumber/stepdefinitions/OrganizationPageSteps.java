package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.OrganizationEditIdentityFormFields;
import diaceutics.selenium.models.User;
import diaceutics.selenium.pageobject.pages.OrganizationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class OrganizationPageSteps {

    private final OrganizationPage organizationPage;

    public OrganizationPageSteps() {
        organizationPage = new OrganizationPage();
    }

    @Then("Organization page is opened")
    public void OrganizationPageIsOpened() {
        Assert.assertTrue(organizationPage.isDisplayed(), "Organization page should be opened");
    }

    @When("I click {string} on Organization page")
    public void iClickGeneralDetailsOnOrganizationPage(String linkName) {
        organizationPage.clickByLink(linkName);
    }

    @Then("Organization Edit Identity Form on Organization page is opened")
    public void organizationEditIdentityFormOnOrganizationPageIsOpened() {
        Assert.assertTrue(organizationPage.getOrganizationEditIdentityForm().isDisplayed(),
                "Organization page should be opened");
    }

    @And("Data for user {string} is displayed on the following fields on Organization Edit Identity Form:")
    public void dataForUserAreDisplayedOnTheFollowingFieldsOnOrganizationEditIdentityForm(String key, List<String> fields) {
        User user = XmlFileStore.get(key);
        fields.forEach(field -> {
            String actualValue = organizationPage
                    .getOrganizationEditIdentityForm()
                    .getFieldValue(OrganizationEditIdentityFormFields.getEnumValue(field));

            String expectedValue = user
                    .getReflectionFieldValue(OrganizationEditIdentityFormFields.getEnumValue(field).getModelField());

            SoftAssert.getInstance().assertEquals(
                    actualValue,
                    expectedValue,
                    String.format("Value for %s field is not correct on Organization Edit Identity Form on Organization page",
                            field));
        });
    }
}
