package lesson6.iframe;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class IFrameEx1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://demoqa.com/nestedframes");

        try {
            driver.findElement(By.cssSelector(".fc-cta-consent")).click();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
        System.out.println(driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.quit();



    }
}
