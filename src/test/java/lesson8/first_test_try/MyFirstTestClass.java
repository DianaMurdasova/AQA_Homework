package lesson8.first_test_try;

import driver_factory.DriverSetUp;
import lesson7.CustomWaiterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyFirstTestClass {

    static WebDriver driver;
    @BeforeClass
    public void setUpDriver(){
        driver = DriverSetUp.setUpDriver();
    }
    @AfterClass
    public void killDriver(){
        driver.quit();
    }
    @Test
    public void myFirstTest(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        String textForSending = "Handstand";
        new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.id("search-term"))
                .sendKeys(textForSending);
        Assert.assertTrue(driver.findElement(By.id("search-term")).isDisplayed());
        driver.findElement(By.id("search-button")).click();
        new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.tagName("h2"));
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains(textForSending)
                , "The search results is incorrect");
        Assert.assertFalse(driver.findElement(By.tagName("h2")).getText().contains("textForSending")
                , "The search results is correct");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        Assert.assertNotEquals(driver.getTitle(), "Search Results | Guinness Worled Records");
    }

    @Test
    public void mySecondTest(){
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        String textForSending = "Handstand";
        new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.id("search-term"))
                .sendKeys(textForSending);
        Assert.assertTrue(driver.findElement(By.id("search-term")).isDisplayed());
        driver.findElement(By.id("search-button")).click();
        new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.tagName("h2"));
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains(textForSending)
                , "The search results is incorrect");
        Assert.assertFalse(driver.findElement(By.tagName("h2")).getText().contains("textForSending")
                , "The search results is correct");
        Assert.assertEquals(driver.getTitle(), "Search Results | Guinness World Records");
        Assert.assertNotEquals(driver.getTitle(), "Search Results | Guinness Worled Records");
    }

}
