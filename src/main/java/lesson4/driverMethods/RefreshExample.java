package lesson4.driverMethods;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RefreshExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://uhomki.prom.ua/ua/");
        WebElement searchField = driver.findElement(By.id("search_term"));
        searchField.sendKeys("Text");
        driver.findElement(By.cssSelector(".b-search__button")).click();
        Thread.sleep(2000);
        searchField = driver.findElement(By.id("search_term"));
        driver.findElement(By.id("search_term")).sendKeys("text2");
        searchField.sendKeys("text2");
        driver.findElement(By.cssSelector(".b-search__button")).click();
        Thread.sleep(5000);



    }
}
