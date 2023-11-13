package task_6_5_3_Test;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.Urls.FRAMES_PAGE;
import static steps.task_6_5_3.FrameSteps.*;

public class FrameTest extends BaseTest {

    @Test
    @DisplayName("Взаимодействие с элементами внутри фрейма")
    @Description("Введенный текст оформляется жирным шрифтом, браузер закрывается")
    public void framesTest() {
        openBrowser(FRAMES_PAGE);
        goToIFrame(driver);
        printTextInFrame(driver);
        makeTextBold(driver);
    }
}
