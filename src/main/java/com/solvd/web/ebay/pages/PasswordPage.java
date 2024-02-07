package com.solvd.web.ebay.pages;

import com.solvd.models.User;
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

    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    public PasswordPage typePass(User user) {
        passInput.type(user.getPassword());
        return this;
    }

    public PasswordPage clickSingIn() {
        singInButton.click();
        return this;
    }
}
