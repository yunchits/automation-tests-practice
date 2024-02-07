package com.solvd.web.ebay.pages;

import com.solvd.web.ebay.pages.components.ItemCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']//span[text()][1]")
    private ExtendedWebElement resultCountHeading;

    @FindBy(xpath = "//div[@id='srp-river-main']//li[not(@style)]//div[@class='s-item__wrapper clearfix']")
    private List<ItemCard> cards;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public int getResultCount() {
        String text = resultCountHeading.getText();
        String numericValue = text.replaceAll("\\D", "");
        return Integer.parseInt(numericValue);
    }
}
