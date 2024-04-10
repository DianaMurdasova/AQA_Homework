package lesson3;

import driver_factory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();

//        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
//        //By.xpath()
//        driver.findElement(By.xpath("//a[@title='Search']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@type='text'][@placeholder='Search']"))
//                .sendKeys("handstand push ups");
//        Thread.sleep(2000);
//
//        //By.xpath() with text
//        driver.findElement(By.xpath("//button[text()='Search']")).click();
//        Thread.sleep(2000);
//        driver.quit();
//
//        //By.xpath(), contains()
//        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
//        Thread.sleep(1500);
//        driver.findElement(By.xpath("//a[contains(text(), 'LICATION PR')]")).click();
//        Thread.sleep(1500);
//        driver.findElement(By.xpath("(//a[contains(@href, '/search/appli')])[1]")).click();
//        Thread.sleep(1500);
        //div[contains(@class, 'block block-4-12')][not(contains(@class, 'columned'))]

        //Относительный путь, внутри относительного путм
        //div[@class='region region-a']//*[text()='APPLICATION PROCESS']*/

        //xpath передвижение по DOM дереву
  /*    /.. - вверх по тегу
        /имя_тега - вниз к указанному тегу
        переход на родительский тег - /parent::div
        переход на дочерний тег - /child::a
        переход на параллельный тег - /following - sibling:: *[1]
        предок - / ancestor::span
        потомок        / descendant::h3
*/
        //div[@class='block block-12-12']/div[2]/div/div[2]/center/a/../../p[1]/following-sibling::center/child::a

        //xpath - операторы >, <, >=, <=, !=
        driver.get("https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        Thread.sleep(1500);
        try{
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (NoSuchElementException e){
            System.out.println("element not found!!!");
        }
        driver.findElement(By.xpath("//input[@data-val-length-max!=100]")).sendKeys("Email");
        driver.findElement(By.xpath("//input[@data-val-length-max<200]")).sendKeys("Password");
        Thread.sleep(2500);
        driver.quit();



    }
}
