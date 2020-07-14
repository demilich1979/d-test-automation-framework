package diaceutics.cucumber.hooks;

import aquality.selenium.browser.AqualityServices;
import diaceutics.selenium.configuration.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BrowserHooks {

    @Before(order = 0)
    public void goToStartUrl() {
        AqualityServices.getBrowser().goTo(Configuration.getStartUrl());
    }

    @After(order = 0)
    public void closeBrowser() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
