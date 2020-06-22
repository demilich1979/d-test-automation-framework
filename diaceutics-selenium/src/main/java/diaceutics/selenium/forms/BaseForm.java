package diaceutics.selenium.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import diaceutics.selenium.utilities.JavaScriptUtil;
import org.openqa.selenium.By;


public abstract class BaseForm extends Form {

    protected BaseForm(By locator, String name) {
        super(locator, name);
    }

    @Override
    public boolean isDisplayed() {
        AqualityServices.getConditionalWait().waitFor(JavaScriptUtil::waitForAngular);
        return super.isDisplayed();
    }
}
