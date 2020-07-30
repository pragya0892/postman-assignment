package com.postman.pages;

import com.postman.base.TestBase;
import com.postman.constant.XpathConstants;
import com.postman.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Pragya
 */

public class LoginPage extends TestBase {

    @FindBy(id="username")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="sign-in-btn")
    WebElement signIn;

    @FindBy(xpath="//a[text()='Switch accounts']")
    WebElement switchAccount;

    @FindBy(xpath="//div[@class='pm-icon-proceed pm-icon-sm']")
    WebElement proceed;

    //Initializing the Page Objects:
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public LoginPage login(){
        userName.sendKeys("pragya0892@gmail.com");
        password.sendKeys("Crestech@1234");
        signIn.click();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        switchAccount.click();
        proceed.click();
        return new LoginPage();
    }

}
