package org.vonix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.vonix.authentication.ForgotPassword;
import org.vonix.authentication.RegisterEmail;
import org.vonix.authentication.loginEmail;

public class VonixTest extends Config {
    @Test
    public void loginEmailTest() throws InterruptedException {
        loginEmail.stepLogin();
        String getTextSuccess = loginEmail.textLoginSuccess().getText();
            if ("Overview".equals(getTextSuccess)) {
                Assert.assertTrue(true);
                System.out.println("Test Case Login Success");
                quitDriver();
            }else {
                quitDriver();
                Assert.fail("Test Case Failed because " + getTextSuccess + " Not Found");
            }
//        Assert.assertEquals(getTextSuccess,"Overview");
//        quitDriver();
    }

    @Test
    public void registerTest() throws InterruptedException {
        RegisterEmail.stepRegister();
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
        ForgotPassword.stepForgotPassword();
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
}
