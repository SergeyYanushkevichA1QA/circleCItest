package by.a1qa.steps;

import aquality.appium.mobile.application.AqualityServices;
import by.a1qa.data.Constants;
import by.a1qa.screens.CityScreen;
import by.a1qa.screens.LocationScreen;
import by.a1qa.screens.MainScreen;
import by.a1qa.screens.SignUpScreen;
import org.testng.Assert;

public class TestSteps {
    private static MainScreen mainScreen = new MainScreen();
    private static SignUpScreen signUpScreen = new SignUpScreen();
    private static CityScreen cityScreen = new CityScreen();
    private static LocationScreen locationScreen = new LocationScreen();

    public static void onboarding() {
        AqualityServices.getLogger().info("Step 0. Location - " + Constants.cityName);
        Assert.assertEquals(mainScreen.getTitle(), Constants.firstTitle, "Checking title of screen on 1st page indicator");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), Constants.secondTitle, "Checking title of screen on 2nd page indicator");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), Constants.thirdTitle, "Checking title of screen on 3rd page indicator");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), Constants.fourthTitle, "Checking title of screen on 4th page indicator");
        locationScreen.clickSelectButton();
        cityScreen.chooseCity(Constants.cityName);
        Assert.assertEquals(signUpScreen.getTitle(), Constants.fifthTitle, "Title is not correct");
        signUpScreen.clickContinueWithoutSignUp();
    }
}
