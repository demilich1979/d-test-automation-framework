package diaceutics.selenium.utilities;

import java.util.Random;

public class NumberUtil {

    public static int getRandomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
