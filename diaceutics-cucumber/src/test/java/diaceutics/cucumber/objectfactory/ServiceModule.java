package diaceutics.cucumber.objectfactory;

import diaceutics.selenium.utilities.IScreenshotProvider;
import diaceutics.selenium.utilities.ScreenshotProvider;
import com.google.inject.AbstractModule;

final class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(IScreenshotProvider.class).toInstance(new ScreenshotProvider());
    }
}
