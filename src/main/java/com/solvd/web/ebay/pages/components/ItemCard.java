package com.solvd.web.ebay.pages.components;

import com.solvd.web.ebay.pages.ItemPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemCard extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='s-item__title']//span[@role='heading']")
    private ExtendedWebElement title;

    public ItemCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitleText() {
        return title.getText();
    }

    public ItemPage click() {
        title.click();
        return new ItemPage(getDriver());
    }
}
