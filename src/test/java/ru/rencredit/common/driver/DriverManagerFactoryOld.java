package ru.rencredit.common.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManagerFactoryOld {

    private static WebDriver driver;



    protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    protected static WebDriver createDriver() {
        System.out.println("Create Chrome Driver");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gloctarr\\IdeaProjects\\rencredit\\src\\main\\resources\\drivers\\chromedriver.exe");
        return new ChromeDriver(getChromeOptions());
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");

        return options;
    }

    public static void quitDriver() {
        if(driver != null) {
            try {
                driver.quit();
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static WebDriver getDriver(String DriverName) {

        if(driver == null) {
            driver  = createDriver();
        }
        driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        return driver;
    }

}


