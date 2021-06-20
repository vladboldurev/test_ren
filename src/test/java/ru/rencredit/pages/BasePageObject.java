package ru.rencredit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rencredit.common.driver.WebDriverManager;
import ru.rencredit.common.wait.Wait;

public class BasePageObject {

    protected WebDriver driver;
    protected Wait wait;
    protected Actions actions;
    protected WebDriverWait waitFor;
    protected int timeOut = 15;

    public BasePageObject() {
        this.driver = WebDriverManager.getDriver();
        this.waitFor = new WebDriverWait(driver, timeOut);
        this.wait = new Wait(this.driver);
        this.actions = new Actions(driver);

        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        this.driver.get(url);
    }



}
