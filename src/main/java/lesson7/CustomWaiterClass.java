package lesson7;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class CustomWaiterClass {
    private final WebDriver driver;

    public CustomWaiterClass(WebDriver driver) {
        this.driver = driver;
    }

    private FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchFrameException.class);
    } // метод который возвращает настроенный объект для свободного ожидания

    private void waitForFunction(Function function) {
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(function);
    } // метод который будет ожидать функцию

    //visibilityOfElementLocated
    public WebElement waitForVisibilityOfElementLocated(By locator) {
        return fluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //frameToBeAvailableAndSwitchToIt
    public void waitForFrameAndSwitch(By locator) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    //alertIsPresent
    public Alert waitForAlertAndSwitch() {
        return fluentWait().until(ExpectedConditions.alertIsPresent());
    }
}
