package ru.rencredit.pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.rencredit.common.driver.WebDriverManager;

public class BaseWidget {

    protected WebElement rootElement;
    protected WebDriver driver;

    public BaseWidget(WebElement rootElement) {
        this(rootElement, WebDriverManager.getDriver());
    }

    public BaseWidget(WebElement rootElement, WebDriver driver) {
        this.rootElement = rootElement;
        this.driver = driver;
    }

    public void click() {
        this.rootElement.click();
    }

}
