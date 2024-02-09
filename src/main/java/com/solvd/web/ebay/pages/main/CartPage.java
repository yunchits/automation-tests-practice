package com.solvd.web.ebay.pages.main;

import com.solvd.web.ebay.pages.base.BasePage;
import com.solvd.web.ebay.pages.main.components.ItemCartSummary;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@data-test-id='SUBTOTAL']//*[text()]")
    private ExtendedWebElement subtotal;

    @FindBy(xpath = "//div[@data-test-id='SHIPPING']//*[text()]")
    private ExtendedWebElement shipping;

    @FindBy(xpath = "//div[@data-test-id='list-summary']")
    private List<ItemCartSummary> itemSummaries;

    @FindBy(xpath = "//span[text()=\"You don't have any items in your cart.\"]")
    private ExtendedWebElement emptyCartText;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public double getSubtotalAmount() {
        return Double.parseDouble(subtotal.getText().replaceAll("[^\\d.]", ""));
    }

    public double getShippingAmount() {
        return Double.parseDouble(shipping.getText().replaceAll("[^\\d.]", ""));
    }
}
