package diaceutics.selenium.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtil {

    public static String regexGetMatchGroup(String text, String regex, int groupIndex) {
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(groupIndex);
        }
        throw new IllegalArgumentException(String.format("Pattern by %s was not found on %s", regex, text));
    }
}
