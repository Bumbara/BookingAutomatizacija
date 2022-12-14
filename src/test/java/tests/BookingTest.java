package tests;

import org.testng.annotations.Test;
import pages.BookingPage;
import pages.SearchPage;

public class BookingTest extends BaseTest{

    @Test
    public void searchPageTest() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchDestination().selectDate().decreasePassengersAmount().clickSearch().verifyBookingPge();
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.checkBreakfastIncluded().randomChoice();
    }
}
