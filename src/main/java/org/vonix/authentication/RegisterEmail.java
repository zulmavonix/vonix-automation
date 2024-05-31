package org.vonix.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.vonix.Config;

public class RegisterEmail extends Config {

    private static WebElement buttonRegister() {
        return driver.findElement(By.xpath("//button[normalize-space()='Register']"));
    }

    private static WebElement buttonAgreeRegister() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("(//button[@type='button'])[2]"))));
    }

    private static WebElement scrollRegister() {
        return driver.findElement(By.xpath("(//a[@href='mailto:support@vonix.id'])[6]"));
    }

    private static JavascriptExecutor scrollRegisterJE() {
        JavascriptExecutor js   = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scrollRegister());
        return js;
    }

    private static WebElement fieldDisplayName() {
        return driver.findElement(By.xpath("(//input[@class='vx-input'])[1]"));
    }

    private static WebElement fieldEmailRegister() {
        return driver.findElement(By.xpath("(//input[@class='vx-input vx-error'])[1]"));
    }

    private static WebElement fieldPasswordRegister() {
        return driver.findElement(By.xpath("(//input[@type='password'])"));
    }

    private static WebElement errorMessage() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//span[@class='vx-input-error-message']"))));
    }

    private static WebElement buttonCreateAccount() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//button[@data-test='btn-submit']"))));
    }

    public static WebElement successRegister() {
        return driver.findElement(By.xpath("//p[@class='register-email__pending__title']"));
    }

    private static String inputDisplayName() { return "Zulma Sean"; }

    private static String inputEmailRegister() { return "zulma.irzamsyah+automation17@vonix.id"; }

    private static String inputPasswordRegister() { return "Vonix@2023"; }

    public static void stepRegister() throws InterruptedException {
        Config openBrowser = new Config();
        openBrowser.configureBrowser();

        buttonRegister().click();
        scrollRegisterJE();
        buttonAgreeRegister().click();
        fieldDisplayName().sendKeys(inputDisplayName());
        errorMessage().isEnabled();
        fieldEmailRegister().click();
        fieldEmailRegister().sendKeys(inputEmailRegister());
        fieldPasswordRegister().sendKeys(inputPasswordRegister());
        buttonCreateAccount().click();
        Thread.sleep(10000);
    }
}
