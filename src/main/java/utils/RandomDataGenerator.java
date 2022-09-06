package utils;

import java.util.Random;

public class RandomDataGenerator {

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
}
