package utils;

import driver_factory.DriverSetUp3;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyAllureListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " started!!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(((TakesScreenshot) DriverSetUp3.startDriver()).getScreenshotAs(OutputType.BYTES));
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
