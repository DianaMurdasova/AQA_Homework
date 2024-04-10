package lesson6.task_to_remember;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActionClass2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.ibuongiorno.com/about");
        Thread.sleep(6000);
        Actions actions = new Actions(driver);
        for (int i = 0; i < 3; i++) {
            actions.moveToElement(driver.findElement(By.xpath("//a[@href='/en']")), 0, 50)
                    .clickAndHold()
                    .moveToElement(driver.findElement(By.xpath("//img[contains(@alt,'Buongiorno')]")))
                    .release()
                    .build().perform();
            Thread.sleep(1500);
        }
        Thread.sleep(1500);
        driver.quit();
    }
}
