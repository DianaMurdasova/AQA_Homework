package driver_factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetUp3 {
    private static WebDriver driver;
    private static WebDriver setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-gpu");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
    private static WebDriver getInstance(){
        if (driver == null){
            try {
                driver = setUpDriver();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return driver;
    }

    public static WebDriver startDriver(){
        driver = getInstance();
        return driver;
    }
}
