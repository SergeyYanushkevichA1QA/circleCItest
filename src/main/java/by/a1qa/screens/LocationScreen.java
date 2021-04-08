package by.a1qa.screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class LocationScreen extends Screen {
    private final IButton selectBtn = getElementFactory().getButton(By.id("com.todaytix.TodayTix:id/secondary_button"), "Select Manually button");

    public LocationScreen() {
        super(By.id("com.todaytix.TodayTix:id/icon"), "Location Screen");
    }

    public void clickSelectButton() {
        selectBtn.click();
    }
}
