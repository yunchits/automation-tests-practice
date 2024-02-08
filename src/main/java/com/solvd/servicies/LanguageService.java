package com.solvd.servicies;

import com.solvd.web.ebay.pages.HomePage;
import com.solvd.web.ebay.pages.components.Language;

public class LanguageService {

    public static final String ENGLISH_LANG = "English";

    public void setEnglishLanguage(HomePage page) {
        Language languageButton = page.getHomeHeader().getLanguageSetter();

        if (languageButton.isPresent() && (!languageButton.getText().equals(ENGLISH_LANG))) {
            languageButton.setLanguage();
        }
    }
}
