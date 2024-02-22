package com.solvd.mobile.services;

import com.solvd.mobile.modals.LogOutConfirmationModal;
import com.solvd.mobile.models.UserData;
import com.solvd.mobile.pages.common.*;

public class AuthService {

    public SignedPageBase login(SignInPageBase signInPage, UserData userData) {
        signInPage.typeEmail(userData.getEmail());
        PassPageBase passPage = signInPage.clickContinue();
        passPage.typePass(userData.getPass());
        return passPage.clickSignIn();
    }

    public AuthPageBase logOut(HomePageBase homePage) {
        SideMenuPageBase sideMenuPage = homePage.clickOpenSideMenu();
        SettingsPageBase settingsPage = sideMenuPage.clickSettings();
        LogOutConfirmationModal logOutConfirmationModal = settingsPage.clickLogOut();
        return logOutConfirmationModal.clickConfirmLogOut();
    }
}
