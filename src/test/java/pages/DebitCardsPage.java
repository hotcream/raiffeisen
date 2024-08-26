package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;

public class DebitCardsPage {

    private final SelenideElement cashbackCardButton = $$(byText("Подробнее")).first();;

    @Step("Click the cashback card button")
    public DebitCardsPage clickCashbackCardButton() {
        cashbackCardButton.click();
        return this;
    }
}