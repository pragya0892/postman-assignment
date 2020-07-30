package com.postman.pages;

import com.postman.base.TestBase;
import com.postman.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Pragya
 */

public class ReadAllWorkspacePage extends TestBase {

    @FindBy(xpath="//div[@class='pm-ws-switcher']//button//i[@class = 'pm-icon pm-icon-sm pm-icon-secondary pm-btn__default-icon']")
    WebElement dropDown;

    //Initializing the Page Objects:
    public ReadAllWorkspacePage(){
        PageFactory.initElements(driver, this);
    }

    public ReadAllWorkspacePage readAll(){
        dropDown.click();
        return new ReadAllWorkspacePage();
    }

}
