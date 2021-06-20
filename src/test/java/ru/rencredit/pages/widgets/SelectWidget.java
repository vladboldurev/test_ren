package ru.rencredit.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class SelectWidget extends BaseWidget {

    private By optionsElements =  By.xpath(".//li");

    public SelectWidget(WebElement rootElement) {
        super(rootElement);
    }

    public SelectWidget(WebElement rootElement, WebDriver driver) {
        super(rootElement, driver);
    }

    public List<WebElement> getOptions() {
        return this.rootElement.findElements(optionsElements);
    }

    public void selectedByValue(String value) {
        List<WebElement> options = this.getOptions();
        Optional<WebElement> option = options.stream()
                .filter(x -> x.getAttribute("innerText").equals(value))
                .findFirst();

        if(option.isPresent()) {
            option.get().click();
        }
    }

}
