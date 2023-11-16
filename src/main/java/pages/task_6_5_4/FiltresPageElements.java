package pages.task_6_5_4;

import org.openqa.selenium.By;

public class FiltresPageElements {

    public static By electronicsBtn = By.xpath("//li[@data-menu-id='4830']");
    public static By laptopsAndPc = By.xpath("//span[contains(text(), 'Ноутбуки и компьютеры')]");
    public static By laptops = By.linkText("Ноутбуки");
    public static By allFiltres = By.xpath(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--all']");
    public static By priceMin = By.xpath("(//input[@class='j-price'])[1]");
    public static By priceMax = By.xpath("(//input[@class='j-price'])[2]");
    public static By lessThan3DaysBtn = By.xpath("//*[contains(text(), 'до 3 дней')]");
    public static By brandApple = By.xpath("//span[contains(text(), 'Apple')]");
    public static By screen133 = By.xpath("//span[contains(text(), '13.3')]");
    public static By showItemsWithFiltres = By.xpath(
        "//button[@class='filters-desktop__btn-main btn-main']");
    public static By listOfFiltres = By.xpath("//ul[@class='your-choice__list']");
    public static By titleAfterSearch = By.xpath("//h1[@class='catalog-title']");
    public static By expectedAmountOfItems = By.xpath(
        "//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']");
}
