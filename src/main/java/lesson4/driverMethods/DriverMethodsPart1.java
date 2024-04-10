package lesson4.driverMethods;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DriverMethodsPart1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();

        // driver.findElements()
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Thread.sleep(2000);
        List<WebElement> webElementList = driver.findElements(By.cssSelector(".columned.block.block-4-12 a"));
        System.out.println("The total amount of elements is " + webElementList.size());
        for(WebElement element: webElementList){
            System.out.println(element.getText());
        }

        //manage()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie: cookies){
            System.out.println(cookie);
        }
        System.out.println("All amount of cookies is " + cookies.size());
        System.out.println("================");
        System.out.println("Separate cookie file " + cookies.toArray()[2]);
        driver.quit();



    }



}
