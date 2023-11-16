package steps.task_6_5_4;

import static pages.task_6_5_4.SearchPageElements.searchLine;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WbSteps {

    public static WebDriverWait driverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public static void searchForItem(WebDriver driver, String item) {
        WebDriverWait wait = driverWait(driver);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchLine)));
        driver.findElement(searchLine).sendKeys(item + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//body"))));
    }

    public static void clickOn(By element, WebDriver driver) {
        WebDriverWait wait = driverWait(driver);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//body"))));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public static void sendTextToInput(By element, String text, WebDriver driver) {
        WebDriverWait wait = driverWait(driver);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//body"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//body"))));
    }

    public static String getTextFromElement(By element, WebDriver driver) {
        WebDriverWait wait = driverWait(driver);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        return driver.findElement(element).getText();
    }

    public static void moveToElement(By element, WebDriver driver) {
        WebDriverWait wait = driverWait(driver);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        WebElement element1 = driver.findElement(element);
        Actions actions = new Actions(driver);
        actions
            .moveToElement(element1)
            .build()
            .perform();
    }

    public static String countItemsOnPage(WebDriver driver) {
        List<WebElement> listItems = driver.findElements(
            By.xpath("//a[@class='product-card__link j-card-link j-open-full-product-card']"));
        return String.valueOf(listItems.size());
    }
}
