package lesson5.drag_n_drop;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class DragAndDropEx1 {

    public static void dragNDropIt(By source, By target, WebDriver driver){ //собственный метод dragNdrop
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(source))
                .pause(Duration.ofSeconds(2))
                .clickAndHold()
                .pause(Duration.ofSeconds(2))
                .moveToElement(driver.findElement(target))
                .pause(Duration.ofSeconds(2))
                .release().build().perform();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        Actions actions = new Actions(driver);
        driver.get("https://www.signesduquotidien.org/");

        // buttons
        By centralButton = By.id("menu-btn");
        By courrier = By.xpath("//div[@data-title='Courrier']");
        By projets = By.xpath("//div[@data-title='Projets']");
        By propos = By.xpath("//div[@data-title='À propos']");


        Thread.sleep(4000);
        driver.findElement(centralButton).click();
        Thread.sleep(4000);
        actions
                .clickAndHold(driver.findElement(courrier))         //зажимаем элемент
                .moveToElement(driver.findElement(centralButton))   //передвигаем к таргету
                .release()                                          // отпускаем захваченный элемент
                .build().perform();

        Thread.sleep(2000);

        driver.get("https://www.signesduquotidien.org/");
        Thread.sleep(4000);
        driver.findElement(centralButton).click();
        Thread.sleep(2000);
        actions.dragAndDrop(driver.findElement(projets), driver.findElement(centralButton)).perform(); //метод для перетаскивания dragAndDrop
        Thread.sleep(2000);

        driver.get("https://www.signesduquotidien.org/");
        Thread.sleep(4000);
        driver.findElement(centralButton).click();
        Thread.sleep(2000);
        dragNDropIt(propos,centralButton,driver);
        Thread.sleep(2000);

        driver.quit();








    }



}
