package ru.rencredit.common.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static String browserType = "CHROME";

    private static void createDriver(){
        System.out.println("createDriver2");
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
            System.out.println("createDriver1");
            WebDriverManager.createDriver();
        }
        System.out.println("Driver exist 3");
        return threadLocalDriver.get();
    }

    private static boolean threadLocalDriverEmpty() {
        System.out.println("threadLocalDriverEmpty");
        return threadLocalDriver.get() == null;
    }

    private static void setWebDriver(WebDriver driver) {
        System.out.println("set WebDriver");
        threadLocalDriver.set(driver);
    }

    public static void unset() {
        threadLocalDriver.remove();
    }

    public static void destroyLocalDriver(){
        System.out.println("destroyLocalDriver1");
        if(!WebDriverManager.threadLocalDriverEmpty()) {
            System.out.println("destroyLocalDriver2");
            threadLocalDriver.get().quit();
        }
        WebDriverManager.unset();
    }
}


