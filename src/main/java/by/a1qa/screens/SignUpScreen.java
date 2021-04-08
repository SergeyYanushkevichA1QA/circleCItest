package by.a1qa.screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class SignUpScreen extends Screen {
    private final IButton selectBtn = getElementFactory().getButton(By.id("com.todaytix.TodayTix:id/secondary_button"), "Select Manually button");
    private final ILabel titleOnScreen = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/title"), "Title");

    public SignUpScreen() {
        super(By.className("android.widget.LinearLayout"), "SignUp Screen");
    }

    public void clickContinueWithoutSignUp() {
        selectBtn.click();
    }

    public String getTitle() {
        return titleOnScreen.getText();
    }
}
