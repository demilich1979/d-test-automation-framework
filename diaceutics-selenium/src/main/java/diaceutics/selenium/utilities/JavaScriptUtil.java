package diaceutics.selenium.utilities;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;

import java.io.File;
import java.io.IOException;

public class JavaScriptUtil {
    public static boolean waitForAngular() {
        try {
            return Boolean.parseBoolean(AqualityServices
                    .getBrowser().executeScript(new File(ResourceUtil.getResourcePath("waitForAngular.js"))).toString());
        } catch (IOException e) {
            Logger.getInstance().warn(e.getMessage());
            return false;
        }
    }
}
