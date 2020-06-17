package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.forms.pages.LabsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LabsPageSteps {
    private final LabsPage labsPage;

    public LabsPageSteps() {
        labsPage = new LabsPage();
    }

    @Given("Labs page is opened")
    public void labsPageIsOpened() {
        Assert.assertTrue(labsPage.isDisplayed(), "Labs page should be opened");
    }

    @When("I open Create a Lab page")
    public void openCreateLabPage() {
        labsPage.clickCreateLab();
    }

    @Then("I select {string} country on Labs page")
    public void iSelectCountryOnLabsPage(String countryName) {
        labsPage.clickByCountryLink(countryName);
    }
}
