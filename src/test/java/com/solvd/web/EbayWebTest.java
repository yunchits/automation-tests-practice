package com.solvd.web;

import com.solvd.servicies.LanguageService;
import com.solvd.web.ebay.pages.CartPage;
import com.solvd.web.ebay.pages.HomePage;
import com.solvd.web.ebay.pages.ItemPage;
import com.solvd.web.ebay.pages.SearchPage;
import com.solvd.web.ebay.pages.components.ItemCard;
import com.solvd.web.ebay.pages.components.Language;
import com.solvd.web.ebay.pages.components.SearchLine;
import com.zebrunner.carina.core.AbstractTest;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Log4j2
public class EbayWebTest extends AbstractTest {

    private final LanguageService languageService = new LanguageService();

    @Test(enabled = false, description = "Verify language change")
    public void testSetLanguage() {
        HomePage page = new HomePage(getDriver());
        page.open();

        languageService.setEnglishLanguage(page);
        Language languageSetter = page.getHomeHeader().getLanguageSetter();

        Assert.assertTrue(languageSetter.isPresent());

        String actual = languageSetter.getText();
        Assert.assertEquals(actual, LanguageService.ENGLISH_LANG);
    }

    @Test(description = "Verify search")
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
            String actualItemTitle = card.getTitleText();
                Assert.assertTrue(actualItemTitle.toLowerCase().contains(itemTitle.toLowerCase()),
                    "Item does not contain the required name");
        });

        softAssert.assertAll();
    }

    @Test(description = "Verify that the required item card opens")
    public void testItemCard() {
        HomePage page = new HomePage(getDriver());
        page.open();

        languageService.setEnglishLanguage(page);
        SearchLine searchLine = page.getHomeHeader().getSearchLine();

        String itemTitle = "iPhone";

        searchLine.typeSearchInputValue(itemTitle);
        SearchPage searchPage = searchLine.clickSearchButton();

        ItemCard card = searchPage.getCardByIndex(0);
        String expectedTitle = card.getTitleText();
        ItemPage itemPage = card.click();
        itemPage.switchWindow();

        String actualTitle = itemPage.getTitleText();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Verify that the products add to the card and the total price is displays correctly")
    public void testAddItemsToCard() {
        new EbayAuthenticationTest().testValidLogin();

        HomePage page = new HomePage(getDriver());
        page.open();

        languageService.setEnglishLanguage(page);

        SearchLine searchLine = page.getHomeHeader().getSearchLine();

        String itemTitle = "iphone 14 pro max 256gb silver";

        searchLine.typeSearchInputValue(itemTitle);
        SearchPage searchPage = searchLine.clickSearchButton();
        String searchPageTab = getDriver().getWindowHandle();

        ItemCard card = searchPage.getCardByIndex(0);
        ItemPage itemPage = card.click();
        itemPage.switchWindow();
        double expectedSubtotal = itemPage.getPriceAmount();
        log.info(expectedSubtotal);
        itemPage.addItemToCard();

        switchTabTo(searchPageTab);

        ItemCard card1 = searchPage.getCardByIndex(1);
        ItemPage itemPage1 = card1.click();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(2));
        expectedSubtotal += itemPage1.getPriceAmount();
        log.info(expectedSubtotal);
        itemPage1.addItemToCard();

        switchTabTo(searchPageTab);

        CartPage cartPage = searchPage.openCart();

        double actualSubtotal = cartPage.getSubtotalAmount();
        log.info(actualSubtotal);

        Assert.assertEquals(actualSubtotal, expectedSubtotal);
    }

    private void switchTabTo(String searchPageTab) {
        Set<String> windowHandles = getDriver().getWindowHandles();
        windowHandles.stream().filter(i -> i.equals(searchPageTab))
                .findFirst().ifPresent(w -> getDriver().switchTo().window(w));
    }
}
