package steps.task_6_5_3;

import org.openqa.selenium.WebDriver;
import pages.task_6_5_3.NewWindowPageElements;

public class NewWindowSteps extends NewWindowPageElements {

    public static void openNewWindow(WebDriver driver) {
        driver.findElement(newWindowBtn).click();
    }

    public static void closeActiveWindowAndSwitchBack(WebDriver driver, String window1) {
        driver.close();
        driver.switchTo().window(window1);
    }


}
