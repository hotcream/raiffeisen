package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.TestData;

@Tag("regression")
@DisplayName("Raiffeisen bank site UI tests")
public class RaiffeisenTests extends BaseTest  {

    TestData testData = new TestData();

    @Test
    @Tag("negative")
    @DisplayName("Check the opening of the debit cashback card page")
    public void checkDebitCashbackCardPageTest() {

        mainPage.openMainPage()
                .openCardsPopup()
                .clickDebitCardsButton();

        debitCardsPage.clickCashbackCardButton();

        cashbackCardPage.checkCashbackCardTitle();

    }

    @Test
    @DisplayName("Check the restructuring FAQ title")
    public void checkRestructingFaqTitleTest() {

        mainPage.openMainPage()
                .openCardsPopup()
                .clickRestructuringButton();

        restructuringPage.clickDetailsButton()
                .checkFaqTitle();
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check error message for online banking login without phone number.")
    public void checkErrorForLoginWithoutPhoneNumberTest() {

        mainPage.openMainPage()
                .clickOnlineBankButton();

        switchToNewWindow(1);

        onlineBankPage.clickEnterButton()
                .checkErrorMessage();
    }

    @Test
    @DisplayName("Check the opening press centre page")
    public void checkOpeningPressCentrePageTest() {

        aboutPage.openAboutPage()
                .clickPressCentreAboutButton()
                .checkCashbackCardTitle();
    }

    @Test
    @DisplayName("Check ATM results")
    public void checkOpenAndroidAppPageTest() {

        mainPage.openMainPage()
                .clickAtmsButton();

        atmPage.scrollToListTrigger()
                .clickListTrigger()
                .enterAddress(testData.searchAddress)
                .checkSearchResult(testData.searchAddress);
    }
}