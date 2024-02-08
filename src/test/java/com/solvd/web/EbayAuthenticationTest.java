package com.solvd.web;

import com.solvd.models.Users;
import com.solvd.servicies.LanguageService;
import com.solvd.servicies.SignInService;
import com.solvd.web.ebay.pages.HomePage;
import com.solvd.web.ebay.pages.LoginPage;
import com.solvd.web.ebay.pages.PasswordPage;
import com.solvd.web.ebay.pages.SingOutPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayAuthenticationTest implements IAbstractTest {

    @Test(description = "Verify valid login")
    public void testValidLogin() {
        HomePage page = openHomePage();

        SignInService signInService = new SignInService();

        Assert.assertTrue(page.getSignInButton().isElementPresent());
        LoginPage loginPage = page.clickSignIn();

        Assert.assertTrue(loginPage.getUsernameInput().isElementPresent());
        Assert.assertTrue(loginPage.getContinueButton().isElementPresent());
        PasswordPage passwordPage = signInService.setLogin(loginPage, Users.VALID);

        Assert.assertTrue(passwordPage.getPassInput().isElementPresent());
        Assert.assertTrue(passwordPage.getSingInButton().isElementPresent());
        signInService.setPassword(passwordPage, Users.VALID);
    }

    @Test(description = "Check the invalid login exception")
    public void testInvalidLogin() {
        HomePage page = openHomePage();

        SignInService signInService = new SignInService();

        Assert.assertTrue(page.getSignInButton().isElementPresent());
        LoginPage loginPage = page.clickSignIn();

        Assert.assertTrue(loginPage.getUsernameInput().isElementPresent());
        Assert.assertTrue(loginPage.getContinueButton().isElementPresent());
        signInService.setLogin(loginPage, Users.INVALID);

        Assert.assertTrue(loginPage.getErrorMessage().isElementPresent());
        Assert.assertEquals(loginPage.getErrorMessageText(), "We couldn't find this eBay account.");
    }

    @Test(description = "Check the invalid password exception")
    public void testInvalidPass() {
        HomePage page = openHomePage();
        SignInService signInService = new SignInService();

        Assert.assertTrue(page.getSignInButton().isElementPresent());
        LoginPage loginPage = page.clickSignIn();

        Assert.assertTrue(loginPage.getUsernameInput().isElementPresent());
        Assert.assertTrue(loginPage.getContinueButton().isElementPresent());
        PasswordPage passwordPage = signInService.setLogin(loginPage, Users.VALID);

        Assert.assertTrue(passwordPage.getPassInput().isElementPresent());
        Assert.assertTrue(passwordPage.getSingInButton().isElementPresent());
        signInService.setPassword(passwordPage, Users.INVALID);

        Assert.assertTrue(passwordPage.getErrorMessage().isElementPresent());
    }

    @Test(description = "Verify successful sign out")
    public void testSingOut() {
        HomePage page = openHomePage();

        SignInService signInService = new SignInService();

        Assert.assertTrue(page.getSignInButton().isElementPresent());
        LoginPage loginPage = page.clickSignIn();

        Assert.assertTrue(loginPage.getUsernameInput().isElementPresent());
        Assert.assertTrue(loginPage.getContinueButton().isElementPresent());
        PasswordPage passwordPage = signInService.setLogin(loginPage, Users.VALID);

        Assert.assertTrue(passwordPage.getPassInput().isElementPresent());
        Assert.assertTrue(passwordPage.getSingInButton().isElementPresent());
        signInService.setPassword(passwordPage, Users.VALID);

        SingOutPage singOutPage = page.clickSignOut();
        Assert.assertTrue(singOutPage.getSignOutBanner().isElementPresent());
    }


    private HomePage openHomePage() {
        HomePage page = new HomePage(getDriver());
        page.open();
        new LanguageService().setEnglishLanguage(page);
        return page;
    }
}
