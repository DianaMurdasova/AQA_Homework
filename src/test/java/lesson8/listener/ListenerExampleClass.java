package lesson8.listener;

import driver_factory.DriverSetUp3;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners;

@Listeners(MyTestListeners.class)
public class ListenerExampleClass {
    static WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = DriverSetUp3.startDriver();
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
    @Test
    public void f(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Resudlts | Guinness World Records");
    }

    @Test
    public void d(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Searcоh Results | Guinness World Records");
    }

    @Test
    public void c(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void g(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Rjesults | Guinness World Records");
    }

    @Test
    public void e(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void b(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
    }

    @Test
    public void a(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Assert.assertEquals(driver.getTitle(), "Search Reesults | Guinness World Records");
    }
}
