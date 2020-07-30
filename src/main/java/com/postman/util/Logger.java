package com.postman.util;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import extentReportListener.ExtentTestManager;
import org.testng.Reporter;

public class Logger {

    public synchronized void log(String message)
    {
        if(ExtentTestManager.getTest()==null)
        {
            ExtentTestManager.startTest("RunningSingleClass");
        }
        ExtentTestManager.getTest().log(Status.INFO,message);
        Reporter.log(message,1, true);

    }

}

