package com.postman.test;


import com.postman.base.TestBase;
import com.postman.constant.StringConstants;
import com.postman.constant.XpathConstants;
import com.postman.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import com.postman.util.Logger;

/**
 * @author Pragya
 *
 * I have create only happy flow test cases along with assertion, there are many scenarios can be added in the script
 * All the test cases are indivisual, every time I am logging in to run the test
 *
 */

public class CRUDTest extends TestBase {
    LoginPage login;
    CreateNewWorkspacePage createNewWorkspacePage;
    UpdateWorkspacePage updateWorkspacePage;
    DeleteWorkspacePage deleteWorkspacePage;
    Logger logger = new Logger();

    @BeforeMethod
    public void setUp() throws Exception {
        initialization();
        getUrl();
        login = new LoginPage();
        login.login();
    }

    // I am creating only personal workspace not the team type, flow would be same for both
    @Test(priority=1)
    public void createNewWorkspace()
    {
        logger.log("This test case is to create new workspace");
        createNewWorkspacePage = new CreateNewWorkspacePage();
        createNewWorkspacePage.createNewWorkspace();
        WebElement verifyWorkspace = driver.findElement(By.xpath(XpathConstants.VERIFY_WORKSPACE));
        WebElement successMessage = driver.findElement(By.xpath(XpathConstants.SUCCESS_MESSAGE));
        Assert.assertEquals(successMessage.getText(), StringConstants.SUCCESS_MESSAGE);
        Assert.assertEquals(verifyWorkspace.getText(),StringConstants.WORKSPACE_1);
    }

    @Test(priority=2)
    public void readListOfWorkspace()
    {
        logger.log("This test case is to read all workspaces");
        List<WebElement> wb = driver.findElements(By.xpath(XpathConstants.GET_LIST_WORKSPACE));
        for(int i=0;i<wb.size();i++)
            System.out.println(wb.get(i).getText());
    }

    @Test(priority=3)
    public void updateWorkspace()
    {
        logger.log("This test case is to update workspace");
        updateWorkspacePage = new UpdateWorkspacePage();
        updateWorkspacePage.update();
        WebElement wb = driver.findElement(By.xpath(XpathConstants.GET_UPDATED_WORKSPACE));
        Assert.assertEquals(wb.getText(),StringConstants.WORKSPACE_2);
    }

    // Below test is to check whether user can not delete the default workspace and other workspace can be deleted
    @Test(priority=4)
    public void deleteWorkspace()
    {
        logger.log("This test case is to delete newly created workspace and not to delete the default one");
        deleteWorkspacePage = new DeleteWorkspacePage();
        deleteWorkspacePage.deleteDefault();
        WebElement deleteButton = driver.findElement(By.xpath(XpathConstants.DISABLED_DELETE_MESSAGE));
        Assert.assertTrue(!deleteButton.isEnabled());
        driver.findElement(By.xpath(XpathConstants.CANCEL_BUTTON)).click();
        deleteWorkspacePage.delete();
        WebElement wb = driver.findElement(By.xpath(XpathConstants.DELETE_MESSAGE));
        Assert.assertEquals(wb.getText(),StringConstants.DELETE_MESSAGE);
    }

    @AfterMethod
    public void cleanUp() throws Exception {
        driver.close();
    }
}
