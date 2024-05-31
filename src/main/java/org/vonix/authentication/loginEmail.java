package org.vonix.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.vonix.Config;

public class loginEmail extends Config {


    private static WebElement buttonLogin() {
        return driver.findElement(By.xpath("//button[normalize-space()='Login']"));
    }

    public WebElement publicButtonLogin() {
        WebElement buttonLogin  = buttonLogin();
        return buttonLogin;
    }

    private static WebElement fieldEmail() {
        return driver.findElement(By.xpath("//input[@name='email']"));
    }

    private static WebElement fieldPassword() {
        return driver.findElement(By.xpath("//input[@name='password']"));
    }

    private static WebElement buttonLoginPage() {
        return webDriverWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='vx-btn-md vx-btn-gradient bd-2 with-icon dark-mode btn-submit']"))));
    }


    private static String privateInputEmail() {
        return "zulma.sean84@gmail.com";
    }

    private static String privateInputPassword() {
        return "Vonix@2023";
    }

    public static WebElement textLoginSuccess() {
        return driver.findElement(By.xpath("//p[normalize-space()='Overview']"));
    }

    public static void stepLogin() throws InterruptedException {
        Config openBrowser = new Config();
        openBrowser.configureBrowser();
        buttonLogin().click();
        fieldEmail().sendKeys(privateInputEmail());
        fieldPassword().sendKeys(privateInputPassword());
        buttonLoginPage().click();
    }
}
