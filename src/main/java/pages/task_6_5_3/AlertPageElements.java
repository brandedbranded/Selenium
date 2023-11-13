package pages.task_6_5_3;

import org.openqa.selenium.By;

public class AlertPageElements {
    public static By jsAlertBtn = By.xpath("//button[@onclick='jsAlert()']");
    public static By jsConfirmBtn = By.xpath("//button[@onclick='jsConfirm()']");
    public static By jsPromptBtn = By.xpath("//button[@onclick='jsPrompt()']");
}
