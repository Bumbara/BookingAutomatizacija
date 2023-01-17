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
//    private By breakfastIncludedBanner = By.xpath("//div[@class='a53696345b' and text()='Breakfast included']");
    private By seeAvailabilityButton = By.xpath("//div[text()='Breakfast included']//ancestor::div[@data-testid='property-card']//a//span[text()='See availability']");
    private By apartmentChoice = By.xpath("//div[text()='Breakfast included']//ancestor::div[@data-testid='property-card']");
    private By apartmentPrice = By.xpath("//div[text()='Breakfast included']//ancestor::div[@data-testid='property-card']//span[@data-testid='price-and-discounted-price']");

    //"//div[text()='Breakfast included']//ancestor::div[@data-testid='property-card']//a//span[text()='See availability']"
    //"//span[text()='See availability']//ancestor::a[@target='_blank']"

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public boolean bookingPageOpened() {
        return matchExpectedText(verificationText, "Filter by:");
    }
    public BookingPage verifyBookingPge() {
        Assert.isTrue(bookingPageOpened(), "Cannot open Booking page!");
        return this;
    }

    public BookingPage checkBreakfastIncluded() throws InterruptedException {
        clickOnElement(breakfastIncludedCheckbox);
        Thread.sleep(3000);
        return this;
    }

    public void randomChoice(By locator) {
        Random random = new Random();
        List<WebElement> list = driver.findElements(locator);
        int randomElement = random.nextInt(list.size());
        WebElement element = list.get(randomElement);
    }
    public String priceCatcher() {
        return getTextFromElement(apartmentPrice);
    }
    public ApartmentDetailsPage clickSeeAvailability(){
        clickOnElement(seeAvailabilityButton);
        return new ApartmentDetailsPage(driver);
    }

}
