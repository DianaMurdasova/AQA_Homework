package selenium;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntegrationForSeleniumDriverSetUp {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(1500);
        try {
            driver.findElement(By.xpath("//div[text()='Принять все']")).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(1500);
        driver.quit();
    }
}
