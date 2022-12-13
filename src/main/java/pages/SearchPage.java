package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {


    private By searchField = By.xpath("//input[@class='ce45093752']");
    private By destinationSelectField = By.xpath("//div[@class='a40619bfbe' and text()='Kopaonik']/ancestor::div[@role='button']");
    private By checkInField = By.xpath("//div[@class='b91c144835']");
    private By arrivalDate = By.xpath("//span[@data-date='2022-12-31']");
    private By leavingDate = By.xpath("//span[@data-date='2023-01-08']");
    private By personCount = By.xpath("//button[@class='d47738b911 b7d08821c3']");
    private By personCountToOne = By.xpath("//button[@class='fc63351294 a822bdf511 e3c025e003 fa565176a8 f7db01295e e1b7cfea84 cd7aa7c891']");
    private By doneButton = By.xpath("//button[@class='fc63351294 a822bdf511 e2b4ffd73d f7db01295e af18dbd5a4 a9a04704ee d285d0ebe9']");
    private By searchButton = By.xpath("//button[@class='fc63351294 a822bdf511 d4b6b7a9e7 cfb238afa1 af18dbd5a4 f4605622ad aa11d0d5cd']");


    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public void  searchPageConditions() {

        clickOnElement(searchField);
        typeIn(searchField, "Kopaonik");
        clickOnElement(destinationSelectField);
        clickOnElement(checkInField);
        clickOnElement(arrivalDate);
        clickOnElement(leavingDate);
        clickOnElement(personCount);
        clickOnElement(personCountToOne);
        clickOnElement(doneButton);
        clickOnElement(searchButton);

    }
}
