package com.solvd.mobile.services;

import com.solvd.mobile.models.TimeoutConstants;
import com.solvd.mobile.models.UserData;
import com.solvd.mobile.pages.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class BaseActionsService implements IAbstractTest, IMobileUtils {

    private final AuthService authService = new AuthService();

    public HomePageBase performDefaultSteps() {
        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
        SignInPageBase signInPage = authPage.clickSignInButton();
        ReturnToAccountPageBase returnToAccountPage = initPage(getDriver(), ReturnToAccountPageBase.class);

        HomePageBase homePage;
        if (returnToAccountPage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS)) {
            homePage = returnToAccountPage.clickContinue();
        } else if (signInPage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS)) {
            SignedPageBase signedPage = authService.login(signInPage, UserData.VALID);
            homePage = signedPage.clickContinue();
        } else {
            homePage = initPage(getDriver(), HomePageBase.class);
        }

        homePage.clickAllowNotifications();
        homePage.closeFeedbackModal();
        return homePage;
    }

    public void closeModals(HomePageBase homePage) {
        homePage.clickAllowNotifications();
        homePage.closeFeedbackModal();
    }

    public SignInPageBase openSignInPage() {
        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
        SignInPageBase signInPage = authPage.clickSignInButton();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        if (signInPage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS)) {
            return signInPage;
        } else if (homePage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS)) {
            closeModals(homePage);
            authService.logOut(homePage);
            authPage.clickSignInButton();
        }

        return initPage(getDriver(), ReturnToAccountPageBase.class).clickUseAnotherAccount();
    }

    public ReturnToAccountPageBase openReturnToAccountPage() {
        AuthPageBase authPage = initPage(getDriver(), AuthPageBase.class);
        SignInPageBase signInPage = authPage.clickSignInButton();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        if (signInPage.isPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS)) {
            authService.login(signInPage, UserData.VALID);
            closeModals(homePage);
            authService.logOut(homePage);
            authPage.clickSignInButton();
        } else if (homePage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS)) {
            closeModals(homePage);
            authService.logOut(homePage);
            authPage.clickSignInButton();
        }

        return initPage(getDriver(), ReturnToAccountPageBase.class);
    }
}
