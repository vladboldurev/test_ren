package ru.rencredit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rencredit.pages.widgets.SelectWidget;


public class RegisterCardPage extends BasePageObject{
    @FindBy(css= "input[id=t1]")
    private WebElement lastNameInput;

    @FindBy(css= "input[id=t2]")
    private WebElement firstNameInput;

    @FindBy(xpath= "//div[contains(text(), 'Общие данные')]/..//label[contains(text(), 'Нет отчества')]/div")
    private WebElement noPatronymicCheckBox;

    @FindBy(css= "input[id=t4]")
    private WebElement phoneInput;

    @FindBy(css= "input[id=t38]")
    private WebElement emailInput;

    @FindBy(xpath= "//div[@id='s2-styler']")
    private WebElement cityForGetCardSelect;


    public void setValueInLastNameInput(String lastName) {
        wait.forElementVisible(lastNameInput);
        lastNameInput.sendKeys(lastName);
    }

    public void setValueInFirstName(String firstName) {
        wait.forElementVisible(firstNameInput);
        firstNameInput.sendKeys(firstName);
    }

    public void clickNoPatronymicCheckBox() {
        wait.forElementVisible(noPatronymicCheckBox);
        if(!noPatronymicCheckBox.isSelected()) {
            noPatronymicCheckBox.click();
        }
    }

    public void setValueInPhoneInput(String phone) {
        wait.forElementVisible(phoneInput);
        phoneInput.sendKeys(phone);
    }

    public void setValueInEmailInput(String email) {
        wait.forElementVisible(emailInput);
        emailInput.sendKeys(email);
    }

    public void setValueInCitySelect(String city) {
        wait.forElementClickable(cityForGetCardSelect);
        SelectWidget select = new SelectWidget(cityForGetCardSelect, driver);
        select.click();
        select.selectedByValue(city);

    }









}
