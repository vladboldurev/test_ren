package ru.rencredit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardsPage extends BasePageObject{

    @FindBy(xpath= " //a[text()=\"Оформить заявку на карту\"]")
    private WebElement registerCardButton;


    public RegisterCardPage clickRegisterCardButton() {
        wait.forElementVisible(registerCardButton);
        registerCardButton.click();
        return new RegisterCardPage();
    }

}
