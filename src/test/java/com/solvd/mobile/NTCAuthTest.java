package com.solvd.mobile;

import com.solvd.mobile.base.NTCBaseTest;
import com.solvd.mobile.modals.LogOutConfirmationModal;
import com.solvd.mobile.models.UserData;
import com.solvd.mobile.pages.ReturnToAccountPage;
import com.solvd.mobile.pages.common.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NTCAuthTest extends NTCBaseTest {

    @Test(description = "Verify successful log out")
    public void testLogOut() {
        AuthPageBase authPage = logOut();

        Assert.assertTrue(authPage.isAuthTitlePresent(), "Incorrect log out");
    }

    @Test()
    public void testReturnToAccount() {
        logOut();
        ReturnToAccountPageBase returnToAccountPageBase = initPage(getDriver(), ReturnToAccountPage.class);
        HomePageBase homePage = returnToAccountPageBase.clickContinueButton();
        Assert.assertTrue(homePage.isTitlePresent(),
            "Authorization failed. You were not directed to the home page");
    }

    @Test()
    public void testSingIn() {
        AuthPageBase authPage = logOut();
        authPage.clickSingInButton();
        SignInRecoveryPageBase signInRecoveryPage = initPage(getDriver(), SignInRecoveryPageBase.class);
        if (signInRecoveryPage.isPresent()) {
            signInRecoveryPage.clickUseAnotherAccount();
        }

        SignInPageBase signInPage = initPage(getDriver(), SignInPageBase.class); //todo
        signInPage.typeEmail(UserData.VALID.getEmail());
        PassPageBase passPage = signInPage.clickContinue();
        passPage.typePass(UserData.VALID.getPass());
        SignedPageBase signedPage = passPage.clickSingIn();

        Assert.assertTrue(signedPage.isPresent(), "Authorization failed");
    }

    private AuthPageBase logOut() {
        HomePageBase homePage = performDefaultSteps();
        SideMenuPageBase sideMenuPage = homePage.clickOpenSideMenuButton();
        SettingsPageBase settingsPage = sideMenuPage.clickSettingsButton();
        LogOutConfirmationModal logOutConfirmationModal = settingsPage.clickLogOut();
        return logOutConfirmationModal.clickConfirmLogOut();
    }
}
