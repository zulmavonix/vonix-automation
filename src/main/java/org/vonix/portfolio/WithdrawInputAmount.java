package org.vonix.portfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.vonix.Config;
import org.vonix.VonixTest;
import org.vonix.authentication.loginEmail;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Arrays;

public class WithdrawInputAmount extends Config {

    private static WebElement dropdownPortfolio() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("(//p[@class='dropdown-title'])[3]"))));
    }

    private static WebElement selectWithdraw() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("(//div[@class='menu-link'])[10]"))));
    }

    private static WebElement selectBankAccount() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//span[@aria-label='Select a Bank Account']"))));
    }

    private static WebElement chooseBank() throws IOException {
        String bankName = "";
        String bankAccount = "";
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'" + bankName + " - " + bankAccount + "')]"))));
    }

    private static WebElement inputWithdraw() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//input[@placeholder='0.00 USDT']"))));
    }

    private static WebElement buttonWithdraw() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//button[@name='button-withdraw']"))));
    }

    private static WebElement buttonConfirmWithdraw() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//button[normalize-space()='Confirm Withdrawal']"))));
    }

    private static WebElement buttonTransactionHistory() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//button[normalize-space()='Go to Transaction History']"))));
    }

    public static WebElement statusWithdraw() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("(//p[@class='success'])[1]"))));
    }

    public static void stepWithdraw(String Email, String Password) throws InterruptedException, IOException {

        try {

            loginEmail.stepLogin(Email, Password);
            System.out.println("Element found");

        }catch (NoSuchElementException e) {

            System.out.println("Element not found, refreshing browser");
            driver.navigate().refresh();
            loginEmail.stepLogin(Email, Password);

        }
            dropdownPortfolio().click();
            Thread.sleep(1000);
            selectWithdraw().click();
            Thread.sleep(1000);
            selectBankAccount().click();
            Thread.sleep(7000);
            chooseBank().click();
            inputWithdraw().sendKeys("2");
            Thread.sleep(2000);
            buttonWithdraw().click();
            Thread.sleep(2000);
            buttonConfirmWithdraw().click();
            Thread.sleep(2000);
            buttonTransactionHistory().click();
    }
}
