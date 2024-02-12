package com.solvd.mobile;

import com.solvd.mobile.base.NTCBaseTest;
import com.solvd.mobile.models.TimeoutConstants;
import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.common.ResultPageBase;
import com.solvd.mobile.pages.components.Browse;
import com.solvd.mobile.pages.components.WorkoutCard;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Log4j2
public class NTCFeaturesTest extends NTCBaseTest {

    @Test()
    public void testSearchFilter() {
        HomePageBase homePage = performDefaultSteps();
        Browse browse = homePage.clickBrowse();
        Assert.assertTrue(browse.isSearchInputPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS),
            "Search input is not present");
        ResultPageBase resultPage = browse.clickSearch()
            .searchByText("long workout")
            .clickFilterButton()
            .clickLevelIntermediate()
            .clickDone();

        List<WorkoutCard> cards = resultPage.getAllTrainingCards();
        log.info(cards.size());
        cards.remove(cards.size() - 1);
        log.info(cards.size());
        int i = 0;
        for (WorkoutCard card : cards) {
            log.info(i);
            String title = card.getDescriptionTitle();
            log.info(title);
            log.info(title.contains("Intermediate"));
            Assert.assertTrue(title.contains("Intermediate"),
                "Filtering of the search query failed");
            i++;
        }
    }

    @Test()
    public void testSaveWorkout() {
        HomePageBase homePage = performDefaultSteps();
        Browse browse = homePage.clickBrowse();
        Assert.assertTrue(browse.isSearchInputPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS),
            "Search input is not present");
        ResultPageBase resultPage = browse
            .clickSearch()
            .searchByText("long workout");
        WorkoutCard card = resultPage.getAllTrainingCards().get(0);
        String expectedWorkoutTitle = card.getWorkoutTitle();
        card.clickSave();
        homePage = resultPage
            .clickBack()
            .clickBack();

        WorkoutCard savedWorkOut = homePage
            .clickOpenSideMenu()
            .clickSaved()
            .getCard();
        String actualWorkoutTitle = savedWorkOut.getWorkoutTitle();
        Assert.assertEquals(actualWorkoutTitle, expectedWorkoutTitle, "Workout is not saved");

        savedWorkOut.clickSave();
    }
}
