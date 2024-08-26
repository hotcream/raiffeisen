package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AboutPage {

    private final String url = "about/";
    private final SelenideElement pressTitle = $$x("//h1[text()='Пресс-центр']").get(1),
            pressCentreAboutButton = $x("//span[text()='Подробнее']");

    @Step("Open about page")
    public AboutPage openAboutPage() {
        open(baseUrl + url);
        return this;
    }

    @Step("Check press centre title should be visible")
    public AboutPage checkCashbackCardTitle() {
        pressTitle.shouldBe(visible);
        return this;
    }

    @Step("Click the press centre about button")
    public AboutPage clickPressCentreAboutButton() {
        pressCentreAboutButton.click();
        return this;
    }
}