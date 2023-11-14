package task_6_5_4_Test;

import static common.Urls.WILDBERRIES_PAGE;
import static pages.task_6_5_4.WbPageElements.aboutPointAddress;
import static pages.task_6_5_4.WbPageElements.addToBasket;
import static pages.task_6_5_4.WbPageElements.addressBtn;
import static pages.task_6_5_4.WbPageElements.allFiltres;
import static pages.task_6_5_4.WbPageElements.basketBtn;
import static pages.task_6_5_4.WbPageElements.brandApple;
import static pages.task_6_5_4.WbPageElements.brandOfFirstItem;
import static pages.task_6_5_4.WbPageElements.catalogTitle;
import static pages.task_6_5_4.WbPageElements.chooseAddressBtn;
import static pages.task_6_5_4.WbPageElements.counterAboveBasket;
import static pages.task_6_5_4.WbPageElements.crossBtn;
import static pages.task_6_5_4.WbPageElements.electronicsBtn;
import static pages.task_6_5_4.WbPageElements.expectedAmountOfItems;
import static pages.task_6_5_4.WbPageElements.filterBtn;
import static pages.task_6_5_4.WbPageElements.filterForItems;
import static pages.task_6_5_4.WbPageElements.filterPath;
import static pages.task_6_5_4.WbPageElements.firstFoundAddress;
import static pages.task_6_5_4.WbPageElements.firstVacuum;
import static pages.task_6_5_4.WbPageElements.foundItems;
import static pages.task_6_5_4.WbPageElements.homeAppliancesBtn;
import static pages.task_6_5_4.WbPageElements.householdBtn;
import static pages.task_6_5_4.WbPageElements.laptops;
import static pages.task_6_5_4.WbPageElements.laptopsAndPc;
import static pages.task_6_5_4.WbPageElements.lessThan3DaysBtn;
import static pages.task_6_5_4.WbPageElements.listOfFiltres;
import static pages.task_6_5_4.WbPageElements.nameOfItem;
import static pages.task_6_5_4.WbPageElements.orderBtn;
import static pages.task_6_5_4.WbPageElements.priceInsideBasket;
import static pages.task_6_5_4.WbPageElements.priceMax;
import static pages.task_6_5_4.WbPageElements.priceMin;
import static pages.task_6_5_4.WbPageElements.priceOfItem;
import static pages.task_6_5_4.WbPageElements.screen133;
import static pages.task_6_5_4.WbPageElements.searchBoxInAddress;
import static pages.task_6_5_4.WbPageElements.searchLine;
import static pages.task_6_5_4.WbPageElements.showItemsWithFiltres;
import static pages.task_6_5_4.WbPageElements.sortBtn;
import static pages.task_6_5_4.WbPageElements.sumPriceInBasket;
import static pages.task_6_5_4.WbPageElements.vacuums;
import static pages.task_6_5_4.WbPageElements.visibleAddressOfChosenPoint;
import static steps.asserts.AssertForTests.checkTextContainsOnPage;
import static steps.asserts.AssertForTests.equalityOfAmount;
import static steps.asserts.AssertForTests.getNameOfItem;
import static steps.asserts.AssertForTests.verifyElementIsClickable;
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
    public void searchForItemTest() throws InterruptedException {
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
    public void changeCityTest() throws InterruptedException {
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
    public void addItemToFavorite() throws InterruptedException {
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

        verifyTextOnElement(itemPrice, priceInsideBasket, driver);
        checkTextContainsOnPage(driver, nameItem);
        verifyTextOnElement(itemPrice, sumPriceInBasket, driver);
        verifyElementIsClickable(orderBtn, driver);
    }

    @Test
    @DisplayName("Работа с фильтрами")
    @Description("Фильтр активен, фильтр отображается на странице, есть кнопка Сбросить всё")
    public void useFiltres() throws InterruptedException {
        clickOn(filterBtn, driver);
        moveToElement(electronicsBtn, driver);
        clickOn(laptopsAndPc, driver);
        clickOn(laptops, driver);

        checkTextContainsOnPage(driver, "Ноутбуки и ультрабуки");

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
