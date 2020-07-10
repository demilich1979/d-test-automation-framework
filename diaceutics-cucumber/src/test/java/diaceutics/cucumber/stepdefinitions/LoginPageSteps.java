package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.DataReader;
import diaceutics.selenium.models.User;
import diaceutics.selenium.pageobject.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginPageSteps {

    private final LoginPage loginPage;

    public LoginPageSteps() {
        loginPage = new LoginPage();
    }

    @Given("Login page is opened")
    public void assertLoginPageIsOpened() {
        Assert.assertTrue(loginPage.isDisplayed(), "login page should be opened");
    }

    @When("I login as {string} user")
    public void iLoginAsUser(String userName) {
        User user = DataReader.getUserInfoByUserName(userName);
        if (user.getPassword().trim().isEmpty()){
            user.setPassword(System.getProperty("password"));
        }
        if (user.getUsername().trim().isEmpty()){
            user.setPassword(System.getProperty("username"));
        }

        loginPage.logInAs(user);
    }
}
