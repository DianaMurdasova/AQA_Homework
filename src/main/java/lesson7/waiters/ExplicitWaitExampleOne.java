package lesson7.waiters;

import driver_factory.DriverSetUp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExampleOne {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));

        //visibilityOfElementLocated
        //waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices"))).click();

        //frameToBeAvailableAndSwitchToIt
        waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        driver.findElement(By.xpath("//button[@onclick=\"myFunction()\"]")).click();

        //alertIsPresent
        Alert alert = waiter.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(3000);
        driver.quit();

    }
}
