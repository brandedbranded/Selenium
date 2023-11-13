package steps.asserts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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

    public static void checkRedirectedBack(WebDriver driver, String window1) {
        assertEquals(driver.getWindowHandle(), window1);
    }
}
