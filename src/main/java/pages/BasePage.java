package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }
    protected void typeIn(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void hover(By locator){
        new Actions(driver)
                .moveToElement(getElement(locator))
                .perform();
    }

    private void hoverAndClick(By locator) {
        new Actions(driver)
                .moveToElement(getElement(locator))
                .click()
                .perform();
    }



    protected void clickOnElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        } catch(ElementClickInterceptedException ex) {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            hoverAndClick(locator);
        } catch(StaleElementReferenceException staleEl) {
            getElement(locator).click();
        } catch(TimeoutException te) {
            te.printStackTrace();
            WebElement element = getElement(locator);
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to click on element!");
        }
    }

    protected boolean matchExpectedText(By locator, String expectedText) {
        WebElement element = getElement(locator);
        if (element.getText().trim().equals(expectedText)) {
            System.out.println("Passed");
            return true;
        } else {
            System.out.println("Failed");
        }
        return false;
    }
    public String getTextFromElement(By locator){
        return driver.findElement(locator).getText();
    }

//    protected WebElement findRandomElement(By locator) {
//        Random random = new Random();
//        List<WebElement> list = driver.findElements(locator);
//        int randomElement = random.nextInt(list.size());
//        return list.get(randomElement);
//    }
}
