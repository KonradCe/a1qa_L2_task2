package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestDataUtils {

    public static String getHomePageUrl() {
        ISettingsFile testData = new JsonSettingsFile("test_data.json");
        return testData.getValue("/home_page_url").toString();
    }
}
