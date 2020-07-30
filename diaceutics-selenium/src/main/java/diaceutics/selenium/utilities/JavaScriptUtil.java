package diaceutics.selenium.utilities;

import aquality.selenium.browser.AqualityServices;
import diaceutics.selenium.enums.javaScript.JavaScript;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

    public static boolean waitForAngular() {
            return Boolean.parseBoolean(AqualityServices
                    .getBrowser().executeScript(JavaScript.WAIT_FOR_ANGULAR.getScript()).toString());
    }

    public static void makeElementStyleVisible(WebElement element) {
            AqualityServices.getBrowser().executeScript(JavaScript.MAKE_ELEMENT_STYLE_VISIBLE.getScript(), element);
    }

    public static void scrollHorizontalBarToRight(WebElement element) {
            AqualityServices.getBrowser().executeScript(JavaScript.SCROLL_HORIZONTAL_BAR_TO_RIGHT.getScript(), element);
    }

}
