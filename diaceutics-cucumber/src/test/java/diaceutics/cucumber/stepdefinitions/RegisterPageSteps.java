package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.PersonalDetailsFormFields;
import diaceutics.selenium.models.User;
import diaceutics.selenium.pageobject.pages.RegisterPage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

import static diaceutics.selenium.utilities.MailUtil.MAIL_ADDRESS_PATTERN;
import static diaceutics.selenium.utilities.MailUtil.SERVER_ID;

public class RegisterPageSteps {

    private final RegisterPage registerPage;

    public RegisterPageSteps() {
        registerPage = new RegisterPage();
    }

    @Given("Register page is opened")
    public void registerPageIsOpened() {
        Assert.assertTrue(registerPage.isDisplayed(), "Register page should be opened");
    }

    @When("I fill following fields on Personal Details form on Register page and save as {string}:")
    public void iSetFollowingValuesForRegisterFormAndSaveAsAccount(String key, Map<String, String> data) {
        User user = new User();
        data.forEach((field, value) -> {
            if (field.equals("EMAIL")) {
                value = String.format(MAIL_ADDRESS_PATTERN, TimeUtil.getTimestamp(), SERVER_ID);
            }
            String selectedValue = registerPage.getPersonalDetailsForm().setFieldValue(PersonalDetailsFormFields.getEnumValue(field), value);
            user.setReflectionFieldValue(PersonalDetailsFormFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, user);
    }

    @And("I click Register on Personal Details form on Register page")
    public void iClickRegisterOnRegisterPage() {
        registerPage.getPersonalDetailsForm().clickRegister();
    }

    @Then("Company logo form on Register page is opened")
    public void companyLogoFormOnRegisterPageIsOpened() {
        Assert.assertTrue(registerPage.getCompanyLogoForm().isDisplayed(),
                "Company logo form on Register should be opened");
    }
}
