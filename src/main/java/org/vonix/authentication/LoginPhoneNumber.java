package org.vonix.authentication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.vonix.Config;

public class LoginPhoneNumber extends Config {

    private static WebElement buttonLoginPhone() {
        return webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath("//button[normalize-space()='Login with Phone Number']"))));
    }

    private static WebElement fieldPhoneNumber() {
        return driver.findElement(By.xpath("//input[@class='vti__input']"));
    }

    private static WebElement buttonSendOTP() {
        return driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
    }

    public static WebElement textEnterOTP() {
        return driver.findElement(By.xpath("//h1[normalize-space()='Please enter the OTP']"));
    }

    private static String inputPhoneNumber() {
        return "081373914540";
    }

    public static void stepLoginPhoneNumber() throws InterruptedException {
        Config openBrowser = new Config();
        openBrowser.configureBrowser();
        loginEmail buttonLogin = new loginEmail();

        buttonLogin.publicButtonLogin().click();
        Thread.sleep(5000);
        buttonLoginPhone().click();
        fieldPhoneNumber().sendKeys(inputPhoneNumber());
        buttonSendOTP().click();
    }
}
