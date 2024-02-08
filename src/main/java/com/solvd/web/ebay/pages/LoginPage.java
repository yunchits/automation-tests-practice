package com.solvd.web.ebay.pages;

import com.solvd.models.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='userid']")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//p[@id='signin-error-msg']")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeUsername(String username) {
        usernameInput.type(username);
        return this;
    }

    public PasswordPage clickContinue() {
        continueButton.click();
        return new PasswordPage(getDriver());
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
