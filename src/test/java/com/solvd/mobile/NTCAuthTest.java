package com.solvd.mobile;

import com.solvd.mobile.models.TimeoutConstants;
import com.solvd.mobile.models.UserData;
import com.solvd.mobile.pages.common.*;
import com.solvd.mobile.services.AuthService;
import com.solvd.mobile.services.BaseActionsService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class NTCAuthTest implements IAbstractTest, IMobileUtils {

    private final BaseActionsService actionsService = new BaseActionsService();
    private final AuthService authService = new AuthService();

    @Test(description = "Verify successful log out")
    public void testLogOut() {
        HomePageBase homePage = actionsService.performDefaultSteps();
        AuthPageBase authPage = authService.logOut(homePage);

        Assert.assertTrue(authPage.isAuthTitlePresent(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Incorrect log out");
    }

    @Test(description = "Verify successful return after log out")
    public void testReturnToAccount() {
        HomePageBase homePage = actionsService
            .openReturnToAccountPage()
            .clickContinue();

        Assert.assertTrue(homePage.isOpened(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Authorization failed. You were not directed to the home page");
    }

    @Test(description = "Verify successful authorization with the valid user data")
    public void testSignIn() {
        SignInPageBase signInPage = actionsService.openSignInPage();
        Assert.assertTrue(signInPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS),
            "Sign in page is not available");

        signInPage.typeEmail(UserData.VALID.getEmail());
        PassPageBase passPage = signInPage.clickContinue();
        Assert.assertTrue(passPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS),
            "Password entry page is not available");

        passPage.typePass(UserData.VALID.getPass());
        SignedPageBase signedPage = passPage.clickSignIn();

        Assert.assertTrue(signedPage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Authorization failed");
    }

    @Test(description = "Verify unsuccessful sign in with invalid email")
    public void testSignInWithInvalidEmail() {
        SignInPageBase signInPage = actionsService.openSignInPage();

        signInPage
            .typeEmail(UserData.INVALID.getEmail())
            .clickContinue();

        Assert.assertTrue(signInPage.isInvalidEmailMessagePresent(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Invalid mail message is not present");
    }

    @Test(description = "Verify unsuccessful sign in with invalid password")
    public void testSignInWithInvalidPass() {
        SignInPageBase signInPage = actionsService.openSignInPage();

        PassPageBase passPage = signInPage
            .typeEmail(UserData.VALID.getEmail())
            .clickContinue();

        passPage
            .typePass(UserData.INVALID.getPass())
            .clickSignIn();

        Assert.assertTrue(passPage.isInvalidCredentialsMessagePresent(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Invalid credentials message is not present");
    }

    @Test(description = "Verify that when trying to sign in with an unregistered email returns the registration page")
    public void testSingInWithNewEmail() {
        SignInPageBase signInPage = actionsService.openSignInPage();

        signInPage
            .typeEmail(UserData.NEW.getEmail())
            .clickContinue();

        SignUpPageBase signUpPage = initPage(getDriver(), SignUpPageBase.class);
        Assert.assertTrue(signUpPage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Sing up page is not present");
    }
}
