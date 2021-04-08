package by.a1qa.tests;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseTest {

    @BeforeClass
    public void setup(){
        AqualityServices.getApplication();
        AqualityServices.getLogger().info("App is opened");
    }

    @AfterClass
    public void tearDown() {
        if (AqualityServices.isApplicationStarted())
            AqualityServices.getApplication().getDriver().quit();
        AqualityServices.getLogger().info("App is closed");
    }
}

