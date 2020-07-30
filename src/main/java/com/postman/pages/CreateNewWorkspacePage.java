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


public class CreateNewWorkspacePage extends TestBase {

    @FindBy(xpath="//button[contains(text(), 'Create a new workspace')]")
    WebElement createWorkspace;

    @FindBy(id="ws-name")
    WebElement Name;

    @FindBy(xpath="//button[contains(text(), 'Create Workspace')]")
    WebElement createWorkspaceButton;

    @FindBy(xpath="//span[text()='New']")
    WebElement verifyWorkspace;

    //Initializing the Page Objects:
    public CreateNewWorkspacePage(){
        PageFactory.initElements(driver, this);
    }

    public CreateNewWorkspacePage createNewWorkspace(){
        createWorkspace.click();
        Name.sendKeys("Workspace 1");
        createWorkspaceButton.click();

        return new CreateNewWorkspacePage();
    }

}
