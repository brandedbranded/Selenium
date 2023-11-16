package steps.asserts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssertForTests {

    public static void checkAlertText(WebDriver driver, String expectedText) {
        Alert alert = driver.switchTo().alert();
        assertEquals(expectedText, alert.getText());
    }

    public static boolean checkAlertIsClosed(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void checkTextContainsOnPage(WebDriver driver, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//body"))));
        assertTrue(driver.getPageSource().contains(expectedText));
    }

    public static void checkRedirectedToNewWindow(WebDriver driver, String window1) {
        Set<String> currentWindows = driver.getWindowHandles();
        String window2 = null;

        for (String window : currentWindows) {
            if (!window.equals((window1))) {
                window2 = window;
                break;
            }
        }

        driver.switchTo().window(window2);
        assertNotEquals(window1, driver.getWindowHandle());
    }

    public static void checkRedirectedToFirstWindow(WebDriver driver, String window1) {
        assertEquals(driver.getWindowHandle(), window1);
    }

    public static void verifyTextOnElement(String expectedText, By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        assertTrue(driver.findElement(element).getText().contains(expectedText));
    }

    public static void verifyPriceOnElement(String expectedText, By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        wait.until(ExpectedConditions.textToBe(element, expectedText));
        assertTrue(driver.findElement(element).getText().contains(expectedText));
    }

    public static void verifyRedirectToHomePage(String url, WebDriver driver) {
        assertTrue(
            driver.findElement(By.xpath("//base[@href]")).getAttribute("href").contains(url));
    }

    public static String getNameOfItem(By element, WebDriver driver) {
        return driver.findElement(element).getText().substring(2);
    }

    public static void verifyElementIsClickable(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void equalityOfAmount(String c, String c1) {
        assertEquals(c, c1);
    }
}
