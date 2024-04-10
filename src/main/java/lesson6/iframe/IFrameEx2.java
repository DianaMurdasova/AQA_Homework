package lesson6.iframe;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class IFrameEx2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe_frameborder_css");
        Thread.sleep(2300);
        try {
            driver.findElement(By.id("accept-choices")).click();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        driver.switchTo().frame("iframeResult");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"/default.asp\"][2]")));

        try {
            driver.findElement(By.id("accept-choices")).click();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        Thread.sleep(1500);
        driver.findElement(By.id("tnb-google-search-mobile-show")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("tnb-google-search-input")).sendKeys("AQA");
        driver.findElement(By.id("tnb-google-search-input")).sendKeys(Keys.ENTER);
        Thread.sleep(2500);
        driver.quit();





    }
}
