package com.solvd.web.ebay.pages.main;

import com.solvd.constants.TimeConstant;
import com.solvd.web.ebay.pages.main.components.ItemSearchCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Getter
public class SearchPage extends BasePage {

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']//span[text()][1]")
    private ExtendedWebElement resultCountHeading;

    @FindBy(xpath = "//li[contains(@id, 'item') and not(@style)]")
    private List<ItemSearchCard> cards;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ItemSearchCard getCardByIndex(int index) {
        waitUntil(ExpectedConditions.numberOfElementsToBeMoreThan(
            By.xpath("//li[contains(@id, 'item')]"), 0), TimeConstant.SHORT_TIMEOUT);
        return cards.get(index);
    }
}
