package com.solvd.web.ebay.pages.base;

import com.solvd.web.ebay.pages.auth.LoginPage;
import com.solvd.web.ebay.pages.auth.SingOutPage;
import com.solvd.web.ebay.pages.base.components.Language;
import com.solvd.web.ebay.pages.base.components.Navigation;
import com.solvd.web.ebay.pages.main.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends AbstractPage {

    @FindBy(xpath = "//div[@id='gh-top']")
    private Navigation navigation;

    @FindBy(id = "gh-minicart-hover")
    private ExtendedWebElement cart;

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    public CartPage openCart() {
        cart.click();
        return new CartPage(getDriver());
    }

    public LoginPage clickSignIn() {
        navigation.clickSignIn();
        return new LoginPage(getDriver());
    }

    public SingOutPage clickSignOut() {
        navigation.signOut();
        return new SingOutPage(getDriver());
    }

    public boolean isUserSignIn(int timeout) {
        return navigation.isSignInGreetingPresent(timeout);
    }

    public boolean isSignInButtonPresent(int timeout) {
        return navigation.isSignInButtonPresent(timeout);
    }

    public Language getLanguageSetter() {
        return navigation.getLanguageSetter();
    }
}
