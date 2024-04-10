package lesson6.alerts;

import driver_factory.DriverSetUp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Alert1
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        Alert alertJsAlert = driver.switchTo().alert();//переключение на окно алерта

        System.out.println("Text fom alert is \""+alertJsAlert.getText()+"\"");
        alertJsAlert.accept();
        Thread.sleep(2000);
        boolean result = driver.findElement(By.id("result")).getText().equals("You successfully clicked an alert");
        if(result){
            System.out.println("Test passed!!");
        } else {
            System.out.println("Test failed!!");
        }
        System.out.println("===========================");

        //ALERT2
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(2000);
        Alert alertJsConfirm = driver.switchTo().alert();
        System.out.println("Text fom alert is \""+alertJsConfirm.getText()+"\"");
        alertJsConfirm.dismiss();
        result = driver.findElement(By.id("result")).getText().equals("You clicked: Cancel");
        if(result){
            System.out.println("Test passed!!");
        } else {
            System.out.println("Test failed!!");
        }
        System.out.println("===========================");

        //ALERT3
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        Alert alertJsPrompt = driver.switchTo().alert();
        System.out.println("Text fom alert is \""+alertJsPrompt.getText()+"\"");
        String text = "Text!!!";
        alertJsPrompt.sendKeys(text);
        alertJsPrompt.accept();
        result = driver.findElement(By.id("result")).getText().equals("You entered: " + text);
        if(result){
            System.out.println("Test passed!!");
        } else {
            System.out.println("Test failed!!");
        }
        driver.quit();


    }
}
