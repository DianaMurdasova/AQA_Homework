package lesson4;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreconditionClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://uhomki.prom.ua/ua/");
        Thread.sleep(2000);
        String textFromElement = driver.findElement(By.cssSelector(".b-title span")).getText();
        // .b-title(класс) span(подкласс) - строка заголовок на странице
        System.out.println(textFromElement);
        driver.quit();
    }
}
