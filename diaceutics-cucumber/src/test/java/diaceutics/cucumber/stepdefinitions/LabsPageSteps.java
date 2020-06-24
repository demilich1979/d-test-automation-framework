package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.LabsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;

public class LabsPageSteps {
    private final LabsPage labsPage;

    @Inject
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


    @When("I choose a {string} and press Search icon")
    public void iChooseACountryAndPressSearchIcon(String country) {
        labsPage.chooseCountry(country);
        labsPage.clickSearch();
    }

    @When("I put a Lab {string} an Search textBox and press Search icon")
    public void iPutALabLabNameAnSearchTextBoxAndPressSearchIcon(String labName) {
        labsPage.putTextInSearchField(labName);
        labsPage.clickSearch();
    }

}
