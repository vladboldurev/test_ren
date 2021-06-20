package ru.rencredit.dataprovider;

import org.testng.annotations.DataProvider;

public class CardDataProviderClass {
    @DataProvider(name = "card_data_provider")
    public static Object[][] cardDataProvider() {
        return new Object[][] {{"Павел", "Давыдов", "9875027736", "test@mail.com", "г. Москва"},};
    }

}
