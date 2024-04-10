package lesson6.task_to_remember;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

public class HoverActionClass {
    public static void main(String[] args) {
 /*
        Открыть страницу https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/
        навести курсор на "RECORDS", навести курсор на "APPLY TO SET OR BREAK A RECORD", открыть "Standard Applications"
        в новой вкладке. Перейти на новую вкладку и вывести в консоль название страницы.
        */
        WebDriver driver = DriverSetUp.setUpDriver();
        Actions actions = new Actions(driver);

        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Set<String> strings1 = driver.getWindowHandles();
        actions
                .moveToElement(driver.findElement(By.xpath("//a[@href='/records/']")))
                .moveToElement(driver.findElement(By.xpath("//a[@href='/records/apply-to-set-or-break-a-record/']")))
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.CONTROL)
                .moveToElement(driver.findElement(By.xpath("//img[@alt='Standard Applications']")))
                .pause(Duration.ofSeconds(2))
                .click()
                .keyUp(Keys.CONTROL)
                .build().perform();

        Set<String> strings2 = driver.getWindowHandles();
        strings2.removeAll(strings1);
        driver.switchTo().window(strings2.iterator().next());
        System.out.println(driver.getTitle());

        driver.quit();

    }
}
