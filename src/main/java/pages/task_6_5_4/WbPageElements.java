package pages.task_6_5_4;

import org.openqa.selenium.By;

public class WbPageElements {
    public static By searchLine = By.xpath("//input[@id='searchInput']");
    public static By foundItems = By.xpath("//h1[@class='searching-results__title']");
    public static By filterForItems = By.cssSelector(".dropdown-filter__btn--burger");
    public static By sortBtn = By.cssSelector(".dropdown-filter__btn--sorter");
    public static By brandOfFirstItem = By.xpath("(//span[@class='product-card__brand'])[1]");
    public static By crossBtn = By.xpath("//button[@class='search-catalog__btn search-catalog__btn--clear search-catalog__btn--active']");

    public static By addressBtn = By.xpath("//span[@data-wba-header-name='DLV_Adress']");
    public static By searchBoxInAddress = By.xpath("//input[@class='ymaps-2-1-79-searchbox-input__input']");
    public static By firstFoundAddress = By.xpath("(//span[@class='address-item__name-text'])[1]");
    public static By aboutPointAddress = By.xpath("//span[@class='details-self__name-text']");
    public static By chooseAddressBtn = By.xpath("//button[@class='details-self__btn btn-main']");
    public static By visibleAddressOfChosenPoint = By.xpath("//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");


    public static By filterBtn = By.xpath("//span[@class='nav-element__burger-line']");
    public static By householdBtn = By.xpath("//li[@data-menu-id='16107']");
    public static By homeAppliancesBtn = By.xpath("//span[contains(text(), 'Техника для дома')]");
    public static By vacuums = By.linkText("Пылесосы и пароочистители");
    public static By filterPath = By.xpath("//ul[@class='breadcrumbs__list']");
    public static By catalogTitle = By.xpath("//h1[@class='catalog-title']");
    public static By firstVacuum = By.xpath("(//div[@class='product-card__wrapper'])[1]");
    public static By addToBasket = By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main-sm']");
    public static By counterAboveBasket = By.xpath("//span[@class='navbar-pc__notify']");
    public static By basketBtn = By.xpath("//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public static By nameOfItem = By.cssSelector(".product-card__name");
    public static By priceOfItem  = By.xpath("//ins[@class='price__lower-price']");
    public static By priceInsideBasket = By.xpath("//div[@class='list-item__price-new']");
    public static By sumPriceInBasket = By.cssSelector("p.b-top__total span[data-jsv]");
    public static By orderBtn = By.xpath("//button[@data-link='{on submitOrder ~tag}']");

    public static By electronicsBtn = By.xpath("//li[@data-menu-id='4830']");
    public static By laptopsAndPc = By.xpath("//span[contains(text(), 'Ноутбуки и компьютеры')]");
    public static By laptops = By.linkText("Ноутбуки");
    public static By allFiltres = By.xpath("//button[@class='dropdown-filter__btn dropdown-filter__btn--all']");
    public static By priceMin = By.xpath("(//input[@class='j-price'])[1]");
    public static By priceMax = By.xpath("(//input[@class='j-price'])[2]");
    public static By lessThan3DaysBtn = By.xpath("//*[contains(text(), 'до 3 дней')]");
    public static By brandApple = By.xpath("//span[contains(text(), 'Apple')]");
    public static By screen133 = By.xpath("//span[contains(text(), '13.3')]");
    public static By showItemsWithFiltres = By.xpath("//button[@class='filters-desktop__btn-main btn-main']");
    public static By listOfFiltres = By.xpath("//ul[@class='your-choice__list']");
    public static By expectedAmountOfItems = By.xpath("//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']");
    //public static By  = By.xpath("");
    //public static By  = By.xpath("");
    //public static By  = By.xpath("");
}
