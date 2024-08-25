package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ATMPage {

    private final String url = "about/";
    private final SelenideElement listTrigger = $$(".b-switch__block").first(),
            addressInput = $$x("//input[@placeholder='Поиск по адресу или станции метро']").get(1);
    private final ElementsCollection results = $$x("//a[@title='Посмотреть на карте']");

    @Step("Click the trigger")
    public ATMPage clickListTrigger() {
        listTrigger.click();
        return this;
    }

    @Step("Scroll to list trigger")
    public ATMPage scrollToListTrigger() {
        listTrigger.scrollTo();
        return this;
    }

    @Step("Enter address")
    public ATMPage enterAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    @Step("Check the search result")
    public void checkSearchResult(String text) {
        results.findBy(text(text)).shouldBe(visible);
    }
}