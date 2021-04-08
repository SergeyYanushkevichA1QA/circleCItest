package by.a1qa.screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class ShowPage extends Screen {
    private final ILabel slideImg = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/slide_image"), "Slide img");
    private final ILabel showName = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/show_name"), "Show name");
    private final ILabel acceptTickets = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/performance_time"), "Accept tickets");
    private final ILabel calendarLbl = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/calendar_view"), "calendar");
    private final ILabel dateLbl = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/date_label"), "Date format M Number");
    private final ILabel ticketLbl = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/date_time_label"), "Ticket");
    private final By dayLoc = By.xpath("//*[contains(@resource-id, 'com.todaytix.TodayTix:id/day_number')]");

    public ShowPage() {
        super(By.id("com.todaytix.TodayTix:id/show_name"), "Show Page");
    }

    public boolean isOnShowPage() {
        return slideImg.state().waitForDisplayed();
    }

    public String getShowName() {
        return showName.getText();
    }

    private List<ILabel> getAllDaysInCalendar() {
        return getElementFactory().findElements(dayLoc, ElementType.LABEL);
    }

    public void clickRandomDate() {
        getAllDaysInCalendar().get(new Random().nextInt(getAllDaysInCalendar().size())).click();
    }

    public String getDate() {
        return dateLbl.getText();
    }

    public void acceptTickets() {
        acceptTickets.click();
    }

    public String getTime() {
        return acceptTickets.getText();
    }

    public void swipeToCalendar() {
        calendarLbl.getTouchActions().scrollToElement(SwipeDirection.DOWN);
    }

    public String getTicketInfo() {
        return ticketLbl.getText();
    }
}
