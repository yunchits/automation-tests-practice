package com.solvd.page;

import com.solvd.model.User;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='user-name']")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public LoginPage typeUsername(User user) {
        usernameInput.type(user.getUsername());
        return this;
    }

    public LoginPage typePassword(User user) {
        passwordInput.type(user.getPassword());
        return this;
    }

    public InventoryPage clickLoginButton() {
        loginButton.click();
        return new InventoryPage(getDriver());
    }

    public boolean isUsernameElementPresent() {
        return usernameInput.isElementPresent();
    }

    public boolean isPasswordElementPresent() {
        return passwordInput.isElementPresent();
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("login_url"));
    }
}
