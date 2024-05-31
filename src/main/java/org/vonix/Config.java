package org.vonix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Config {

    public static WebDriver driver;

    public static void getDriver() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/zulma/Documents/Vonix/web-automation/browserdriver/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--force-dark-mode");
        driver = new ChromeDriver(options);
    }

    public static WebDriverWait webDriverWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }


    String dev  = "https://dev.vonix.id/";
    String prod = "https://vonix.id/";

    public void configureBrowser() {
        getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prod);
    }

    public void quitDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}