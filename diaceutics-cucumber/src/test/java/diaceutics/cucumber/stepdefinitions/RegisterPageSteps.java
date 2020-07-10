package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.RegisterPageFields;
import diaceutics.selenium.models.Account;
import diaceutics.selenium.pageobject.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class RegisterPageSteps {

    private final RegisterPage registerPage;

    public RegisterPageSteps() {
        registerPage = new RegisterPage();
    }

    @Given("Register page is opened")
    public void registerPageIsOpened() {
        Assert.assertTrue(registerPage.isDisplayed(), "Register page should be opened");
    }

    @When("I fill following fields on Register page and save as {string}:")
    public void iSetFollowingValuesForRegisterFormAndSaveAsAccount(String key, Map<String, String> data) {
        Account account = new Account();
        data.forEach((field, value) -> {
            String selectedValue = registerPage.setFieldValue(RegisterPageFields.getEnumValue(field), value);
            account.setReflectionFieldValue(RegisterPageFields.getEnumValue(field).getModelField(), selectedValue);
        });

        XmlFileStore.store(key, account);
    }

    @And("I click Register on Register page")
    public void iClickRegisterOnRegisterPage() {
        registerPage.clickRegister();
    }
}
