package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.PersonalDetailsFormFields;
import diaceutics.selenium.models.User;
import diaceutics.selenium.pageobject.pages.RegistrationPage;
import diaceutics.selenium.utilities.MailUtil;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class RegistrationPageSteps {

    private final RegistrationPage registrationPage;

    public RegistrationPageSteps() {
        registrationPage = new RegistrationPage();
    }

    @Given("Registration page is opened")
    public void registerPageIsOpened() {
        Assert.assertTrue(registrationPage.isDisplayed(), "Registration page should be opened");
    }

    @When("I fill following fields on Personal Details form on Registration page and save as {string}:")
    public void iSetFollowingValuesForRegisterFormAndSaveAsAccount(String key, Map<String, String> data) {
        User user = new User();
        data.forEach((field, value) -> {
            if (field.equals("EMAIL") && value.equals("@mailosaur.io")) {
                value = String.format(MailUtil.MAIL_ADDRESS_PATTERN, TimeUtil.getTimestamp(), MailUtil.SERVER_ID);
            }
            String selectedValue = registrationPage.getPersonalDetailsForm().setFieldValue(PersonalDetailsFormFields.getEnumValue(field), value);
            user.setReflectionFieldValue(PersonalDetailsFormFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, user);
    }

    @And("I click Register on Personal Details form on Registration page")
    public void iClickRegisterOnRegisterPage() {
        registrationPage.getPersonalDetailsForm().clickRegister();
    }

    @Then("Error container is displayed for following fields:")
    public void errorContainerIsDisplayedForFollowingFields(List<String> fields) {
        fields.forEach((field) -> {
            SoftAssert.getInstance().assertTrue(registrationPage.getPersonalDetailsForm().isErrorContainerDisplayedForField(
                    PersonalDetailsFormFields.getEnumValue(field)),
                    String.format("Error container for field - %s should be displayed",field));
        });
    }

    @Then("Error container is not displayed for following fields:")
    public void errorContainerIsNotDisplayedForFollowingFields(List<String> fields) {
        fields.forEach((field) -> {
            SoftAssert.getInstance().assertFalse(registrationPage.getPersonalDetailsForm().isErrorContainerDisplayedForField(
                    PersonalDetailsFormFields.getEnumValue(field)),
                    String.format("Error container for field - %s is displayed",field));
        });
    }
}
