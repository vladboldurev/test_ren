package ru.rencredit.common.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ThreadGuard;

public enum WebDriverFactory {
    CHROME{
        public WebDriver getWebDriver() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\gloctarr\\IdeaProjects\\rencredit\\src\\main\\resources\\drivers\\chromedriver.exe");
            ChromeOptions options = (ChromeOptions) getOptions();
            return ThreadGuard.protect(new ChromeDriver(options));
        }

        public MutableCapabilities getOptions() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-features=EnableEphemeralFlashPermission");
            options.addArguments("--disable-infobars");
            return options;
        }
    },
    FIREFOX{
        public WebDriver getWebDriver() {
            FirefoxOptions options = (FirefoxOptions) getOptions();
            return ThreadGuard.protect(new FirefoxDriver(options));
        }

        public MutableCapabilities getOptions() {
            FirefoxOptions options = new FirefoxOptions();
            return options;
        }
    };


    public abstract WebDriver getWebDriver();

    public abstract MutableCapabilities getOptions();
}

