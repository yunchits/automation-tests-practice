package com.solvd.web.ebay.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//div[@data-test-id='SUBTOTAL']//*[text()]")
    private ExtendedWebElement subtotal;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public double getSubtotalAmount() {
        return Double.parseDouble(subtotal.getText().replaceAll("[^\\d.]", ""));
    }
}
