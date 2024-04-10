package lesson3;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Final {

    private static class Locators {
        private static final By acceptCookies = By.id("ez-accept-all");
        private static final By email = By.xpath("//input[@data-val-length-max!=100]");
        private static final By password = By.xpath("//input[@data-val-length-max<200]");
    }

    private static class Urls {
        private static final String loginPage = "https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount";
    }

    private static class Data {
        private static final String invalidMail = "Email";
        private static final String invalidPass = "Password";
    }


    public static void acceptCookies(WebDriver driver) {
        try {
            Thread.sleep(1500);
            driver.findElement(Locators.acceptCookies).click();
        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println("element not found!!!");
        }
    }

    public static void sendKeys(WebDriver driver, String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get(Urls.loginPage);
        Thread.sleep(2500);
        acceptCookies(driver);
        sendKeys(driver, Data.invalidMail, Locators.email);
        sendKeys(driver, Data.invalidPass, Locators.password);
        Thread.sleep(2500);
        driver.quit();
    }
}
