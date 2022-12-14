package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class BookingPage extends BasePage{


    private By verificationText = By.xpath("//h2[text()='Filter by:']");
    private By breakfastIncludedCheckbox = By.xpath("//div[text()='Breakfast Included']//ancestor::div[@data-filters-item='popular:mealplan=1']");
    private By breakfastIncludedBanner = By.xpath("//div[@class='a53696345b' and text()='Breakfast included']");
    private By seeAvailabilityButton = By.xpath("//span[text()='See availability']//ancestor::a[@target='_blank']");
    private By apartmentChoice = By.xpath("//div[text()='Breakfast included']//ancestor::div[@data-testid='property-card']//a//span[text()='See availability']");

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public boolean bookingPageOpened() {
        return matchExpectedText(verificationText, "Filter by:");
    }
    public void verifyBookingPge() {
        Assert.isTrue(bookingPageOpened(), "Cannot open Booking page!");
    }

    public BookingPage checkBreakfastIncluded() throws InterruptedException {
        clickOnElement(breakfastIncludedCheckbox);
        Thread.sleep(3000);
        return this;
    }

    public ApartmentDetailsPage randomChoice() {

        List<WebElement> list = driver.findElements(apartmentChoice);
        int listLength = list.size();
        Random random = new Random();
        int randomChoiceDiv = random.nextInt(listLength);
        list.get(randomChoiceDiv).click();
        return new ApartmentDetailsPage(driver);
    }

}
