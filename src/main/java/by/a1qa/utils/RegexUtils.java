package by.a1qa.utils;

import aquality.appium.mobile.application.AqualityServices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public static String getDataFromRegularExpression(String expression, String data) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(data);
        if(matcher.find()) {
            return matcher.group(0).trim();
        } else {
            AqualityServices.getLogger().info("No matches");
            return null;
        }
    }
}
