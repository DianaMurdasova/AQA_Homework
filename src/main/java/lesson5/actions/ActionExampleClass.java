package lesson5.actions;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionExampleClass {

    public static enum Courses{
        DEVOPS, FRONTEND, JAVA
    }
    public static void openCourseFromMainPage(Courses courses, WebDriver driver){
        Actions actions = new Actions(driver);
        String course = "";
        switch (courses){
            case JAVA -> course = "Java";
            case DEVOPS -> course = "DevOps";
            case FRONTEND -> course = "Frontend";
        }
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Курси']"))).click()
                .click(driver.findElement(By.xpath("//a[text()='"+course+"']"))).perform();
    }

    public static void goToMainPage(WebDriver driver){
        driver.get("https://dan-it.com.ua/uk/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
//        driver.get("https://dan-it.com.ua/uk/");
//        Actions action = new Actions(driver);
//        action.moveToElement(driver.findElement(By.xpath("//a[text()='Курси']"))).click()
//                .click(driver.findElement(By.xpath("//a[text()='Java']"))).perform();
//        Thread.sleep(2000);
//        driver.quit();

        goToMainPage(driver);
        openCourseFromMainPage(Courses.FRONTEND,driver);
        Thread.sleep(1500);
        System.out.println(driver.getTitle());
        System.out.println("==============");
        goToMainPage(driver);
        openCourseFromMainPage(Courses.JAVA, driver);
        Thread.sleep(1500);
        System.out.println(driver.getTitle());
        System.out.println("==============");
        goToMainPage(driver);
        openCourseFromMainPage(Courses.DEVOPS, driver);
        Thread.sleep(1500);
        System.out.println(driver.getTitle());
        System.out.println("==============");
        driver.quit();




    }
}
