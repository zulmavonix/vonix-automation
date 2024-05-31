package org.vonix.transaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.vonix.Config;
import org.vonix.authentication.loginEmail;

public class EasyTradeBuy extends Config {

    private static WebElement buttonEasyTradeDashboard() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//button[normalize-space()='Easy Trade']"))));
    }

    private static WebElement dropDownSelectCoin() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//div[@class='content__select-pair']"))));
    }

    private static WebElement selectCoin() {
        String nameCoin = "AAVE";
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//span[normalize-space()='" + nameCoin + "']")));
    }


    public static void stepEasyTradeBuy() throws InterruptedException {
        Config openBrowser  = new Config();
        openBrowser.configureBrowser();

        loginEmail.stepLogin();
        buttonEasyTradeDashboard().click();
        dropDownSelectCoin().click();
        selectCoin().click();
    }
}
