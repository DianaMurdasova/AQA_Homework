package lesson8.parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson7.CustomWaiterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {
    static WebDriver driver;
    @BeforeClass
    @Parameters({"browser_type"}) // не обязательно чтобы параметр и пересенная одинаково назывались
    public void preconditions(String browser){
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
    }
    @AfterClass
    public void postConditions(){
        driver.quit();
    }

    @Test
    public void loginNegativeTest(){
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        CustomWaiterClass wait = new CustomWaiterClass(driver);
        wait.waitForVisibilityOfElementLocated(By.id("email")).sendKeys("mail");
        driver.findElement(By.id("passwd")).sendKeys("passwd");
        driver.findElement(By.id("SubmitLogin")).click();
        wait.waitForVisibilityOfElementLocated(By.cssSelector(".alert.alert-danger"));
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-danger p")).getText(),
                "There is 1 error");
        driver.quit();
    }
}
