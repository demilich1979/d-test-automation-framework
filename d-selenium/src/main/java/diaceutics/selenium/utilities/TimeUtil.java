package diaceutics.selenium.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String getCurrentDate(String pattern) {
        return formatDate(new Date(), pattern);
    }

    public static String getTimestamp() {
        return getCurrentDate("yyyyMMddHHmmss");
    }
}
