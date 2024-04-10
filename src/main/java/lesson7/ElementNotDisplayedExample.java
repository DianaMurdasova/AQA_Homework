package lesson7;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementNotDisplayedExample {
    static boolean elementNotDisplayed(WebDriver driver, By locator){
        List<WebElement> webElementList = driver.findElements(locator);
        return webElementList.isEmpty();
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(15));
       // waiter.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all"))).click();

        waiter.until(ExpectedConditions.presenceOfElementLocated(By.id("search"))).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
        waiter.until(ExpectedConditions.urlToBe("https://www.guinnessworldrecords.com/search?term=%2A"));
        driver.findElement(By.id("search-term")).sendKeys("Text");
        Thread.sleep(3000);
        // findElements озвращает лист с такими локаторами, если они не обнаружены размер листа = 0
        List<WebElement> list = driver.findElements(By.xpath("(//button[@type='submit'])[2]"));
        if (list.size() != 0) {
            System.out.println("Test failed!!! Element is still displayed");
        } else {
            System.out.println("Test passed!!!");
        }

        System.out.println("Is element not displayed on the page? \n" + elementNotDisplayed(driver, By.id("bestId")));
        System.out.println("Is element not displayed on the page? \n" + elementNotDisplayed(driver, By.id("search-term")));
        driver.quit();


    }
}
