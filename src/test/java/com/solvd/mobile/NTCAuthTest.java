package com.solvd.mobile;

import com.solvd.mobile.base.NTCBaseTest;
import com.solvd.mobile.models.TimeoutConstants;
import com.solvd.mobile.models.UserData;
import com.solvd.mobile.pages.common.*;
import com.solvd.mobile.services.AuthService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NTCAuthTest extends NTCBaseTest {

    private final AuthService authService = new AuthService();

    @Test(description = "Verify successful log out")
    public void testLogOut() {
        HomePageBase homePage = performDefaultSteps();
        AuthPageBase authPage = authService.logOut(homePage);

        Assert.assertTrue(authPage.isAuthTitlePresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS), "Incorrect log out");
    }

    //NOT OPTIMIZED TEST
//    @Test(description = "Verify successful return after log out")
//    public void testReturnToAccount() {
//        HomePageBase homePage = performDefaultSteps();
//        AuthPageBase authPage = authService.logOut(homePage);
//        authPage.clickSingInButton();
//
//        ReturnToAccountPageBase returnToAccountPageBase = initPage(getDriver(), ReturnToAccountPageBase.class);
//        returnToAccountPageBase.clickContinueButton();
//        Assert.assertTrue(homePage.isTitlePresent(),
//            "Authorization failed. You were not directed to the home page");
//    }

    @Test(description = "Verify successful return after log out")
    public void testReturnToAccount() {
        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
        authPage.clickSingInButton();

        SignInPageBase signInPage = authPage.clickSingInButton();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        if (signInPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS)) {
            authService.login(signInPage, UserData.VALID);
            authService.logOut(homePage);
        } else if (homePage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS)) {
            authService.logOut(homePage);
        }

        authService.logOut(homePage);
        authPage.clickSingInButton();

        ReturnToAccountPageBase returnToAccountPageBase = initPage(getDriver(), ReturnToAccountPageBase.class);
        returnToAccountPageBase.clickContinueButton();
        Assert.assertTrue(homePage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS),
            "Authorization failed. You were not directed to the home page");
    }

    //NOT OPTIMIZED TEST
//    @Test(description = "Verify successful authorization with the valid user data")
//    public void testSingIn() {
//        HomePageBase homePage = performDefaultSteps();
//        authService.logOut(homePage);
//        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
//        SignInPageBase signInPage = authPage.clickSingInButton();
//        SignInRecoveryPageBase signInRecoveryPage = initPage(getDriver(), SignInRecoveryPageBase.class);
//
//        if (signInRecoveryPage.isPresent()) {
//            signInRecoveryPage.clickUseAnotherAccount();
//        }
//
//        Assert.assertTrue(signInPage.isPresent(), "Sign in page is not available");
//        signInPage.typeEmail(UserData.VALID.getEmail());
//        PassPageBase passPage = signInPage.clickContinue();
//        Assert.assertTrue(passPage.isPresent(), "Password entry page is not available");
//        passPage.typePass(UserData.VALID.getPass());
//        SignedPageBase signedPage = passPage.clickSingIn();
//
//        Assert.assertTrue(signedPage.isPresent(), "Authorization failed");
//    }

    @Test(description = "Verify successful authorization with the valid user data")
    public void testSignIn() {
        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
        SignInPageBase signInPage = authPage.clickSingInButton();
        SignInRecoveryPageBase signInRecoveryPage = initPage(getDriver(), SignInRecoveryPageBase.class);
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        if (signInRecoveryPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS)) {
            signInRecoveryPage.clickUseAnotherAccount();
        } else if (!signInPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS)) {
            closeModals(homePage);
            authService.logOut(homePage);
            authPage.clickSingInButton();
        }

        Assert.assertTrue(signInPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS), "Sign in page is not available");
        signInPage.typeEmail(UserData.VALID.getEmail());
        PassPageBase passPage = signInPage.clickContinue();
        Assert.assertTrue(passPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS), "Password entry page is not available");
        passPage.typePass(UserData.VALID.getPass());
        SignedPageBase signedPage = passPage.clickSignIn();

        Assert.assertTrue(signedPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS), "Authorization failed");
    }

    @Test()
    public void testSignInWithInvalidEmail() {

    }

    @Test()
    public void testSignInWithInvalidPass() {

    }
}
