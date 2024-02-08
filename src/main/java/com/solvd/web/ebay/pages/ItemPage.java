package com.solvd.web.ebay.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='x-item-title__mainTitle']//span[text()]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@data-testid='x-price-primary']//span[text()]")
    private ExtendedWebElement price;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return title.getText();
    }

    public CartPage addItemToCard() {
        addToCartButton.click();
        return new CartPage(getDriver());
    }

    public double getPriceAmount() {
        return Double.parseDouble(price.getText().replaceAll("[^\\d.]", ""));
    }
}
