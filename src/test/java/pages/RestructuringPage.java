package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class RestructuringPage {

    private final SelenideElement detailsButton = $$(byText("Узнать подробности")).get(2),
            faqTitle = $x("//h2[text()='Какими бывают кредитные каникулы']");

    @Step("Click the details button")
    public RestructuringPage clickDetailsButton() {
        detailsButton.click();
        return this;
    }

    @Step("Click the details button")
    public RestructuringPage checkFaqTitle() {
        faqTitle.shouldBe(visible);
        return this;
    }
}