package com.solvd.mobile;

import com.solvd.mobile.models.Filters;
import com.solvd.mobile.models.TimeoutConstants;
import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.common.ResultPageBase;
import com.solvd.mobile.pages.common.WorkoutPageBase;
import com.solvd.mobile.pages.components.Browse;
import com.solvd.mobile.pages.components.WorkoutCard;
import com.solvd.mobile.services.BaseActionsService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Log4j2
public class NTCFeaturesTest implements IAbstractTest, IMobileUtils {

    private final static String SEARCH_QUERY = "long workout";

    private final BaseActionsService actionsService = new BaseActionsService();

    @Test(description = "Verify the success of applying the search filter")
    public void testSearchFilter() {
        HomePageBase homePage = actionsService.performDefaultSteps();
        Browse browse = homePage.clickBrowse();
        Assert.assertTrue(browse.isSearchInputPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS),
            "Search input is not present");

        ResultPageBase resultPage = browse.clickSearch()
            .searchByText(SEARCH_QUERY)
            .clickFilterButton()
            .selectFilter(Filters.INTERMEDIATE)
            .clickDone();

        List<WorkoutCard> cards = resultPage.getVisableWorkoutCards();

        for (int i = 0; i < cards.size() - 2; i++) {
            String title = cards.get(i).getDescriptionTitle();
            Assert.assertTrue(title.toLowerCase().contains(Filters.INTERMEDIATE.getId()),
                "Filtering of the search query failed");
        }
    }

    @Test(description = "Verify successful adding workout to saved")
    public void testSaveWorkout() {
        HomePageBase homePage = actionsService.performDefaultSteps();
        Browse browse = homePage.clickBrowse();
        Assert.assertTrue(browse.isSearchInputPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS),
            "Search input is not present");
        ResultPageBase resultPage = browse
            .clickSearch()
            .searchByText(SEARCH_QUERY);

        WorkoutCard card = resultPage.getFistWorkoutCard();
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

    @Test(description = "Verify that workout card displayed correctly")
    public void testOpenWorkoutCard() {
        HomePageBase homePage = actionsService.performDefaultSteps();
        Browse browse = homePage.clickBrowse();

        Assert.assertTrue(browse.isSearchInputPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS),
            "Search input is not present");

        ResultPageBase resultPage = browse
            .clickSearch()
            .searchByText(SEARCH_QUERY);

        WorkoutCard card = resultPage.getFistWorkoutCard();
        String expectedWorkoutTitle = card.getWorkoutTitle();
        WorkoutPageBase workoutPage = card.openWorkout();
        Assert.assertTrue(workoutPage.isPresent(TimeoutConstants.LONG_TIMEOUT_SECONDS),
            "Workout page is not present or displays incorrectly");

        String actualWorkoutTitle = workoutPage.getWorkoutTitleText();
        Assert.assertEquals(actualWorkoutTitle, expectedWorkoutTitle, "Workout displays incorrectly");
    }
}