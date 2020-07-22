package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.CollaborationsPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AddCollaborationsPageSteps {

    private final CollaborationsPage collaborationsPage;

    public AddCollaborationsPageSteps() {
        collaborationsPage = new CollaborationsPage();
    }

    @Then("Add Collaborations page is opened")
    public void collaborationsPageIsOpened() {
        Assert.assertTrue(collaborationsPage.isDisplayed(), "Add Collaborations page should be opened");
    }

}
