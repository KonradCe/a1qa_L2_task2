package utils;

import aquality.selenium.core.logging.Logger;

import java.util.Random;

public class StringUtils {

    private final static Logger logger = Logger.getInstance();

    public static String createValidPassword() {
        Random random = new Random();
        int numberOfChars = random.nextInt(10) + 10;
        int numberOfDigits = random.nextInt(5) + 1;
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < numberOfChars; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            if (i % 2 == 0) {
                randomChar = Character.toUpperCase(randomChar);
            }
            password.append(randomChar);
        }
        for (int i = 0; i < numberOfDigits; i++) {
            int randomDigit = random.nextInt(10);
            password.append(randomDigit);
        }
        logger.debug("Generated password is: " + password);
        return password.toString();
    }

    public static String createRandomWord(int numberOfLettersInWord) {
        Random random = new Random();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < numberOfLettersInWord; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            word.append(randomChar);
        }
        return word.toString();
    }
}
