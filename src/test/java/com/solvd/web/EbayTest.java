package com.solvd.web;

import com.solvd.web.ebay.EbayHomePage;
import com.solvd.web.ebay.SearchPage;
import com.solvd.web.ebay.components.SearchLine;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EbayTest extends AbstractTest {

    @Test
    public void testSearch() {
        WebDriver driver = getDriver();

        SoftAssert softAssert = new SoftAssert();
        EbayHomePage page = new EbayHomePage(driver);

        page.open();

        SearchLine searchLine = page.getHeader().getSearchLine();

//        softAssert.assertTrue(searchLine.getRootExtendedElement().isElementPresent()); //or
        softAssert.assertTrue(searchLine.getCategoriesSelect().isElementPresent(1));

        Assert.assertTrue(searchLine.getSearchInput().isElementPresent(1), "Search input is not present");
        Assert.assertTrue(searchLine.getSearchButton().isElementPresent(1), "Search button is not present");

        softAssert.assertEquals(searchLine.getSearchInputPlaceholder(), "Search for anything",
            "Search input incorrect placeholder");

        searchLine.typeSearchInputValue("iPhone");
        SearchPage searchPage = searchLine.clickSearchButton();

        softAssert.assertTrue(driver.getCurrentUrl().contains("iphone"), "Url does not contain search request");

//        List<ProductCard> cards = searchPage.getCards;
//        for (ProductCard card : cards) {
//            softAssert.assertTrue(card.getTextTitle.contains("iphone"));
//        }

        softAssert.assertAll();
    }
}
