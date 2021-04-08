package by.a1qa.tests;

import aquality.appium.mobile.application.AqualityServices;
import by.a1qa.data.Constants;
import by.a1qa.models.City;
import by.a1qa.screens.*;
import by.a1qa.testreport.ScreenshotListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class OnboardingTest extends BaseTest {
    private static MainScreen mainScreen = new MainScreen();
    private static LocationScreen locationScreen = new LocationScreen();
    private static SignUpScreen signUpScreen = new SignUpScreen();
    private static CityScreen cityScreen = new CityScreen();
    private static ShowsScreen showsScreen = new ShowsScreen();

    @Test
    public void onboardingTest() {
        AqualityServices.getLogger().info("Step 1");
        Assert.assertEquals(mainScreen.getTitle(), Constants.firstTitle, "Isnt title of screen on 1st page indicator");

        AqualityServices.getLogger().info("Step 2");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), Constants.secondTitle, "Isnt title of screen on 2nd page indicator");

        AqualityServices.getLogger().info("Step 3");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), Constants.thirdTitle, "Isnt title of screen on 3rd page indicator");

        AqualityServices.getLogger().info("Step 4");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), Constants.fourthTitle, "Isnt title of screen on 4th page indicator");

        AqualityServices.getLogger().info("Step 5");
        locationScreen.clickSelectButton();
        City city = new City(cityScreen.getRandomCityName());
        cityScreen.selectRandomCity();
        Assert.assertEquals(signUpScreen.getTitle(), Constants.fifthTitle, "Title is not correct");

        AqualityServices.getLogger().info("Step 6");
        signUpScreen.clickContinueWithoutSignUp();
        Assert.assertTrue(showsScreen.isShowsScreen(), "Arent shows screen");
        City locCity = new City(showsScreen.getLocName());
        Assert.assertEquals(city, locCity, "Location on shows screen with chosen arent equals");
    }

}
