package by.a1qa.utils;

public class RandomNumberGenerator {
    private static int randomNumber;

    public RandomNumberGenerator(int border) {
        setRandomNumber(border);
    }

    public static int getRandomNumber() {
        return randomNumber;
    }

    private static void setRandomNumber(int border) {
        randomNumber = 0 + (int) (Math.random() * border);
    }
}
