package diaceutics.selenium.utilities;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import org.openqa.selenium.WebElement;

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

    public static void makeElementStyleVisible(WebElement element) {
        try {
            AqualityServices.getBrowser().executeScript(
                    new File(ResourceUtil.getResourcePath("makeElementStyleVisible.js")), element);
        } catch (IOException e) {
            Logger.getInstance().warn(e.getMessage());
        }
    }

    public static void scrollHorizontalBarToRight(WebElement element) {
        try {
            AqualityServices.getBrowser().executeScript(
                    new File(ResourceUtil.getResourcePath("scrollHorizontalBarToRight.js")), element);
        } catch (IOException e) {
            Logger.getInstance().warn(e.getMessage());
        }
    }

}
