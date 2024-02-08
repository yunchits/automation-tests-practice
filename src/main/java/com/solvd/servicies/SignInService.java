package com.solvd.servicies;

import com.solvd.models.User;
import com.solvd.models.Users;
import com.solvd.web.ebay.pages.HomePage;
import com.solvd.web.ebay.pages.LoginPage;
import com.solvd.web.ebay.pages.PasswordPage;

public class SignInService {

    public User createUser(Users user) { //todo
        return new User(user.getUsername(), user.getPass());
    }

    public PasswordPage setLogin(LoginPage page, Users user) {
        LoginPage loginPage = page.typeUsername(user.getUsername());
        return loginPage.clickContinue();
    }

    public HomePage setPassword(PasswordPage page, Users user) {
        page.typePass(user.getPass());
        return page.clickSingInButton();
    }

}
