package utils;

import aquality.selenium.browser.AqualityServices;

public class LoggerUtils {
    private static void info(String message) {
        AqualityServices.getLogger().info(message);
    }

    private static void debug(String message) {
        AqualityServices.getLogger().debug(message);
    }
}
