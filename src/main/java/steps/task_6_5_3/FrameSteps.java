package steps.task_6_5_3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.task_6_5_3.FramePageElements;

public class FrameSteps extends FramePageElements {
    public static void goToIFrame(WebDriver driver) {
        driver.findElement(frameBtn).click();
    }

    public static void printTextInFrame(WebDriver driver) {
        driver.findElement(selectAllBtn).click();
        driver.switchTo().frame(frameName);
        driver.findElement(writingField).sendKeys(Keys.BACK_SPACE + "Hello World");
        driver.switchTo().defaultContent();
    }

    public static void makeTextBold (WebDriver driver) {
        driver.findElement(selectAllBtn).click();
        driver.findElement(boldBtn).click();
    }
}
