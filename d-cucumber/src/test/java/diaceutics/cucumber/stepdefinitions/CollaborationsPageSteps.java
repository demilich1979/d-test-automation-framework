package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.CollaborationsPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CollaborationsPageSteps {

    private final CollaborationsPage collaborationsPage;

    public CollaborationsPageSteps() {
        collaborationsPage = new CollaborationsPage();
    }

    @Then("Collaborations page is opened")
    public void collaborationsPageIsOpened() {
        Assert.assertTrue(collaborationsPage.isDisplayed(), "Collaborations page should be opened");
    }

}
