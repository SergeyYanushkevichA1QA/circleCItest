package by.a1qa.screens;

import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class LogInScreen extends Screen {
    private final ILabel loginLbl = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/log_in"), "Login in");

    public LogInScreen() {
        super(By.id("com.todaytix.TodayTix.qa:id/log_in"), "Login Screen");
    }

    public boolean isOnLoginScreen() {
        return loginLbl.state().waitForDisplayed();
    }
}
