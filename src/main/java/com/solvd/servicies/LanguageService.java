package com.solvd.servicies;

import com.solvd.web.ebay.pages.HomePage;

public class LanguageService {

    private static final String ENGLISH_LANG = "English";

    public HomePage setEnglishLanguage(HomePage page) {
        if (!page.getHomeHeader().getLanguage().getLanguageName().getText().equals(ENGLISH_LANG)) {
            page.getHomeHeader().getLanguage().setLanguage();
        }
        return page;
    }
}
