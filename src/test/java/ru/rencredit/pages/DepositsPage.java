package ru.rencredit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class DepositsPage extends BasePageObject{

    private final String sliderPositionTemplate = "./div[@class='range-scale__item range-scale__item_%d']";

    @FindBy(xpath= "//label[contains(text(),'Открытие вклада')]/following::input[@name='deposit_b_n']/..")
    private WebElement inBankCheckbox;

    @FindBy(xpath= "//label[contains(text(),'Сумма вклада')]/following::input[@name='amount']")
    private WebElement depositAmountInput;

//    @FindBy(xpath= "//div[@data-property='period']//div[@class='ui-slider-range ui-widget-header ui-corner-all ui-slider-range-min']")
//    private WebElement periodSlider;

    @FindBy(xpath= "//div[@data-property='period']//div[@class='range-scale range-scale_item_6']")
    private WebElement periodSlider;



    public void clickCalculateInBankCheckbox() {
        wait.forElementVisible(inBankCheckbox);
        if(!inBankCheckbox.isSelected()){ inBankCheckbox.click(); }
    }

    public void setValueInCalculateDepositAmount(String amount) {
        wait.forElementVisible(depositAmountInput);
        depositAmountInput.sendKeys(amount);
    }

    public void setTermForDeposit(String termDeposit) {
        Integer sliderPosition = TermsOfDepositsHelper.getTermsPositionByName(termDeposit);
        WebElement sliderPositionElement = periodSlider.findElement(By.xpath(String.format(sliderPositionTemplate, sliderPosition)));
        sliderPositionElement.click();
    }

}


class TermsOfDepositsHelper {

    private static Map<String, Integer> termsOfDeposits =  new HashMap<>();

    static {
        termsOfDeposits.put("18 месяцев", 5);
        termsOfDeposits.put("13 месяцев", 4);
        termsOfDeposits.put("12 месяцев", 3);
        termsOfDeposits.put("9 месяцев", 2);
        termsOfDeposits.put("6 месяцев", 1);
        termsOfDeposits.put("3 месяцев", 0);
    }

    public static Integer getTermsPositionByName(String name) {
        return termsOfDeposits.get(name);
    }
}




