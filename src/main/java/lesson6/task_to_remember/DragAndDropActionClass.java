package lesson6.task_to_remember;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActionClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.ibuongiorno.com/about");
        Thread.sleep(5000);
        Actions actions = new Actions(driver);

        //type1 листаем сайт
        driver.findElement(By.tagName("h2")).click();
        for (int i = 0; i < 3; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
            Thread.sleep(1500);
        }
        Thread.sleep(1500);
        driver.quit();



    }
}
