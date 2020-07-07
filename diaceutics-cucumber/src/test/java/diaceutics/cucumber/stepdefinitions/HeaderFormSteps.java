package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.forms.HeaderForm;
import io.cucumber.java.en.When;

public class HeaderFormSteps {

    private final HeaderForm headerForm;

    public HeaderFormSteps() {
        headerForm = new HeaderForm();
    }

    @When("I click {string} on Header form")
    public void iClickOnHeaderFormOnAssayManagementPage(String linkName) {
        headerForm.clickBy(linkName);
    }
}
