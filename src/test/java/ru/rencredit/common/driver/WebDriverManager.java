package ru.rencredit.common.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static String browserType = "CHROME";

    private static void createDriver(){
        createDriver(WebDriverManager.browserType);
    }

    private static void createDriver(String browserType){
        WebDriver driver = WebDriverFactory.valueOf(browserType).getWebDriver();
        WebDriverManager.setWebDriver(driver);
    }

    public static void setBrowserType(String browserType) {
        WebDriverManager.browserType = browserType;
    }

    public static WebDriver getDriver() {
        if(WebDriverManager.threadLocalDriverEmpty()) {
            WebDriverManager.createDriver();
        }
        return threadLocalDriver.get();
    }

    private static boolean threadLocalDriverEmpty() {
        return threadLocalDriver.get() == null;
    }

    private static void setWebDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public static void unset() {
        threadLocalDriver.remove();
    }

    public static void destroyLocalDriver(){
        if(!WebDriverManager.threadLocalDriverEmpty()) {
            threadLocalDriver.get().quit();
        }
        WebDriverManager.unset();
    }
}


