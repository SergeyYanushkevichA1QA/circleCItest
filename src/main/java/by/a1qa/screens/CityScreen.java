package by.a1qa.screens;

import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import by.a1qa.utils.RandomNumberGenerator;
import org.openqa.selenium.By;

import java.util.List;

public class CityScreen extends Screen {
    private final ILabel locationList = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/location_list"), "Location list");
    private final By citiesLoc = By.xpath("//*[contains(@resource-id, 'com.todaytix.TodayTix:id/location_text')]");

    public CityScreen() {
        super(By.className("android.widget.TextView"), "City Page");
    }

    public void selectRandomCity() {
        if(locationList.state().isDisplayed()) {
            getCitiesList().get(RandomNumberGenerator.getRandomNumber()).click();
        }
    }

    private List<ILabel> getCitiesList() {
        return getElementFactory().findElements(citiesLoc, ElementType.LABEL);
    }

    public String getRandomCityName() {
        RandomNumberGenerator number = new RandomNumberGenerator(getCitiesList().size());
        return getCitiesList().get(number.getRandomNumber()).getText();
    }

    public void chooseCity(String cityName) {
        getCitiesList().stream()
                .filter(s -> s.getText().equals(cityName)).findAny().get().click();
    }
}
