package com.solvd.web.ebay.pages.main.components;

import com.solvd.web.ebay.pages.main.ItemPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemSearchCard extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='s-item__title']//span[@role='heading']")
    private ExtendedWebElement itemTitle;

    public ItemSearchCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitleText() {
        return itemTitle.getText();
    }

    public ItemPage click() {
        itemTitle.click();
        return new ItemPage(getDriver());
    }

    public boolean isItemTitlePresent(int timeout){
        return itemTitle.isElementPresent(timeout);
    }
}
