package steps.task_6_5_3;

import org.openqa.selenium.WebDriver;
import pages.task_6_5_3.AlertPageElements;

public class AlertSteps extends AlertPageElements {

    public static void clickJsAlert(WebDriver driver) {
        driver.findElement(jsAlertBtn).click();
    }

    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static void enterTextToAlert(WebDriver driver, String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public static void clickJsConfirm(WebDriver driver) {
        driver.findElement(jsConfirmBtn).click();
    }

    public static void clickJsPrompt(WebDriver driver) {
        driver.findElement(jsPromptBtn).click();
    }
}
