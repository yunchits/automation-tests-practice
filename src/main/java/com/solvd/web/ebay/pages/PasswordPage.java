package com.solvd.web.ebay.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class PasswordPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='pass']")
    private ExtendedWebElement passInput;

    @FindBy(xpath = "//button[@id='sgnBt']")
    private ExtendedWebElement singInButton;

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
        singInButton.click();
        return new HomePage(getDriver());
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
