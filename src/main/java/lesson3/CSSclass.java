package lesson3;

import driver_factory.DriverSetUp2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSSclass {
    public static void main(String[] args) {
        WebDriver driver = DriverSetUp2.setUpDriver();
        driver.findElement(By.cssSelector(""));

        //поиск по классу .имя_класса

        //поиск по id #search

        /*
        //tag_name[@name_of_attribute='value'] -> xpath
        tag_name[name_of_attribute='value'] -> ccs
        */

        //css по буквосочетанию -> [placeholder*='ear']

        //css по начальному буквосочетанию -> [placeholder^='Sear']

        //css по конечному буквосочетанию -> [placeholder$='arch']

        // через пробел можем двигаться вниз по дереву ->  .block.no-margin div div a[href*='break-a-record']

        //припомощи not будем исключать параметры -> .btn:not([type='submit'])
    }
}
