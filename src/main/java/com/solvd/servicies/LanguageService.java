package com.solvd.servicies;

import com.solvd.models.Languages;
import com.solvd.web.ebay.pages.main.HomePage;
import com.solvd.web.ebay.pages.base.components.Language;

public class LanguageService {

    public void setLanguage(HomePage page, Languages lang) {
        Language languageButton = page.getLanguageSetter();

        if (languageButton.getRootExtendedElement().isElementPresent()
                && !languageButton.getText().equals(lang.getName())) {
            languageButton.setLanguage();
        }
    }
}
