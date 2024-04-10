package lesson7.waiters;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExampleThree {

    //явные ожидания
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        try {
            driver.get("https://www.guinnessworldrecords.com/Account/Login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            //elementToBeClickable
            //wait.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all"))).click();

            //presenceOfElementLocated
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search"))).click();
            //комплекс проверки загрузки страницы
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
            wait.until(ExpectedConditions.titleIs("Search Results | Guinness World Records"));
            wait.until(ExpectedConditions.titleContains("Results | Guinness"));
            wait.until(ExpectedConditions.urlToBe("https://www.guinnessworldrecords.com/search?term=%2A"));
            driver.findElement(By.id("search-term")).sendKeys("Text");
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
    }

}
