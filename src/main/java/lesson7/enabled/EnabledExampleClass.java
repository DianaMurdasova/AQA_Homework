package lesson7.enabled;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnabledExampleClass {
    public static void main(String[] args) {
        WebDriver driver = DriverSetUp.setUpDriver();
        //тут учитываем что файл на локальном нашем пк
        String htmlFilePath = "C:\\Users\\anduser\\Desktop\\additional\\Enabled\\Enabled.html";
        driver.get("file:///" + htmlFilePath);
        System.out.println("Before click element enabled? " +
                driver.findElement(By.id("button")).isEnabled());
        driver.findElement(By.id("enableButton")).click();
        System.out.println("After click element enabled? " +
                driver.findElement(By.id("button")).isEnabled());
        driver.quit();


    }
}
