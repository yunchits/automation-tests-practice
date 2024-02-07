package com.solvd.web;

import com.solvd.servicies.LanguageService;
import com.solvd.web.ebay.pages.HomePage;
import com.solvd.web.ebay.pages.SearchPage;
import com.solvd.web.ebay.pages.components.ItemCard;
import com.solvd.web.ebay.pages.components.SearchLine;
import com.zebrunner.carina.core.AbstractTest;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

@Log4j2
public class EbayWebTest extends AbstractTest {

    private final LanguageService languageService = new LanguageService();

    @Test
    public void testSetLanguage() {
        HomePage page = new HomePage(getDriver());
        page.open();

        languageService.setEnglishLanguage(page);
        String actual = page.getHomeHeader().getLanguage().getLanguageName().getText();
        Assert.assertEquals(actual, "English");
    }

    @Test
    public void testSearch() {
        HomePage page = new HomePage(getDriver());
        page.open();

        languageService.setEnglishLanguage(page);

        SearchLine searchLine = page.getHomeHeader().getSearchLine();

        Assert.assertTrue(searchLine.getSearchInput().isElementPresent(1), "Search input is not present");
        Assert.assertTrue(searchLine.getSearchButton().isElementPresent(1), "Search button is not present");

        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(searchLine.getCategoriesSelect().isElementPresent(1));
//        softAssert.assertEquals(searchLine.getSearchInputPlaceholder(), "Search for anything",
//            "Search input incorrect placeholder");

        String itemTitle = "iPhone";

        searchLine.typeSearchInputValue(itemTitle);
        SearchPage searchPage = searchLine.clickSearchButton();

        softAssert.assertTrue(getDriver().getCurrentUrl().contains(itemTitle), "Url does not contain search request");

        List<ItemCard> cards = searchPage.getCards();

        cards.forEach(card -> {
            String actualItemTitle = card.getTextTitle();
            if (!actualItemTitle.isEmpty()) {
                softAssert.assertTrue(actualItemTitle.toLowerCase().contains(itemTitle.toLowerCase()),
                    "Item does not contain the required name");
            } else {
                log.warn("Item title is empty, skipping assertion");
            }
        });

        softAssert.assertAll();
    }
}
