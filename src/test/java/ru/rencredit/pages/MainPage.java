package ru.rencredit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePageObject{

    private static final String PAGE_URL = "https://rencredit.ru/";

    @FindBy(xpath= "//div[text()=\"Вклады\"]/preceding-sibling::a")
    private WebElement depositsButton;

    @FindBy(xpath= "//div[text()=\"Карты\"]/preceding-sibling::a")
    private WebElement cardsButton;

    public MainPage open(){
        open(PAGE_URL);
        return this;
    }

    public DepositsPage clickDepositButton() {
        return clickDepositsButton();
    }

    public CardsPage clickCardButton() {
        return clickCardsButton();
    }

    public DepositsPage clickDepositsButton(){
        wait.forElementVisible(depositsButton);
        depositsButton.click();
        return new DepositsPage();
    }

    public CardsPage clickCardsButton(){
        wait.forElementVisible(cardsButton);
        cardsButton.click();
        return new CardsPage();
    }

}
