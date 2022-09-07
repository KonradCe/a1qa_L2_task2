package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.util.List;
import java.util.Random;

public class TestDataUtils {

    private static final ISettingsFile testData = new JsonSettingsFile("test_data.json");

    public static String getHomePageUrl() {
        return testData.getValue("/home_page_url").toString();
    }

    public static List<String> getInterestsToSelect() {
        return testData.getList("interests");
    }

    public static String createValidPassword() {
        Random random = new Random();
        int numberOfChars = random.nextInt(10) + 10;
        int numberOfDigits = random.nextInt(5) + 1;
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < numberOfChars; i ++) {
            char randomChar = (char)(random.nextInt(26) + 'a');
            if (i % 2 == 0) {
                randomChar = Character.toUpperCase(randomChar);
            }
            password.append(randomChar);
        }
        for (int i = 0; i < numberOfDigits; i++) {
            int randomDigit = random.nextInt(10);
            password.append(randomDigit);
        }

        System.out.printf("Generated password: %s", password);

        return password.toString();
    }

    public static String createRandomWord(int numberOfLettersInWord) {
        Random random = new Random();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < numberOfLettersInWord; i ++) {
            char randomChar = (char)(random.nextInt(26) + 'a');
            word.append(randomChar);
        }
        return word.toString();
    }


}
