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

public class DeleteWorkspacePage extends TestBase {

    @FindBy(xpath = "(//div[@class = 'workspace-actions']//descendant::div[@class='trigger' and @role = 'button'])[2]")
    WebElement ellipsis;

    @FindBy(xpath = "(//div[@class = 'workspace-actions']//descendant::div[@class='trigger' and @role = 'button'])[1]")
    WebElement defaultEllipsis;

    @FindBy(xpath = "//div[text()='Delete']")
    WebElement delete;

    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteWorkspace;

    //Initializing the Page Objects:
    public DeleteWorkspacePage() {
        PageFactory.initElements(driver, this);
    }

    public DeleteWorkspacePage delete() {
        ellipsis.click();
        delete.click();
        deleteWorkspace.click();
        WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathConstants.DELETE_MESSAGE)));
        return new DeleteWorkspacePage();
    }

    public DeleteWorkspacePage deleteDefault() {
        defaultEllipsis.click();
        delete.click();
        return new DeleteWorkspacePage();
    }
}