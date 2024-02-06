package com.solvd.services;

import com.solvd.LoginInput;
import com.solvd.model.User;
import com.solvd.page.LoginPage;
import com.solvd.page.InventoryPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    public User createUser(LoginInput input) {
        return new User()
            .setUsername(input.getUsername())
            .setPassword(input.getPassword());
    }

    public InventoryPage login(User user, WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(user);
        loginPage.typePassword(user);
        loginPage.clickLoginButton();
        return new InventoryPage(driver);
    }
}
