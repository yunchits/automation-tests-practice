package com.solvd.servicies;

import com.solvd.web.ebay.pages.main.HomePage;
import com.solvd.web.ebay.pages.main.components.Language;

public class LanguageService {

    public static final String ENGLISH_LANG = "English";

    public void setEnglishLanguage(HomePage page) {
        Language languageButton = page.getNavigation().getLanguageSetter();

        if (languageButton.getRootExtendedElement().isElementPresent() && (!languageButton.getText().equals(ENGLISH_LANG))) {
            languageButton.setLanguage();
        }
    }
}
