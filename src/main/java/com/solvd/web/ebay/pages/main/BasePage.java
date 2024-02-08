package com.solvd.web.ebay.pages.main;

import com.solvd.web.ebay.pages.auth.LoginPage;
import com.solvd.web.ebay.pages.auth.SingOutPage;
import com.solvd.web.ebay.pages.main.components.Navigation;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
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
        navigation.getSignInButton().click();
        return new LoginPage(getDriver());
    }

    public SingOutPage clickSignOut() {
        navigation.getAccountButton().click();
        navigation.getSignOutButton().click();
        return new SingOutPage(getDriver());
    }

    public boolean isUserSignIn() {
        return navigation.getSignInGreeting().isElementPresent();
    }
}
