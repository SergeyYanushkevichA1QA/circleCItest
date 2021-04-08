package by.a1qa.screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class MainScreen extends Screen {
    private final ILabel titleOnScreen = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/title"), "Title");
    private final IButton nextButton = getElementFactory().getButton(By.id("com.todaytix.TodayTix:id/next_button"), "Next Button");

    public MainScreen() {
        super(By.id("android:id/content"), "Main Page");
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public String getTitle() {
        return titleOnScreen.getText();
    }
}
