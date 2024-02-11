package com.solvd.mobile;

import com.solvd.mobile.pages.HomePage;
import com.solvd.mobile.pages.ReturnToAccountPage;
import com.solvd.mobile.pages.common.AuthPageBase;
import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.common.ReturnToAccountPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NTCAuthTest implements IAbstractTest, IMobileUtils {

    @Test()
    public void testLogOut() {

    }

    @Test()
    public void testReturnToAccount() {
        ReturnToAccountPageBase returnToAccountPageBase = initPage(getDriver(), ReturnToAccountPage.class);
        HomePage homePage = returnToAccountPageBase.clickContinueButton();
        Assert.assertTrue(homePage.getHomeTitle().isElementPresent(),
            "Authorization failed. You were not directed to the home page");
    }

    @Test()
    public void testSingIn() {
        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
        authPage.clickSingInButton();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.clickAllowNotifications();
        homePage.closeFeedbackModal();
//        NotificationModalBase notificationModal = initPage(getDriver(), NotificationModal.class);
//        notificationModal.clickAllowNotifications();
//        SignInPageBase signInPage = initPage(getDriver(), SignInPageBase.class);
//        signInPage.typeEmail(UserData.INVALID.getEmail());
//        PassPage passPage = signInPage.clickContinue();
//        passPage.typePass(UserData.INVALID.getPass());
//        HomePage homePage = passPage.clickSingIn();
        Assert.assertTrue(homePage.isTitlePresent(),
            "Authorization failed. You were not directed to the home page");
    }
}
