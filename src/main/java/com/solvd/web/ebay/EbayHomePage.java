package com.solvd.web.ebay;

import com.solvd.web.ebay.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class EbayHomePage extends AbstractPage {

    @FindBy(xpath = "//header[@id='gh']")
    private Header header;

    public EbayHomePage(WebDriver driver) {
        super(driver);
//        setPageURL("/"); //if in config just "url"
//        setPageAbsoluteURL(Configuration.getRequired("home_url"));
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }
}
