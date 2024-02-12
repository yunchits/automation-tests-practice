package com.solvd.mobile;

import com.solvd.mobile.base.NTCBaseTest;
import com.solvd.mobile.models.TimeoutConstants;
import com.solvd.mobile.models.UserData;
import com.solvd.mobile.pages.common.*;
import com.solvd.mobile.services.AuthService;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class NTCAuthTest extends NTCBaseTest {

    private final AuthService authService = new AuthService();

    @Test(description = "Verify successful log out")
    public void testLogOut() {
        HomePageBase homePage = performDefaultSteps();
        AuthPageBase authPage = authService.logOut(homePage);

        Assert.assertTrue(authPage.isAuthTitlePresent(TimeoutConstants.LONG_TIMEOUT_SECONDS), "Incorrect log out");
    }

    @Test(description = "Verify successful return after log out")
    public void testReturnToAccount() {
        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
        SignInPageBase signInPage = authPage.clickSignInButton();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        if (signInPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS)) {
            authService.login(signInPage, UserData.VALID);
            authService.logOut(homePage);
        } else if (homePage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS)) {
            authService.logOut(homePage);
        }

        authService.logOut(homePage);
        authPage.clickSignInButton();

        ReturnToAccountPageBase returnToAccountPageBase = initPage(getDriver(), ReturnToAccountPageBase.class);
        returnToAccountPageBase.clickContinueButton();
        Assert.assertTrue(homePage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Authorization failed. You were not directed to the home page");
    }

    @Test(description = "Verify successful authorization with the valid user data")
    public void testSignIn() {
        SignInPageBase signInPage = openSignInPage();

        Assert.assertTrue(signInPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS), "Sign in page is not available");
        signInPage.typeEmail(UserData.VALID.getEmail());
        PassPageBase passPage = signInPage.clickContinue();
        Assert.assertTrue(passPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS), "Password entry page is not available");
        passPage.typePass(UserData.VALID.getPass());
        SignedPageBase signedPage = passPage.clickSignIn();

        Assert.assertTrue(signedPage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS), "Authorization failed");
    }

    @Test(description = "Verify unsuccessful sign in with invalid email")
    public void testSignInWithInvalidEmail() {
        SignInPageBase signInPage = openSignInPage();

        signInPage.typeEmail(UserData.INVALID.getEmail());
        signInPage.clickContinue();

        Assert.assertTrue(signInPage.isInvalidEmailMessagePresent(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Invalid mail message is not present");
    }

    @Test(description = "Verify unsuccessful sign in with invalid password")
    public void testSignInWithInvalidPass() {
        SignInPageBase signInPage = openSignInPage();

        PassPageBase passPage = signInPage
            .typeEmail(UserData.VALID.getEmail())
            .clickContinue();

        passPage
            .typePass(UserData.INVALID.getPass())
            .clickSignIn();

        Assert.assertTrue(passPage.isInvalidCredentialsMessagePresent(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Invalid credentials message is not present");
    }

    private SignInPageBase openSignInPage() {
        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
        SignInPageBase signInPage = authPage.clickSignInButton();
        SignInRecoveryPageBase signInRecoveryPage = initPage(getDriver(), SignInRecoveryPageBase.class);
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        if (signInRecoveryPage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS)) {
            signInRecoveryPage.clickUseAnotherAccount();
        } else if (!signInPage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS)) {
            closeModals(homePage);
            authService.logOut(homePage);
            authPage.clickSignInButton();
        }
        return signInPage;
    }
}
