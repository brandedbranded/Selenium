package task_6_5_3_Test;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.Urls.NEW_WINDOW_PAGE;
import static steps.asserts.AssertForTests.*;
import static steps.task_6_5_3.NewWindowSteps.closeActiveWindowAndSwitchBack;
import static steps.task_6_5_3.NewWindowSteps.openNewWindow;

public class NewWindowTest extends BaseTest {

    @Test
    @DisplayName("Открытие нового окна")
    @Description("Скрипт переключается между вкладками и закрывает новую вкладку")
    public void newWindowTest() throws InterruptedException {
        openBrowser(NEW_WINDOW_PAGE);

        String window1 = driver.getWindowHandle();
        String expectedText =  "New Window";

        openNewWindow(driver);
        checkRedirectedToNewWindow(driver, window1);
        checkTextContainsOnPage(driver, expectedText);
        closeActiveWindowAndSwitchBack(driver, window1);
        checkRedirectedToFirstWindow(driver, window1);
    }
}
