package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.HomePage;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class HomePageSteps {

    private final HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage();
    }

    @Given("Home page is opened")
    public void homePageIsOpened() {
        Assert.assertTrue(homePage.isDisplayed(), "Home page should be opened");
    }

}
