package com.solvd.web;

import com.solvd.models.User;
import com.solvd.servicies.LanguageService;
import com.solvd.web.ebay.pages.HomePage;
import com.solvd.web.ebay.pages.LoginPage;
import com.solvd.web.ebay.pages.PasswordPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayLoginTest implements IAbstractTest {

    @Test
    public void testValidLogin() {
        HomePage page = new HomePage(getDriver());
        page.open();

        new LanguageService().setEnglishLanguage(page);

        User user = new User("0", "0");

        Assert.assertTrue(page.getSingIn().isElementPresent());
        LoginPage loginPage = page.clickSingIn();

        Assert.assertTrue(loginPage.getUsernameInput().isElementPresent());
        Assert.assertTrue(loginPage.getContinueButton().isElementPresent());
        loginPage.typeUsername(user);

        PasswordPage passwordPage = loginPage.clickContinue();
        Assert.assertTrue(passwordPage.getPassInput().isElementPresent());
        Assert.assertTrue(passwordPage.getSingInButton().isElementPresent());
        passwordPage.typePass(user);
        passwordPage.clickSingIn();
    }

    @Test
    public void testInvalidLogin() {
        HomePage page = new HomePage(getDriver());
        page.open();

        new LanguageService().setEnglishLanguage(page);
        page.clickSingIn();
    }

}
