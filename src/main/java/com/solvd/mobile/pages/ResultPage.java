package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.FilterPageBase;
import com.solvd.mobile.pages.common.ResultPageBase;
import com.solvd.mobile.pages.common.SearchPageBase;
import com.solvd.mobile.pages.components.WorkoutCard;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultPageBase.class)
public class ResultPage extends ResultPageBase {

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.nike.ntc:id/compose_view\"]/android.view.View/android.view.View/android.view.View[1]")
    private WorkoutCard workoutCard;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.nike.ntc:id/compose_view\"]/android.view.View/android.view.View/android.view.View")
    private List<WorkoutCard> workoutCards;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Filter']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement backButton;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WorkoutCard> getAllTrainingCards() {
        workoutCard.isUIObjectPresent(5);
        return workoutCards;
    }

    @Override
    public FilterPageBase clickFilterButton() {
        filterButton.click();
        return initPage(getDriver(), FilterPageBase.class);
    }

    @Override
    public SearchPageBase clickBack() {
        backButton.click();
        return initPage(getDriver(), SearchPageBase.class);
    }

//    @Override
//    public List<TrainingCard> getAllTrainingCards() {
//        List<TrainingCard> allCards = new ArrayList<>();
//        int swipeCount = 5; // Количество прокруток страницы
//        for (int i = 0; i < swipeCount; i++) {
//            // Прокрутка страницы вниз
//            swipeDown(5); // Используйте метод swipeDown из вашего интерфейса IMobileUtils
//            // Получение всех видимых карточек после каждой прокрутки
//            allCards.addAll(trainingCards);
//        }
//        return allCards;
//    }
}
