package lesson4.webElementPackage;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementExampleClass1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
/*        driver.get("https://uhomki.prom.ua/ua/");
        WebElement search = driver.findElement(By.id("search_term"));
        search.sendKeys("Text");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        search = driver.findElement(By.id("search_term"));
        search.clear();
        search.sendKeys("New search");
        Thread.sleep(4000);*/

        driver.get("https://rozetka.com.ua/");
        WebElement greenButton = driver.findElement(By.cssSelector(".button_color_green"));
        System.out.println(greenButton.getText());
        System.out.println("Name of tag is " + greenButton.getTagName());
        System.out.println("Value of attribute class " + greenButton.getAttribute("class"));
        System.out.println("Value of background-color " + greenButton.getCssValue("background-color"));

        System.out.println("=============");
        System.out.println("Size of button " + greenButton.getSize());
        System.out.println("Width of button " + greenButton.getSize().width);
        System.out.println("Height of button " + greenButton.getSize().height);

        System.out.println("============");
        System.out.println("Coordinates of button " + greenButton.getLocation());
        System.out.println("Coordinates x of button " + greenButton.getLocation().x);
        System.out.println("Coordinates y of button " + greenButton.getLocation().y);

        System.out.println("============");
        int centreX = greenButton.getLocation().x + greenButton.getSize().width/2;
        int centreY = greenButton.getLocation().y + greenButton.getSize().height/2;
        System.out.println("Coordinates centre x of button " + centreX);
        System.out.println("Coordinates centre y of button " + centreY);

        Point centreOfGreenButton = new Point(centreX, centreY);
        System.out.println(centreOfGreenButton);
        driver.quit();
    }

}
