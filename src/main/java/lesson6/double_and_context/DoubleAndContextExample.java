package lesson6.double_and_context;

import driver_factory.DriverSetUp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleAndContextExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Thread.sleep(3000);
        //ловим cookies
//        try{
//            driver.switchTo().frame("gdpr-consent-notice");
//            DriverSetUp.clickOnElement(driver, By.id("save"));
//            driver.switchTo().defaultContent();}
//        catch (NoSuchWindowException e){
//            System.out.println("No such window with cookies!");
//        }
        //
        Actions actions = new Actions(driver);
        actions
                .contextClick(driver.findElement(By.xpath("//span[contains(@class,'context-menu-one')]"))).perform();

        DriverSetUp.clickOnElement(driver, By.cssSelector(".context-menu-icon-quit"));
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(1000);

        actions.doubleClick(driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"))).perform();
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(1000);
        System.out.println("===========");

        System.out.println(DriverSetUp.getTextFromElement(driver, By.cssSelector(".context-menu-one")));
        System.out.println(DriverSetUp.getTextFromElement(driver, By.xpath("//button[@ondblclick='myFunction()']")));

        driver.quit();


    }
}
