package by.a1qa.utils;

public class PriceParser {
    private static String regPrice ="[0-9]\\d*.*";

    public static double parsePrice(String data) {
        return Double.parseDouble(RegexUtils.getDataFromRegularExpression(regPrice, data));
    }
}