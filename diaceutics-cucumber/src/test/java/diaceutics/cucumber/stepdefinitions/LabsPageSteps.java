package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.forms.pages.LabsPage;
import diaceutics.selenium.models.CreateLabInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;

public class LabsPageSteps {
    private final LabsPage labsPage;
    private final ScenarioContext scenarioContext;

    @Inject
    public LabsPageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext=scenarioContext;
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


    @When("I choose a {string} under Find Lab for labs {string} and press Search icon")
    public void iChooseACountryUnderFindLabForLabsLabNameAndPressSearchIcon(String countryKey, String labKey) {
        CreateLabInfo lab = XmlFileStore.get(labKey);
        String country = lab.getCountry();
        labsPage.chooseCountry(country);
        scenarioContext.add(countryKey,country);
        labsPage.clickSearch();
    }

    @When("I put a Lab {string} an Search textbox and press Search icon")
    public void iPutALabLabNameAnSearchTextboxAndPressSearchIcon() {
    }
}
