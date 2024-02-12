package com.solvd.mobile;

import com.solvd.mobile.base.NTCBaseTest;
import com.solvd.mobile.models.TimeoutConstants;
import com.solvd.mobile.pages.ResultPage;
import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.components.Browse;
import com.solvd.mobile.pages.components.TrainingCard;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NTCFeaturesTest extends NTCBaseTest {

    @Test()
    public void testSort() {
        HomePageBase homePage = performDefaultSteps();
        Browse browse = homePage.clickBrowse();
        Assert.assertTrue(browse.isSearchInputPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS),
            "Search input is not present");
        ResultPage resultPage = browse.search("long workout");
        List<TrainingCard> allTrainingCards = resultPage.getAllTrainingCards();

        System.out.println(allTrainingCards.size());


    }

}
