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

/**
 * @author Pragya
 */

public class UpdateWorkspacePage extends TestBase {

    @FindBy(xpath = "(//div[@class = 'workspace-actions']//descendant::div[@class='trigger' and @role = 'button'])[2]")
    WebElement ellipsis;

    @FindBy(xpath = "//div[text()='Rename']")
    WebElement rename;

    @FindBy(id = "ws-name")
    WebElement name;

    @FindBy(xpath = "//button[text()='Save Changes']")
    WebElement saveChange;

    @FindBy(xpath = "//span[text()='Workspace 2']")
    WebElement workspaceName;

    //Initializing the Page Objects:
    public UpdateWorkspacePage() {
        PageFactory.initElements(driver, this);
    }

    public UpdateWorkspacePage update() {
        ellipsis.click();
        rename.click();
        name.clear();
        name.sendKeys("Workspace 2");
        saveChange.click();
        WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathConstants.GET_UPDATED_WORKSPACE)));
        return new UpdateWorkspacePage();
    }
}
