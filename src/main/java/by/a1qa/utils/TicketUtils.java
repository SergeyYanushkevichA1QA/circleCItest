package by.a1qa.utils;

public class TicketUtils {
    private static String regDate = "\\w{3,20}\\s\\d*";
    private static String regTime = "(\\d*)?:(\\d*)\\s[A-Z]*";
    private static String regTicket = "\\d*\\s\\w{6,7}";
    private static String regPrice =".[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*";

    public static String getDate(String data) {
        return RegexUtils.getDataFromRegularExpression(regDate, data);
    }

    public static String getTime(String data) {
        return RegexUtils.getDataFromRegularExpression(regTime, data);
    }

    public static String getTicketsNumber(String data) {
        return RegexUtils.getDataFromRegularExpression(regTicket, data);
    }

    public static String getPrice(String data) {
        return RegexUtils.getDataFromRegularExpression(regPrice, data);
    }
}
