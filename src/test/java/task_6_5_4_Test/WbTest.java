package task_6_5_4_Test;

import static common.Urls.WILDBERRIES_PAGE;
import static pages.task_6_5_4.AddToCartPageElements.addToBasket;
import static pages.task_6_5_4.AddToCartPageElements.basketBtn;
import static pages.task_6_5_4.AddToCartPageElements.catalogTitle;
import static pages.task_6_5_4.AddToCartPageElements.counterAboveBasket;
import static pages.task_6_5_4.AddToCartPageElements.filterBtn;
import static pages.task_6_5_4.AddToCartPageElements.filterPath;
import static pages.task_6_5_4.AddToCartPageElements.firstVacuum;
import static pages.task_6_5_4.AddToCartPageElements.homeAppliancesBtn;
import static pages.task_6_5_4.AddToCartPageElements.householdBtn;
import static pages.task_6_5_4.AddToCartPageElements.nameOfItem;
import static pages.task_6_5_4.AddToCartPageElements.orderBtn;
import static pages.task_6_5_4.AddToCartPageElements.priceInsideBasket;
import static pages.task_6_5_4.AddToCartPageElements.priceOfItem;
import static pages.task_6_5_4.AddToCartPageElements.sumPriceInBasket;
import static pages.task_6_5_4.AddToCartPageElements.vacuums;
import static pages.task_6_5_4.CityChangePageElements.aboutPointAddress;
import static pages.task_6_5_4.CityChangePageElements.addressBtn;
import static pages.task_6_5_4.CityChangePageElements.chooseAddressBtn;
import static pages.task_6_5_4.CityChangePageElements.firstFoundAddress;
import static pages.task_6_5_4.CityChangePageElements.searchBoxInAddress;
import static pages.task_6_5_4.CityChangePageElements.visibleAddressOfChosenPoint;
import static pages.task_6_5_4.FiltresPageElements.allFiltres;
import static pages.task_6_5_4.FiltresPageElements.brandApple;
import static pages.task_6_5_4.FiltresPageElements.electronicsBtn;
import static pages.task_6_5_4.FiltresPageElements.expectedAmountOfItems;
import static pages.task_6_5_4.FiltresPageElements.laptops;
import static pages.task_6_5_4.FiltresPageElements.laptopsAndPc;
import static pages.task_6_5_4.FiltresPageElements.lessThan3DaysBtn;
import static pages.task_6_5_4.FiltresPageElements.listOfFiltres;
import static pages.task_6_5_4.FiltresPageElements.priceMax;
import static pages.task_6_5_4.FiltresPageElements.priceMin;
import static pages.task_6_5_4.FiltresPageElements.screen133;
import static pages.task_6_5_4.FiltresPageElements.showItemsWithFiltres;
import static pages.task_6_5_4.FiltresPageElements.titleAfterSearch;
import static pages.task_6_5_4.SearchPageElements.brandOfFirstItem;
import static pages.task_6_5_4.SearchPageElements.crossBtn;
import static pages.task_6_5_4.SearchPageElements.filterForItems;
import static pages.task_6_5_4.SearchPageElements.foundItems;
import static pages.task_6_5_4.SearchPageElements.searchLine;
import static pages.task_6_5_4.SearchPageElements.sortBtn;
import static steps.asserts.AssertForTests.checkTextContainsOnPage;
import static steps.asserts.AssertForTests.equalityOfAmount;
import static steps.asserts.AssertForTests.getNameOfItem;
import static steps.asserts.AssertForTests.verifyElementIsClickable;
import static steps.asserts.AssertForTests.verifyPriceOnElement;
import static steps.asserts.AssertForTests.verifyRedirectToHomePage;
import static steps.asserts.AssertForTests.verifyTextOnElement;
import static steps.task_6_5_4.WbSteps.clickOn;
import static steps.task_6_5_4.WbSteps.countItemsOnPage;
import static steps.task_6_5_4.WbSteps.getTextFromElement;
import static steps.task_6_5_4.WbSteps.moveToElement;
import static steps.task_6_5_4.WbSteps.searchForItem;
import static steps.task_6_5_4.WbSteps.sendTextToInput;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class WbTest extends BaseTest {

    @BeforeEach
    public void setUp() throws InterruptedException {
        openBrowser(WILDBERRIES_PAGE);
    }

    @Test
    @DisplayName("Работа с поисковой строкой")
    @Description("Присутствует текст Iphone 13. Первый фильтр - iphone 13. Применен фильтр По популярности. У первого устройства из списка бренд - Apple.")
    public void searchForItemTest() {
        String item = "Iphone 13";

        clickOn(searchLine, driver);
        searchForItem(driver, item);

        verifyTextOnElement(item, foundItems, driver);
        verifyTextOnElement(item, filterForItems, driver);
        verifyTextOnElement("По популярности", sortBtn, driver);
        verifyTextOnElement("Apple", brandOfFirstItem, driver);

        clickOn(crossBtn, driver);

        verifyTextOnElement("", searchLine, driver);
    }

    @Test
    @DisplayName("Смена города")
    @Description("Адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов. Отображается адрес пункта выдачи.")
    public void changeCityTest() {
        clickOn(addressBtn, driver);
        sendTextToInput(searchBoxInAddress, "Санкт-Петербург" + Keys.ENTER, driver);

        String addressFromList = getTextFromElement(firstFoundAddress, driver);
        clickOn(firstFoundAddress, driver);

        verifyTextOnElement(addressFromList, aboutPointAddress, driver);

        clickOn(chooseAddressBtn, driver);

        verifyTextOnElement(addressFromList, visibleAddressOfChosenPoint, driver);
        verifyRedirectToHomePage(WILDBERRIES_PAGE, driver);
    }

    @Test
    @DisplayName("Добавление товара в избранное")
    @Description("Товар добавляется в избранное, счетчик изменяется")
    public void addItemToFavorite() {
        clickOn(filterBtn, driver);
        moveToElement(householdBtn, driver);
        clickOn(homeAppliancesBtn, driver);
        clickOn(vacuums, driver);

        verifyTextOnElement("Главная\n"
            + "Бытовая техника\n"
            + "Техника для дома\n"
            + "Пылесосы и пароочистители", filterPath, driver);
        verifyTextOnElement("Пылесосы и пароочистители", catalogTitle, driver);

        moveToElement(firstVacuum, driver);
        clickOn(addToBasket, driver);

        String nameItem = getNameOfItem(nameOfItem, driver);
        String itemPrice = getTextFromElement(priceOfItem, driver);
        verifyTextOnElement("1", counterAboveBasket, driver);

        clickOn(basketBtn, driver);

        verifyPriceOnElement(itemPrice, priceInsideBasket, driver);
        checkTextContainsOnPage(driver, nameItem);
        verifyPriceOnElement(itemPrice, sumPriceInBasket, driver);
        verifyElementIsClickable(orderBtn, driver);
    }

    @Test
    @DisplayName("Работа с фильтрами")
    @Description("Фильтр активен, фильтр отображается на странице, есть кнопка Сбросить всё")
    public void useFiltres() {
        clickOn(filterBtn, driver);
        moveToElement(electronicsBtn, driver);
        clickOn(laptopsAndPc, driver);
        clickOn(laptops, driver);
        verifyTextOnElement("Ноутбуки и ультрабуки", titleAfterSearch, driver);

        clickOn(allFiltres, driver);
        sendTextToInput(priceMin, "100000", driver);
        sendTextToInput(priceMax, "149000", driver);
        clickOn(lessThan3DaysBtn, driver);
        clickOn(brandApple, driver);
        clickOn(screen133, driver);
        clickOn(showItemsWithFiltres, driver);

        verifyTextOnElement("до 3 дней", listOfFiltres, driver);
        verifyTextOnElement("Apple", listOfFiltres, driver);
        verifyTextOnElement("13.3", listOfFiltres, driver);
        verifyTextOnElement("Сбросить все", listOfFiltres, driver);

        equalityOfAmount(getTextFromElement(expectedAmountOfItems, driver),
            countItemsOnPage(driver));
    }
}
