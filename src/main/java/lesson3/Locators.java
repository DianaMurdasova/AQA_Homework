package lesson3;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();

        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //By.id
        By locator = By.id("search");
        WebElement element = driver.findElement(locator);
        element.click();

        Thread.sleep(1500);

        driver.get("https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        Thread.sleep(1500);
        try{
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (NoSuchElementException e){
            System.out.println("element not found!!!");
        }
        //By.name
        driver.findElement(By.name("Username")).sendKeys("My firs text");
        Thread.sleep(1500);


        //By.linkText()
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Thread.sleep(1500);
        driver.findElement(By.linkText("APPLICATION PROCESS")).click();
        Thread.sleep(2000);

        //By.partialLinkText()
        driver.findElement(By.partialLinkText("CORDS SHOW")).click();
        Thread.sleep(2000);
        driver.quit();


    }
}
