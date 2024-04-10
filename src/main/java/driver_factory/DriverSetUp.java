package driver_factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverSetUp {
    public static WebDriver setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable notifications");
        options.addArguments("disable-gpu");
        //options.addArguments("--incognito"); // добавлять если нужно запустить страницу инкогнито
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        return driver;
    }

    public static void clickOnElement(WebDriver driver, By locator){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        driver.findElement(locator).click();
    }

    public static String getTextFromElement(WebDriver driver, By locator) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Element with locator " + locator + " not exist!!!");
        }
        return driver.findElement(locator).getText();
    }
}
