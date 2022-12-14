package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private By searchField = By.xpath("//input[@placeholder='Where are you going?']");
    private By destinationSelectField = By.xpath("//li[@data-label='Kopaonik, Central Serbia, Serbia']//span[text()='Kopaonik']");
    private By checkInField = By.xpath("//div[@class='b91c144835']");
    private By arrivalDate = By.xpath("//td[@data-date='2022-12-31']");
    private By leavingDate = By.xpath("//td[@data-date='2023-01-08']");
    private By personCount = By.xpath("//label//span[text()='Rooms and occupancy']");
    private By personCountToOne = By.xpath("//div[contains(@class, bui-stepper__wrapper)]//button[@aria-label='Decrease number of Adults']");
    private By searchButton = By.xpath("//div[@class='xp__button']");



    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage searchDestination() {
        clickOnElement(searchField);
        typeIn(searchField, "Kopaonik");
        clickOnElement(destinationSelectField);
        return this;
    }
    public SearchPage selectDate(){
        clickOnElement(arrivalDate);
        clickOnElement(leavingDate);
        return this;
    }
    public SearchPage decreasePassengersAmount(){
        clickOnElement(personCount);
        clickOnElement(personCountToOne);
        return this;
    }
    public BookingPage clickSearch(){
        clickOnElement(searchButton);
        return new BookingPage(driver);
    }
}
