package lesson7.waiters;

import driver_factory.DriverSetUp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class FluentWaitClass {

    public static void main(String[] args) {
        //Свободные ожидания
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)) //время ожидания
                .pollingEvery(Duration.ofSeconds(1)) //частота проверки, тут каждые 1 секунду
                .ignoring(NoSuchElementException.class) //какие будем игнорировать классы исключений
                .ignoring(ElementNotInteractableException.class) //игнор
                .ignoring(InvalidElementStateException.class) //игнор
                .ignoring(NoAlertPresentException.class) //игнор
                .ignoring(NoSuchFrameException.class); //игнор
        //visibilityOfElementLocated
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices"))).click();
    }

}
