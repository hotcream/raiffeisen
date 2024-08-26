package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ATMPage;
import pages.AboutPage;
import pages.CashbackCardPage;
import pages.DebitCardsPage;
import pages.MainPage;
import pages.OnlineBankPage;
import pages.RestructuringPage;

import java.util.Map;

public class BaseTest {

    MainPage mainPage = new MainPage();
    CashbackCardPage cashbackCardPage = new CashbackCardPage();
    DebitCardsPage debitCardsPage = new DebitCardsPage();
    RestructuringPage restructuringPage = new RestructuringPage();
    OnlineBankPage onlineBankPage = new OnlineBankPage();
    AboutPage aboutPage = new AboutPage();
    ATMPage atmPage = new ATMPage();

    static void switchToNewWindow(int n) {
        Selenide.sleep(3000);
        Selenide.switchTo().window(n);
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("windowSize", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "122");
        Configuration.baseUrl = "https://www.raiffeisen.ru/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = System.getProperty("remoteUrl");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void setUpBeforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        Selenide.closeWebDriver();
    }
}