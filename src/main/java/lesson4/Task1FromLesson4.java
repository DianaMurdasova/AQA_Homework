package lesson4;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task1FromLesson4 {

    @FindBy(xpath = "(//button[@class='header__button'])[2]")
    public static WebElement loginWindowButton;

    @FindBy(id = "auth_email")
    private static WebElement loginField;

    @FindBy(id = "auth_pass")
    private static WebElement passwordField;

    @FindBy(xpath = "//label[@for='remember_me']")
    private static WebElement rememberMeCheckbox;
    @FindBy(xpath = "//button[@class='auth-modal__register-link button button--link ng-star-inserted']")
    private static WebElement loginButton;


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();

        Task1FromLesson4 page = new Task1FromLesson4();
        PageFactory.initElements(driver,page);
        driver.get("https://rozetka.com.ua/");
        loginWindowButton.click();
        Thread.sleep(2000);
        loginField.sendKeys("email@email.com");
        passwordField.sendKeys("password");
        Thread.sleep(2000);
        rememberMeCheckbox.click();
        Thread.sleep(2000);
        System.out.println(loginButton.getText());
        Thread.sleep(2000);
        driver.quit();


//        driver.findElement(By.xpath("(//button[@class='header__button'])[2]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("auth_email")).sendKeys("Email");
//        driver.findElement(By.id("auth_pass")).sendKeys("Password");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//label[@for='remember_me']")).click();
//        Thread.sleep(2000);
//        String text = driver.findElement(By.xpath("//button[@class='auth-modal__register-link button button--link ng-star-inserted']")).getText();
//        System.out.println(text);
//        driver.quit();
    }

}
