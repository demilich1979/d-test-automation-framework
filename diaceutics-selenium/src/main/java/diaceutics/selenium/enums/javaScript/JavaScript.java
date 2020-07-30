package diaceutics.selenium.enums.javaScript;

import aquality.selenium.core.logging.Logger;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public enum JavaScript {
    WAIT_FOR_ANGULAR("waitForAngular.js"),
    MAKE_ELEMENT_STYLE_VISIBLE("makeElementStyleVisible.js"),
    SCROLL_HORIZONTAL_BAR_TO_RIGHT("scrollHorizontalBarToRight.js");

    private final String filename;

    JavaScript(String filename) {
        this.filename = filename;
    }

    public String getScript() {
        URL scriptFile = this.getClass().getResource("/js/" + this.filename);

        try {
            InputStream stream = scriptFile.openStream();
            return IOUtils.toString(stream, StandardCharsets.UTF_8.name());
        } catch (IOException var) {
            Logger.getInstance().fatal(String.format("Couldn't find the script \"%s\"", this.filename), var);
            return "";
        }
    }
}
