package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;

public class CashbackCardPage {

    private final SelenideElement cashbackCardTitle = $$(byText("Дебетовая Кэшбэк-карта")).first();

    @Step("Check cashback card title should be visible")
    public CashbackCardPage checkCashbackCardTitle() {
        cashbackCardTitle.shouldBe(visible);
        return this;
    }
}