package by.a1qa.tests;

import aquality.appium.mobile.application.AqualityServices;
import by.a1qa.data.Constants;
import by.a1qa.models.Show;
import by.a1qa.models.Ticket;
import by.a1qa.screens.*;
import by.a1qa.steps.TestSteps;
import by.a1qa.testreport.ScreenshotListener;
import by.a1qa.utils.ListUtils;
import by.a1qa.utils.TicketUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(ScreenshotListener.class)
public class AddTicketToBasketTest extends BaseTest {
    private static ShowsScreen showsScreen = new ShowsScreen();
    private static DiscoverScreen discoverScreen = new DiscoverScreen();
    private static ShowPage showPage = new ShowPage();
    private static TicketScreen ticketScreen = new TicketScreen();
    private static LogInScreen logInScreen = new LogInScreen();

    @Test
    public void addTicketsToBasketTest() {
        TestSteps.onboarding();

        AqualityServices.getLogger().info("Step 1");
        showsScreen.clickDiscoverButton();
        Assert.assertTrue(discoverScreen.isOnDiscoverScreen(), "Isn't discover screen");

        AqualityServices.getLogger().info("Step 2");
        discoverScreen.swipeToShows();
        List<Show> shows = ListUtils.getSortedShowList(discoverScreen.getShows());
        String showNameWithLowPrice = shows.get(0).getShowName();
        discoverScreen.clickShowByName(showNameWithLowPrice);
        Assert.assertTrue(showPage.isOnShowPage(), "Isn't show page");
        Assert.assertEquals(showPage.getShowName(), showNameWithLowPrice.toUpperCase());

        AqualityServices.getLogger().info("Step 3");
        showPage.swipeToCalendar();
        showPage.clickRandomDate();
        Ticket ticket = new Ticket(TicketUtils.getDate(showPage.getDate()), showPage.getTime());
        showPage.acceptTickets();
        Assert.assertEquals(ticket.getDate(), TicketUtils.getDate(showPage.getTicketInfo()), "Wrong date");
        Assert.assertEquals(ticket.getTime(), TicketUtils.getTime(showPage.getTicketInfo()), "Wrong time");
        String numberOfTickets = "2";
        Assert.assertEquals(numberOfTickets + " tickets", TicketUtils.getTicketsNumber(showPage.getTicketInfo()), "Wrong ticket number");

        AqualityServices.getLogger().info("Step 4");
        Assert.assertTrue(ticketScreen.isOnTicketScreen(), "Isn't ticket screen");
        Ticket expensiveTicket = new Ticket(TicketUtils.getPrice(ticketScreen.getPrice()));
        ticketScreen.clickMostExpensiveTicket();
        ticketScreen.waitForHoldTimer();
        Assert.assertEquals(ticketScreen.getHoldTimerTxt(), Constants.holdTimerTxt, "Hold timer isnt equal");
        Assert.assertEquals(numberOfTickets + " x " + expensiveTicket.getPrice(),
                ticketScreen.getNumberOfTicketsAndPrice(), "Number of tickets and price arent equal");

        AqualityServices.getLogger().info("Step 5");
        ticketScreen.clickContinueBtn();
        Assert.assertTrue(logInScreen.isOnLoginScreen(), "Isnt login screen");
    }
}
