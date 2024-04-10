package lesson4.driverMethods;

import driver_factory.DriverSetUp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandleExample2 {

    public static void openLinkInNewTab(WebDriver driver, String url) throws InterruptedException {
        Set<String> set1 = driver.getWindowHandles();
       ((JavascriptExecutor) driver).executeScript("window.open()");// скрипт для открытия нового пустого окна/вкладки
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        Set<String> set2 = driver.getWindowHandles();//забираем сет в котором уже два окна
        set2.removeAll(set1);//удаляем из сет2 то что в сет1 и остается только ID второго окна
        String windowDescriptor2 = set2.iterator().next();
        driver.switchTo().window(windowDescriptor2);
        driver.get(url);
    }
     /*  Открыть в браузере три различные вкладки.
    На каждой вкладке открыть отдельно различные любые страницы,
    вывести в консоль названия открытых страниц. Закрыть браузер.*/
     public static void main(String[] args) throws InterruptedException {
         WebDriver driver = DriverSetUp.setUpDriver();
         driver.get("http://www.automationpractice.pl/index.php");
         openLinkInNewTab(driver, "https://uhomki.prom.ua/ua/");
         openLinkInNewTab(driver, "https://rozetka.com.ua/");
         Thread.sleep(2000);
         Set<String> windowHandles = driver.getWindowHandles();
         for(String windowId: windowHandles){
             driver.switchTo().window(windowId);
             System.out.println(driver.getTitle());
         }
         driver.quit();


     }


}
