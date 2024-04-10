package lesson5.select;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClassExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("http://ktokuda.net/");

        WebElement countriesWebElement = driver.findElement(By.id("itt_country"));
        Select countries = new Select(countriesWebElement);

        //select
//        Thread.sleep(1500);
//        countries.selectByIndex(1);
//        Thread.sleep(1500);
//        countries.selectByVisibleText("Испания");
//        Thread.sleep(1500);
//        countries.selectByValue("39");
//        Thread.sleep(1500);
//        driver.quit();

        //isMultiple
        System.out.println(countries.isMultiple());
        Select region = new Select(driver.findElement(By.id("region_list")));
        System.out.println(region.isMultiple());

        //getOptions
//        List<WebElement> countriesOptionList = countries.getOptions();
//        for(WebElement singleCountry: countriesOptionList) {
//            System.out.println(singleCountry.getText());
//        }


        countries.selectByVisibleText("Испания");
        Thread.sleep(1500);

        //getAllSelectedOptions()
        region.selectByVisibleText("Барселона");
        Thread.sleep(1500);
        region.selectByValue("5274");
        region.selectByVisibleText("Мадрид");
        region.deselectByVisibleText("Все регионы");

        List<WebElement> selectedRegionList = region.getAllSelectedOptions();
        for(WebElement singleCountry: selectedRegionList){
            System.out.println(singleCountry.getText());
        }

        //deselect()
        region.deselectByValue("5274");

        selectedRegionList = region.getAllSelectedOptions();
        for(WebElement singleCountry: selectedRegionList){
            System.out.println(singleCountry.getText());
        }

        Thread.sleep(1500);

        region.deselectAll();

        Thread.sleep(1500);

        driver.quit();


    }
}
