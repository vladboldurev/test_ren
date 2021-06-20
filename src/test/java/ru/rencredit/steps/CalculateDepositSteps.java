package ru.rencredit.steps;


import ru.rencredit.pages.DepositsPage;
import ru.rencredit.pages.MainPage;
import io.qameta.allure.Step;

public class CalculateDepositSteps {

    private MainPage mainPage;
    private DepositsPage depositsPage;

    public CalculateDepositSteps() {
        this.mainPage = new MainPage();
    }

    @Step("open main page")
    public void goToMainPage() {
        this.mainPage.open();
    }

    @Step("open deposits page")
    public void goToDepositsPageFromMainPage() {
        depositsPage = mainPage.clickDepositButton();
    }

    @Step("calculate deposit")
    public void calculateIncomeFromDeposit(String amount, String termDeposit ) {
//        depositsPage.scrollToCalculateDeposits();
        depositsPage.clickCalculateInBankCheckbox();
        depositsPage.setValueInCalculateDepositAmount(amount);
        depositsPage.setTermForDeposit(termDeposit);
    }


}
