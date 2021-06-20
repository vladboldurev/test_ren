package ru.rencredit;

import org.testng.annotations.*;
import ru.rencredit.common.driver.WebDriverManager;
import ru.rencredit.dataprovider.CardDataProviderClass;
import ru.rencredit.dataprovider.DepositDataProvider;
import ru.rencredit.steps.CalculateDepositSteps;
import ru.rencredit.steps.RegisterCardSteps;


public class MainPageTest {

    @BeforeClass
    public void setUp() {
        WebDriverManager.setBrowserType("CHROME");
    }

    @Test(description = "calculate new deposit", dataProvider = "deposit_data_provider", dataProviderClass = DepositDataProvider.class)
    public void testFrist(String amount, String termDeposit){
        CalculateDepositSteps calculateDepositSteps = new CalculateDepositSteps();
        calculateDepositSteps.goToMainPage();
        calculateDepositSteps.goToDepositsPageFromMainPage();
        calculateDepositSteps.calculateIncomeFromDeposit(amount, termDeposit);
    }

    @Test(description = "Register new card", dataProvider = "card_data_provider", dataProviderClass = CardDataProviderClass.class)
    public void testSecond(String lastName, String firstName, String phone, String email, String city) {
        RegisterCardSteps registerCardSteps = new RegisterCardSteps();
        registerCardSteps.goToMainPage();
        registerCardSteps.goToCardsPageFromMainPage();
        registerCardSteps.fillRegisterDataForCard(lastName,firstName, phone, email, city);
    }

    @AfterMethod(alwaysRun=true)
    public void TearDown(){
        WebDriverManager.destroyLocalDriver();
    }

}