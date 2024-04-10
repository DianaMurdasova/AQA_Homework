package lesson5.select;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Select2Class {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        Thread.sleep(2000);
        driver.get("https://automationpractice.pl/index.php?id_product=1&controller=product");
        new Select(driver.findElement(By.id("group_1"))).selectByVisibleText("M");
        Thread.sleep(2000);
        driver.quit();

    }
}
