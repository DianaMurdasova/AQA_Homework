package lesson8.parallel.suites;

import driver_factory.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ClassC {
    static WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.setUpDriver();
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
    @Ignore
    @Test
    public void f(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void d(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test(enabled = false)
    public void c(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test(dependsOnMethods = {"a", "b"}, alwaysRun = true)
    public void e(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test()
    public void b(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void a(){
        Assert.assertTrue(false);
    }
}
