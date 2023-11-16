package pages.task_6_5_4;

import org.openqa.selenium.By;

public class SearchPageElements {

    public static By searchLine = By.xpath("//input[@id='searchInput']");
    public static By foundItems = By.xpath("//h1[@class='searching-results__title']");
    public static By filterForItems = By.cssSelector(".dropdown-filter__btn--burger");
    public static By sortBtn = By.cssSelector(".dropdown-filter__btn--sorter");
    public static By brandOfFirstItem = By.xpath("(//span[@class='product-card__brand'])[1]");
    public static By crossBtn = By.xpath(
        "//button[@class='search-catalog__btn search-catalog__btn--clear search-catalog__btn--active']");
}
