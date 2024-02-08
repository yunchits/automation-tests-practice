package com.solvd.web.ebay.pages.main;

import com.solvd.web.ebay.pages.main.components.SearchLine;
import com.zebrunner.carina.utils.config.Configuration;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends BasePage {

    @FindBy(id = "gh-f")
    private SearchLine searchLine;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

}
