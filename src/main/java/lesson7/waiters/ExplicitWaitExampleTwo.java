package lesson7.waiters;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExampleTwo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(15));

        //elementToBeClickable
        waiter.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all"))).click();
        //elementToBeSelected
        waiter.until(ExpectedConditions.elementToBeSelected(By.id("RememberMe")));
        driver.findElement(By.id("Password")).sendKeys("Password");
        //elementSelectionStateToBe
        waiter.until(ExpectedConditions.elementSelectionStateToBe(By.id("RememberMe"), false));
        driver.findElement(By.id("Username")).sendKeys("Text");
        //textToBePresentInElementValue
        waiter.until(ExpectedConditions.textToBePresentInElementValue(By.id("Username"), "QA"));
        driver.findElement(By.id("Password")).clear();
        Thread.sleep(3000);
        driver.quit();
    }
}
