package com.solvd.mobile.base;

import com.solvd.mobile.models.UserData;
import com.solvd.mobile.pages.common.*;
import com.solvd.mobile.services.AuthService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class NTCBaseTest implements IAbstractTest, IMobileUtils {

    protected HomePageBase performDefaultSteps() {
        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
        authPage.clickSingInButton();

        SignInRecoveryPageBase signInRecoveryPage = initPage(getDriver(), SignInRecoveryPageBase.class);
        SignInPageBase signInPage = initPage(getDriver(), SignInPageBase.class);

        HomePageBase homePage;
        if (signInRecoveryPage.isPresent()) {
            homePage = signInRecoveryPage.clickContinue();
        } else if (signInPage.isPresent()) {
            SignedPageBase signedPage = new AuthService().login(signInPage, UserData.VALID);
            homePage = signedPage.clickContinue();
        } else {
            homePage = initPage(getDriver(), HomePageBase.class);
        }

        homePage.clickAllowNotifications();
        homePage.closeFeedbackModal();
        return homePage;
    }
}