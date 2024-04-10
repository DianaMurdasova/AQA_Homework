package lesson5.additional;

import driver_factory.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class OpenNewWindowAndTabClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://uhomki.prom.ua/ua/");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://rozetka.com.ua/");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.automationpractice.pl/index.php");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);

        driver.close();

        Thread.sleep(3000);

        driver.quit();
    }


}
