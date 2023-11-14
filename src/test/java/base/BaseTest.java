package base;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    public static void openBrowser(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "S:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(url);
        TimeUnit.SECONDS.sleep(2);
    }

    @AfterEach
    public void quit() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        driver.quit();
    }

}
