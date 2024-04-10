package lesson6;

import driver_factory.DriverSetUp;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ScrollExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        By acceptCookies = By.id("ez-accept-all");
        Thread.sleep(4000);
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");

        try {
            driver.findElement(acceptCookies).click();
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -500)");

        Thread.sleep(4000);
        for (int i = 0; i < 100; i++) {
            new Actions(driver)
                    .sendKeys(Keys.ARROW_DOWN)
                    .perform();
        }
        Thread.sleep(4000);

        driver.quit();


    }
}
