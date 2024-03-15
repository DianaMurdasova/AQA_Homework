package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntegrationForSelenium2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        try{
            driver.findElement(By.xpath("//div[text()='Принять все']")).click();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        Thread.sleep(1500);
        driver.quit();

    }
}
