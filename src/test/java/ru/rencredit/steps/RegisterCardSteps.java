package ru.rencredit.steps;

import ru.rencredit.pages.CardsPage;
import ru.rencredit.pages.MainPage;
import ru.rencredit.pages.RegisterCardPage;
import io.qameta.allure.Step;

import static io.qameta.allure.Allure.parameter;


public class RegisterCardSteps {

    private MainPage mainPage;
    private CardsPage cardPage;
    private RegisterCardPage registerCardPage;

    @Step("open main page")
    public void goToMainPage() {
        this.mainPage = new MainPage();
        this.mainPage.open();
    }

    @Step("open cards page")
    public void goToCardsPageFromMainPage() {
        this.cardPage = mainPage.clickCardButton();
        this.registerCardPage = this.cardPage.clickRegisterCardButton();
    }

    @Step("fill card field")
    public void fillRegisterDataForCard(String lastName, String firstName, String phone, String email, String city) {
        parameter("Card params: ",lastName + " " + firstName + " " + phone + " " + email + " " + city );
        this.registerCardPage.setValueInLastNameInput(lastName);
        this.registerCardPage.setValueInFirstName(firstName);
        this.registerCardPage.clickNoPatronymicCheckBox();
        this.registerCardPage.setValueInPhoneInput(phone);
        this.registerCardPage.setValueInEmailInput(email);
        this.registerCardPage.setValueInCitySelect(city);

    }
}
