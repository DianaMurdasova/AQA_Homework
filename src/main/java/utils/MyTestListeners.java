package utils;

import driver_factory.DriverSetUp3;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyTestListeners implements ITestListener {

    public static void makeScreenshot(String method) {
        File screenshotFile = ((TakesScreenshot) DriverSetUp3.startDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("./target/screenshots_negative/" + method + ".png")); //путь, название метода, расширение файла
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void makeScreenshotPositive(String method) {
        File screenshotFile = ((TakesScreenshot) DriverSetUp3.startDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("./target/screenshots_positive/" + method + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Test with name " + result.getMethod().getMethodName()+" is started!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(org.testng.ITestResult result) { makeScreenshotPositive(result.getMethod().getMethodName()); }
}
