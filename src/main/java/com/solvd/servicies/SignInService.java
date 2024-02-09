package com.solvd.servicies;

import com.solvd.models.UserData;
import com.solvd.web.ebay.pages.auth.LoginPage;
import com.solvd.web.ebay.pages.auth.PasswordPage;
import com.solvd.web.ebay.pages.main.HomePage;

public class SignInService {

    public PasswordPage setLogin(LoginPage page, UserData user) {
        LoginPage loginPage = page.typeUsername(user.getUsername());
        return loginPage.clickContinue();
    }

    public HomePage setPassword(PasswordPage page, UserData user) {
        page.typePass(user.getPass());
        return page.clickSingInButton();
    }
}
