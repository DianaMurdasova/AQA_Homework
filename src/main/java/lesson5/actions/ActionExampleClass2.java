package lesson5.actions;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class ActionExampleClass2 {
    public static void goToMainPage(WebDriver driver){
        driver.get("https://dan-it.com.ua/uk/");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://dan-it.com.ua/uk/");
        Actions actions = new Actions(driver);

        //moveToElement with offSet
//        actions.moveToElement(driver.findElement(By.xpath("(//a[contains(@href,'adults/')][@class='header__nav-item-link'])[1]"))).perform();
//        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Програмування']"))).perform();
//        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Java']")), 0, 41).click().build().perform();
//        System.out.println(driver.getTitle());

        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Курси']"))).click()
         .click(driver.findElement(By.xpath("//a[text()='Java']"))).perform();
             Thread.sleep(2000);

        goToMainPage(driver);

        Set<String> strings1 = driver.getWindowHandles();

        actions
                .moveToElement(driver.findElement(By.xpath("//a[text()='Курси']"))).click()
                .keyDown(Keys.CONTROL)
                .click(driver.findElement(By.xpath("//a[text()='Java']")))
                .keyUp(Keys.CONTROL)
                .build().perform();


        Set<String> strings2 = driver.getWindowHandles();
        strings2.removeAll(strings1);
        driver.switchTo().window(strings2.iterator().next());


        System.out.println(driver.getTitle());

        driver.quit();







    }
}
