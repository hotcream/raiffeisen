package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OnlineBankPage {

    private final SelenideElement enterButton = $x("//span[text()='Войти']"),
            errorMessage = $(byText("Поле обязательно для заполнения"));

    @Step("Click the online bank enter button")
    public OnlineBankPage clickEnterButton() {
        enterButton.click();
        return this;
    }

    @Step("Check error message")
    public OnlineBankPage checkErrorMessage() {
        errorMessage.click();
        return this;
    }
}