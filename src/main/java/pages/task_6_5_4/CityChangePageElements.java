package pages.task_6_5_4;

import org.openqa.selenium.By;

public class CityChangePageElements {

    public static By addressBtn = By.xpath("//span[@data-wba-header-name='DLV_Adress']");
    public static By searchBoxInAddress = By.xpath(
        "//input[@class='ymaps-2-1-79-searchbox-input__input']");
    public static By firstFoundAddress = By.xpath("(//span[@class='address-item__name-text'])[1]");
    public static By aboutPointAddress = By.xpath("//span[@class='details-self__name-text']");
    public static By chooseAddressBtn = By.xpath("//button[@class='details-self__btn btn-main']");
    public static By visibleAddressOfChosenPoint = By.xpath(
        "//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");
}
