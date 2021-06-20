package ru.rencredit.dataprovider;

import org.testng.annotations.DataProvider;

public class DepositDataProvider {

    @DataProvider(name = "deposit_data_provider")
    public static Object[][] depositDataProvider() {
        return new Object[][] {{"1000000", "9 месяцев"},};
    }
}

