package task_6_5_3_Test;

import static common.Urls.ALERT_PAGE;
import static steps.asserts.AssertForTests.checkAlertIsClosed;
import static steps.asserts.AssertForTests.checkAlertText;
import static steps.asserts.AssertForTests.checkTextContainsOnPage;
import static steps.task_6_5_3.AlertSteps.acceptAlert;
import static steps.task_6_5_3.AlertSteps.clickJsAlert;
import static steps.task_6_5_3.AlertSteps.clickJsConfirm;
import static steps.task_6_5_3.AlertSteps.clickJsPrompt;
import static steps.task_6_5_3.AlertSteps.dismissAlert;
import static steps.task_6_5_3.AlertSteps.enterTextToAlert;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertTest extends BaseTest {

    @BeforeEach
    public void openBrowser() throws InterruptedException {
        openBrowser(ALERT_PAGE);
    }

    @Test
    @DisplayName("Взаимодействие с Alert")
    @Description("Текст в алерте - I am a JS Alert")
    public void alertAcceptCheckTextTest() {
        clickJsAlert(driver);
        checkAlertText(driver, "I am a JS Alert");
        acceptAlert(driver);
        checkAlertIsClosed(driver);
    }

    @Test
    @DisplayName("Взаимодействие с Confirm")
    @Description("Алерт закрылся")
    public void alertDismissTest() {
        clickJsConfirm(driver);
        dismissAlert(driver);
        checkAlertIsClosed(driver);
    }

    @Test
    @DisplayName("Взаимодействие с Prompt")
    @Description("Введеный текст отображается на странице после принятия алерта")
    public void alertTextInput() throws InterruptedException {
        String text = "Hello World";
        clickJsPrompt(driver);
        enterTextToAlert(driver, text);
        acceptAlert(driver);
        checkTextContainsOnPage(driver, text);
    }

}
