package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.ResultPageBase;
import com.solvd.mobile.pages.components.TrainingCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends ResultPageBase {

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.nike.ntc:id/compose_view\"]/android.view.View/android.view.View/android.view.View")
    private List<TrainingCard> trainingCards;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<TrainingCard> getAllTrainingCards() {
        swipeDown(5);
        return trainingCards;
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
