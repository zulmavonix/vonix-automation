package org.vonix;

import org.junit.Assert;
import org.junit.Test;
import org.vonix.authentication.ForgotPassword;
import org.vonix.authentication.LoginPhoneNumber;
import org.vonix.authentication.RegisterEmail;
import org.vonix.authentication.loginEmail;
import org.vonix.transaction.EasyTradeBuy;

public class VonixTest extends Config {

    private static String inputEmail() {
        return "hariyanto.iyan@vonix.id";
    }

    private static String inputPassword() {
        return "Vonix1234!";
    }
    @Test
    public void loginEmailTest() throws InterruptedException {

        String Email        = inputEmail();
        String Password     = inputPassword();

        loginEmail.stepLogin(Email, Password);
        String getTextSuccess = loginEmail.textLoginSuccess().getText();
            if ("Overview".equals(getTextSuccess)) {
                Assert.assertTrue(true);
                System.out.println("Test Case Login Success");
                quitDriver();
            }else {
                quitDriver();
                Assert.fail("Test Case Failed because " + getTextSuccess + " Not Found");
            }
    }

    @Test
    public void registerTest() throws InterruptedException {

        String DisplayName      = "Zulma Sean";
        String EmailRegister    = "zulma.irzamsyah+automation210@vonix.id";
        String PasswordRegister = "Vonix@2023";

        RegisterEmail.stepRegister(DisplayName, EmailRegister, PasswordRegister);
        String getTextSuccess = RegisterEmail.successRegister().getText();
            if ("Email Verification Required!".equals(getTextSuccess)) {
                Assert.assertTrue(true);
                System.out.println("Test Case Register Success");
                quitDriver();
            }else {
                quitDriver();
                Assert.fail("Test Case Register Failed because " + getTextSuccess + " Not Found");
            }
    }

    @Test
    public void forgotPasswordTest() throws InterruptedException {

        String Email    = "zulma.sean84@gmail.com";

        ForgotPassword.stepForgotPassword(Email);
        String getTextForgotSuccess = ForgotPassword.textForgotSuccess().getText();
            if ("Check Your Email!".equals(getTextForgotSuccess)) {
                Assert.assertTrue(true);
                System.out.println("Test Case Forgot Password Success");
                quitDriver();
            }else {
                quitDriver();
                Assert.fail("Test Case Forgot Password Failed because " + getTextForgotSuccess + " Not Found");
            }
    }

    
    @Test
    public void loginPhoneNumberTest() throws InterruptedException {

        String PhoneNumber  = "081373914540";

        LoginPhoneNumber.stepLoginPhoneNumber(PhoneNumber);
        String getTextKodeOTP   = LoginPhoneNumber.textEnterOTP().getText();
            if ("Please enter the OTP".equals(getTextKodeOTP)) {
                Assert.assertTrue(true);
                System.out.println("Test Case Login Phone Number Success");
                quitDriver();
            }else {
                quitDriver();
                Assert.fail("Test Case Login Phone Number Failed because " + getTextKodeOTP + " Not Found");
            }
    }

    @Test
    public void easyTradeBuyTest() throws InterruptedException {

        String nameCoin     = "Sol";
        String amountCoin   = "0.3";
        String Email        = inputEmail();
        String Password     = inputPassword();

        for(int i=1; i<5; i++) {
            EasyTradeBuy.stepEasyTradeBuy(nameCoin,amountCoin, Email, Password);
            quitDriver();
        }
    }
}
