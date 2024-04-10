package lesson8.parallel.methods;

import driver_factory.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Methods {
    @Test
    public void f(){
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        driver.quit();
    }

    @Test
    public void d(){
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        driver.quit();
    }

    @Test
    public void c(){
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        driver.quit();
    }

    @Test
    public void e(){
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        driver.quit();
    }

    @Test
    public void b(){
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        driver.quit();
    }

    @Test
    public void a(){
        Assert.assertTrue(true);
    }
}
