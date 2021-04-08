package by.a1qa.screens;


import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ShowsScreen extends Screen {
    private final ILabel locationLbl = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/location_name"), "Location name");
    private final IButton allShowsBtn = getElementFactory().getButton(By.id("com.todaytix.TodayTix:id/tab_all_shows"), "All shows button");
    private final IButton discoverBtn = getElementFactory().getButton(By.id("com.todaytix.TodayTix:id/tab_discover"), "Discover button");

    public ShowsScreen() {
        super(By.id("com.todaytix.TodayTix:id/root_view"), "Shows Page");
    }

    public String getLocName() {
        return locationLbl.getText();
    }

    public boolean isShowsScreen(){
        boolean flag = false;
        if(allShowsBtn.getElement().isDisplayed()) {
            flag = true;
        }
        return flag;
    }

    public void clickDiscoverButton(){
        discoverBtn.click();
    }
}
