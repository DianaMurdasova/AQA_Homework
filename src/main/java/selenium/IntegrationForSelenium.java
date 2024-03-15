package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IntegrationForSelenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.drive","C:\\QA\\chromedriver-win64.chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\QA\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Принять все']")).click();
        driver.quit();

    }
}
