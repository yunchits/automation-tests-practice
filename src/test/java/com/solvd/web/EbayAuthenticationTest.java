package com.solvd.web;

import com.solvd.constants.TimeConstant;
import com.solvd.models.Languages;
import com.solvd.models.UserData;
import com.solvd.servicies.LanguageService;
import com.solvd.servicies.SignInService;
import com.solvd.web.ebay.pages.auth.LoginPage;
import com.solvd.web.ebay.pages.auth.PasswordPage;
import com.solvd.web.ebay.pages.auth.SingOutPage;
import com.solvd.web.ebay.pages.base.components.Navigation;
import com.solvd.web.ebay.pages.main.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayAuthenticationTest implements IAbstractTest {

    @Test(description = "Verify valid login")
    public void testValidLogin() {
        HomePage homePage = openHomePageInEnglish();
        Navigation navigation = homePage.getNavigation();

        SignInService signInService = new SignInService();

        Assert.assertTrue(navigation.getSignInButton().isElementPresent(TimeConstant.SHORT_TIMEOUT),
                "Sign in button is not present");
        LoginPage loginPage = homePage.clickSignIn();

        Assert.assertTrue(loginPage.getUsernameInput().isElementPresent(TimeConstant.SHORT_TIMEOUT),
                "Username input is not present");
        Assert.assertTrue(loginPage.getContinueButton().isElementPresent(TimeConstant.SHORT_TIMEOUT),
                "Continue button is not present");
        PasswordPage passwordPage = signInService.setLogin(loginPage, UserData.VALID);

        Assert.assertTrue(passwordPage.getPassInput().isElementPresent(TimeConstant.SHORT_TIMEOUT),
                "Pass input is not present");
        Assert.assertTrue(passwordPage.getSignInButton().isElementPresent(TimeConstant.SHORT_TIMEOUT),
                "Sign in button is not present");

        signInService.setPassword(passwordPage, UserData.VALID);

        Assert.assertTrue(homePage.isUserSignIn(), "User is not sign in");
    }

    @Test(description = "Check the invalid login exception")
    public void testInvalidLogin() {
        HomePage homePage = openHomePageInEnglish();
        LoginPage loginPage = homePage.clickSignIn();

        new SignInService().setLogin(loginPage, UserData.INVALID);

        Assert.assertTrue(loginPage.getErrorMessage().isElementPresent(TimeConstant.SHORT_TIMEOUT),
                "Error message is not present");
        Assert.assertEquals(loginPage.getErrorMessageText(), "We couldn't find this eBay account.");
    }

    @Test(description = "Check the invalid password exception")
    public void testInvalidPass() {
        HomePage homePage = openHomePageInEnglish();
        LoginPage loginPage = homePage.clickSignIn();

        SignInService signInService = new SignInService();
        PasswordPage passwordPage = signInService.setLogin(loginPage, UserData.VALID);
        signInService.setPassword(passwordPage, UserData.INVALID);

        Assert.assertTrue(passwordPage.getErrorMessage().isElementPresent(TimeConstant.SHORT_TIMEOUT),
                "Error message is not present");
    }

    @Test(description = "Verify successful sign out")
    public void testSingOut() {
        HomePage homePage = openHomePageInEnglish();
        LoginPage loginPage = homePage.clickSignIn();

        SignInService signInService = new SignInService();
        PasswordPage passwordPage = signInService.setLogin(loginPage, UserData.VALID);
        signInService.setPassword(passwordPage, UserData.VALID);

        SingOutPage singOutPage = homePage.clickSignOut();
        Assert.assertTrue(singOutPage.getSignOutBanner().isElementPresent(TimeConstant.SHORT_TIMEOUT),
                "Sign out banner is not present");
    }

    private HomePage openHomePageInEnglish() {
        HomePage page = new HomePage(getDriver());
        page.open();
        new LanguageService().setLanguage(page, Languages.ENGLISH);
        return page;
    }
}
