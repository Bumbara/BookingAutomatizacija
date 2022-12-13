package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage;

public class BookingTest extends BaseTest{

    SearchPage search;

    @BeforeMethod
    public void localSetup() {
        search = new SearchPage(driver);
    }

    @Test
    public void searhPageTest(){
        search.searchPageConditions();
    }
}
