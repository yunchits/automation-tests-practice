package com.solvd.web.ebay.pages;

import com.solvd.web.ebay.pages.components.ItemCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Getter
public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']//span[text()][1]")
    private ExtendedWebElement resultCountHeading;

    @FindBy(xpath = "//li[contains(@id, 'item')]")
    private List<ItemCard> cards;

    @FindBy(id = "gh-minicart-hover")
    private ExtendedWebElement cart;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public int getResultCount() {
        String text = resultCountHeading.getText();
        String numericValue = text.replaceAll("\\D", "");
        return Integer.parseInt(numericValue);
    }

    public ItemCard getCardByIndex(int index) {
        waitUntil(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//li[contains(@id, 'item')]"), 0), 5);
        return cards.get(index); //TODO
    }

    public CartPage openCart() { //abstract page
        cart.click();
        return new CartPage(getDriver());
    }
}
