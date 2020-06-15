package aquality.selenium.template.cucumber.stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.template.configuration.Configuration;
import aquality.selenium.template.forms.pages.LabProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LabProfilePageSteps {
    private final LabProfilePage labProfilePage;

    public LabProfilePageSteps() {
        labProfilePage = new LabProfilePage();
    }

    @Given("Lab Profile is opened")
    public void labProfilePageIsOpened() {
        AqualityServices.getBrowser().goTo(Configuration.getStartUrl());
    }

    @When("I open Create a Lab page")
    public void openCreateLabPage() {
        labProfilePage.clickCreateLab();
    }

}
