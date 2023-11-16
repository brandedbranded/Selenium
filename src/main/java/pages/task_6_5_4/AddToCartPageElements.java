package pages.task_6_5_4;

import org.openqa.selenium.By;

public class AddToCartPageElements {

    public static By filterBtn = By.xpath("//span[@class='nav-element__burger-line']");
    public static By householdBtn = By.xpath("//li[@data-menu-id='16107']");
    public static By homeAppliancesBtn = By.xpath("//span[contains(text(), 'Техника для дома')]");
    public static By vacuums = By.linkText("Пылесосы и пароочистители");
    public static By filterPath = By.xpath("//ul[@class='breadcrumbs__list']");
    public static By catalogTitle = By.xpath("//h1[@class='catalog-title']");
    public static By firstVacuum = By.xpath("(//div[@class='product-card__wrapper'])[1]");
    public static By addToBasket = By.xpath(
        "//a[@class='product-card__add-basket j-add-to-basket btn-main-sm']");
    public static By counterAboveBasket = By.xpath("//span[@class='navbar-pc__notify']");
    public static By basketBtn = By.xpath(
        "//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public static By nameOfItem = By.cssSelector(".product-card__name");
    public static By priceOfItem = By.xpath("//ins[@class='price__lower-price']");
    public static By priceInsideBasket = By.xpath("//div[@class='list-item__price-new']");
    public static By sumPriceInBasket = By.cssSelector("p.b-top__total span[data-jsv]");
    public static By orderBtn = By.xpath("//button[@data-link='{on submitOrder ~tag}']");
}
