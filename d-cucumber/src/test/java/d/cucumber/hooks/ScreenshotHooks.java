package diaceutics.cucumber.hooks;

import diaceutics.selenium.utilities.IScreenshotProvider;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import javax.inject.Inject;

public class ScreenshotHooks {

    private final IScreenshotProvider screenshotProvider;

    @Inject
    public ScreenshotHooks(IScreenshotProvider screenshotProvider) {
        this.screenshotProvider = screenshotProvider;
    }

    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(screenshotProvider.takeScreenshot(), "image/png", "screenshot");
        }
    }
}
