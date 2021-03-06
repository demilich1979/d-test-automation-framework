package diaceutics.cucumber.utilities;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SoftAssert {
    private static final ThreadLocal<SoftAssert> SOFT_ASSERT_HOLDER = new ThreadLocal<>();
    private final List<String> results = new ArrayList<>();
    private static final String RESULT_EQUALS_MESSAGE_TEMPLATE = "%s%nActual value: %s%nExpected value: %s";

    public static SoftAssert getInstance() {
        if (SOFT_ASSERT_HOLDER.get() == null) {
            SOFT_ASSERT_HOLDER.set(new SoftAssert());
        }
        return SOFT_ASSERT_HOLDER.get();
    }

    public void clear() {
        results.clear();
        SOFT_ASSERT_HOLDER.remove();
    }

    public void assertTrue(boolean condition,
                           String message) {
        performAssert(
                () -> Assert.assertTrue(condition),
                message
        );
    }

    public void assertFalse(boolean condition,
                           String message) {
        performAssert(
                () -> Assert.assertFalse(condition),
                message
        );
    }

    public void assertEquals(Object actual,
                             Object expected,
                             String message) {
        performAssert(
                () -> Assert.assertEquals(expected, actual),
                String.format(RESULT_EQUALS_MESSAGE_TEMPLATE, message, actual, expected)
        );
    }

    public void assertAll() {
        if (!results.isEmpty()) {
            StringBuilder finalMsgBuilder = new StringBuilder(String.format("Some of assertions were completed with errors:%n"));
            results.forEach(res -> finalMsgBuilder.append(String.format("%s%n", res)));
            results.clear();
            throw new AssertionError(finalMsgBuilder.toString());
        }
    }

    private void performAssert(Runnable assertion,
                               String message) {
        try {
            assertion.run();
        } catch (AssertionError var) {
            results.add(message);
        }
    }

}
