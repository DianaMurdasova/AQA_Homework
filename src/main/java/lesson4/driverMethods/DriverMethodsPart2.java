package lesson4.driverMethods;

import driver_factory.DriverSetUp;
import org.openqa.selenium.WebDriver;

public class DriverMethodsPart2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();

        //driver.getCurrentUrl()
        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        //driver.getTitle()
        //driver.getPageSource()
/*        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Thread.sleep(2000);*/
        driver.get("https://uhomki.prom.ua/ua/");
        Thread.sleep(2000);
        System.out.println("======================");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println("======================");
        //System.out.println(driver.getPageSource());

        //navigate()
        driver.navigate().to("https://dan-it.com.ua/uk/");
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.quit();



    }
}
