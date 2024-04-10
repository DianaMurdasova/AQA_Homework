package lesson5.additional;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementMethodClass {
    public static void main(String[] args) {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        WebElement checkBox = driver.findElement(By.id("RememberMe"));

        try{
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (NoSuchElementException e){
            System.out.println("element not found!!!");
        }

        System.out.println("======BEFORE CLICK=======");
        System.out.println(checkBox.isDisplayed());
        System.out.println(checkBox.isSelected());
        System.out.println(checkBox.isEnabled());

        checkBox.click();

        System.out.println("======AFTER CLICK=============");
        System.out.println(checkBox.isDisplayed());
        System.out.println(checkBox.isSelected());
        System.out.println(checkBox.isEnabled());

        driver.quit();
    }
}
