package com.solvd.web.ebay.pages.auth;

import com.solvd.web.ebay.pages.main.HomePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='pass']")
    private ExtendedWebElement passInput;

    @FindBy(xpath = "//button[@id='sgnBt']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//p[@id='errormsg']")
    private ExtendedWebElement errorMessage;

    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    public PasswordPage typePass(String pass) {
        passInput.type(pass);
        return this;
    }

    public HomePage clickSingInButton() {
        signInButton.click();
        return new HomePage(getDriver());
    }

    public boolean isPassInputPresent(int timeout) {
        return passInput.isElementPresent(timeout);
    }

    public boolean isSignInButtonPresent(int timeout) {
        return signInButton.isElementPresent(timeout);
    }

    public boolean isErrorMessagePresent(int timeout) {
        return errorMessage.isElementPresent(timeout);
    }
}
