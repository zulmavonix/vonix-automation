package org.vonix.authentication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.vonix.Config;

public class LoginPhoneNumber extends Config {

    private static WebElement buttonLoginPhone() {
        return driver.findElement(By.xpath("//button[normalize-space()='Login with Phone Number']"));
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

    private static String inputPhoneNumber() { return "081373914540"; }

    public static void stepLoginPhoneNumber() {
        loginEmail buttonLogin  = new loginEmail();

        buttonLogin.publicButtonLogin().click();
        buttonLoginPhone().click();
        fieldPhoneNumber().sendKeys(inputPhoneNumber());
        buttonSendOTP().click();
    }
