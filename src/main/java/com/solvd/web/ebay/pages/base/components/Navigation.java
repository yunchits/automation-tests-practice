package com.solvd.web.ebay.pages.base.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Navigation extends AbstractUIObject {

    @FindBy(id = "gh-ug")
    private ExtendedWebElement accountButton;

    @FindBy(xpath = ".//a[text()='Sign in']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = ".//li[@id='gh-uo']//a[text()]")
    private ExtendedWebElement signOutButton;

    @FindBy(xpath = ".//li[@id='gh-eb-Geo']")
    private Language languageSetter;

    @FindBy(xpath = ".//button[@id='gh-ug']//b[text()]")
    private ExtendedWebElement signInGreeting;

    public Navigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void signOut() {
        accountButton.click();
        signOutButton.click();
    }

    public boolean isSignInGreetingPresent(int timeout) {
        return signInGreeting.isElementPresent(timeout);
    }

    public boolean isSignInButtonPresent(int timeout) {
        return signInGreeting.isElementPresent(timeout);
    }

    public Language getLanguageSetter() {
        return languageSetter;
    }
}
