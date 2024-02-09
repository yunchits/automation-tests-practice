package com.solvd.web;

import com.solvd.constants.TimeConstant;
import com.solvd.models.Languages;
import com.solvd.servicies.LanguageService;
import com.solvd.web.ebay.pages.main.CartPage;
import com.solvd.web.ebay.pages.main.HomePage;
import com.solvd.web.ebay.pages.main.ItemPage;
import com.solvd.web.ebay.pages.main.SearchPage;
import com.solvd.web.ebay.pages.main.components.ItemSearchCard;
import com.solvd.web.ebay.pages.main.components.ItemCartSummary;
import com.solvd.web.ebay.pages.base.components.Language;
import com.solvd.web.ebay.pages.main.components.SearchLine;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EbayWebTest extends AbstractTest {

    private static final String SEARCH_ITEM_TITLE = "iphone";
    private static final String ADDITIONAL_PARAMETERS = " 14 pro max 256gb silver";

    private static final int FIRST_ELEMENT_INDEX = 0;
    private static final int SECOND_ELEMENT_INDEX = 1;

    @Test(description = "Verify language change")
    public void testSetLanguage() {
        HomePage homePage = openHomePageInEnglish();

        Language languageSetter = homePage.getNavigation().getLanguageSetter();

        Assert.assertTrue(languageSetter.getRootExtendedElement().isElementPresent(TimeConstant.SHORT_TIMEOUT),
            "Language setter is not present");
        String actual = languageSetter.getText();

        Assert.assertEquals(actual, Languages.ENGLISH.getName(), "Language is incorrect");
    }

    @Test(description = "Verify search")
    public void testSearch() {
        HomePage homePage = openHomePageInEnglish();

        SearchLine searchLine = homePage.getSearchLine();

        Assert.assertTrue(searchLine.getSearchInput().isElementPresent(TimeConstant.SHORT_TIMEOUT),
            "Search input is not present");
        Assert.assertTrue(searchLine.getSearchButton().isElementPresent(TimeConstant.SHORT_TIMEOUT),
            "Search button is not present");

        searchLine.typeSearchInputValue(SEARCH_ITEM_TITLE);
        SearchPage searchPage = searchLine.clickSearchButton();

        Assert.assertTrue(getDriver().getCurrentUrl().contains(SEARCH_ITEM_TITLE),
            "Url does not contain search request");

        List<ItemSearchCard> cards = searchPage.getCards();

        cards.forEach(card -> {
            String actualItemTitle = card.getTitleText();
            Assert.assertTrue(actualItemTitle.toLowerCase().contains(SEARCH_ITEM_TITLE.toLowerCase()),
                "Item does not contain the required name");
        });
    }

    @Test(description = "Verify that the required item card opens")
    public void testItemCard() {
        HomePage page = openHomePageInEnglish();

        SearchLine searchLine = page.getSearchLine();

        searchLine.typeSearchInputValue(SEARCH_ITEM_TITLE);
        SearchPage searchPage = searchLine.clickSearchButton();

        ItemSearchCard card = searchPage.getCardByIndex(FIRST_ELEMENT_INDEX);
        Assert.assertTrue(card.getItemTitle().isElementPresent(TimeConstant.SHORT_TIMEOUT),
            "Cart title is not present");

        String expectedTitle = card.getTitleText();
        ItemPage itemPage = card.click();
        itemPage.switchWindow();

        String actualTitle = itemPage.getTitleText();

        Assert.assertEquals(actualTitle, expectedTitle, "Item card's title is incorrect");
    }

    @Test(description = "Verify that the items add to the card and the total price is displays correctly")
    public void testAddItemsToCard() {
        HomePage homePage = openHomePageInEnglish();

        SearchLine searchLine = homePage.getSearchLine();

        searchLine.typeSearchInputValue(SEARCH_ITEM_TITLE + ADDITIONAL_PARAMETERS);
        SearchPage searchPage = searchLine.clickSearchButton();
        String searchPageTab = getDriver().getWindowHandle();

        double expectedSubtotal = addItemToCartAndGetPrice(searchPage, FIRST_ELEMENT_INDEX);

        switchToTab(searchPageTab);

        expectedSubtotal += addItemToCartAndGetPrice(searchPage, SECOND_ELEMENT_INDEX);

        switchToTab(searchPageTab);

        CartPage cartPage = searchPage.openCart();

        double actualSubtotal = cartPage.getSubtotalAmount();
        expectedSubtotal += cartPage.getShippingAmount();

        Assert.assertEquals(actualSubtotal, expectedSubtotal,
            "The amount in the cart differs from the total prices of the added products");
    }

    @Test(description = "Verify that the items get removed from the cart")
    public void testCleanCart() {
        HomePage homePage = openHomePageInEnglish();

        SearchLine searchLine = homePage.getSearchLine();

        searchLine.typeSearchInputValue(SEARCH_ITEM_TITLE + ADDITIONAL_PARAMETERS);
        SearchPage searchPage = searchLine.clickSearchButton();
        String searchPageTab = getDriver().getWindowHandle();

        addItemToCartAndGetPrice(searchPage, FIRST_ELEMENT_INDEX);
        switchToTab(searchPageTab);

        addItemToCartAndGetPrice(searchPage, SECOND_ELEMENT_INDEX);
        switchToTab(searchPageTab);

        CartPage cartPage = homePage.openCart();

        List<ItemCartSummary> itemSummaries = cartPage.getItemSummaries();

        /* It is not possible to iterate through itemSummaries with forEach and close each one individually
         * because eBay refreshes the page after removing the first item, making subsequent elements
         * in the list unrecognizable. */
        for (int i = 0; i < itemSummaries.size(); i++) {
            pause(TimeConstant.SEC_TIMEOUT); // waitUntil(ExpectedConditions.elementToBeClickable(removeButton.getElement()), 3); doesnt work, element is clickable
            cartPage.getItemSummaries().get(FIRST_ELEMENT_INDEX).clickRemoveButton();
        }

        Assert.assertTrue(cartPage.getEmptyCartText().isElementPresent(TimeConstant.SHORT_TIMEOUT),
            "No indication that the cart is empty");
    }

    private double addItemToCartAndGetPrice(SearchPage searchPage, int index) {
        ItemSearchCard card = searchPage.getCardByIndex(index);
        ItemPage itemPage = card.click();
        switchToLastTab();
        double priceAmount = itemPage.getPriceAmount();
        itemPage.addItemToCard();
        return priceAmount;
    }

    private void switchToLastTab() {
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        int lastIndex = tabs.size() - 1;
        getDriver().switchTo().window(tabs.get(lastIndex));
    }

    private void switchToTab(String tab) {
        Set<String> windowHandles = getDriver().getWindowHandles();
        windowHandles.stream().filter(i -> i.equals(tab))
            .findFirst().ifPresent(w -> getDriver().switchTo().window(w));
    }

    private HomePage openHomePageInEnglish() {
        HomePage page = new HomePage(getDriver());
        page.open();
        new LanguageService().setLanguage(page, Languages.ENGLISH);
        return page;
    }
}
