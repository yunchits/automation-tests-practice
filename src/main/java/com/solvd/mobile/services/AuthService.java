package com.solvd.mobile.services;

import com.solvd.mobile.models.UserData;
import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.common.PassPageBase;
import com.solvd.mobile.pages.common.SignInPageBase;
import com.solvd.mobile.pages.common.SignedPageBase;

public class AuthService {

    public SignedPageBase login(SignInPageBase signInPage, UserData userData) {
        signInPage.typeEmail(userData.getEmail());
        PassPageBase passPage = signInPage.clickContinue();
        passPage.typePass(userData.getPass());
        return passPage.clickSingIn();
    }

//    public PassPageBase enterEmail(SignInPageBase signInPage, UserData userData) { todo
//        signInPage.typeEmail(userData.getEmail());
//        return signInPage.clickContinue();
//    }
//
//    public HomePageBase enterPass(PassPageBase passPage, UserData userData) {
//        passPage.typePass(userData.getPass());
//        return passPage.clickSingIn();
//    }
}
