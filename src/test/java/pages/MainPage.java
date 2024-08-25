package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement cardsButton = $$x("//a[@data-testid='main-menu-link']").first(),
            debitCardsButton = $x("//a[text()='Дебетовые']"),
            restructuringButton = $x("//a[text()='  Реструктуризация ']"),
            onlineBankButton = $$(byText("Онлайн-банк")).first(),
            atmsButton = $$x("//span[text()='Банкоматы']/parent::div/parent::a").first();


    @Step("Open the main page")
    public MainPage openMainPage() {
        open(baseUrl);
        return this;
    }

    @Step("Open the cards pop-up")
    public MainPage openCardsPopup() {
        Selenide.sleep(2000);
        cardsButton.click();
        return this;
    }

    @Step("Click the debit cards button")
    public MainPage clickDebitCardsButton() {
        Selenide.sleep(2000);
        debitCardsButton.click();
        return this;
    }

    @Step("Click the restructuring button")
    public MainPage clickRestructuringButton() {
        Selenide.sleep(2000);
        restructuringButton.click();
        return this;
    }

    @Step("Click the online bank button")
    public MainPage clickOnlineBankButton() {
        onlineBankButton.click();
        return this;
    }

    @Step("Click the ATMs button")
    public MainPage clickAtmsButton() {
        atmsButton.click();
        return this;
    }
}