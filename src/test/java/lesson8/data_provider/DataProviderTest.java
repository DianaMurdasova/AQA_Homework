package lesson8.data_provider;

import driver_factory.DriverSetUp;
import lesson7.CustomWaiterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "loginParameters")
    public void loginNegativeTest(String mail, String passwd){
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        CustomWaiterClass wait = new CustomWaiterClass(driver);
        wait.waitForVisibilityOfElementLocated(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("passwd")).sendKeys(passwd);
        driver.findElement(By.id("SubmitLogin")).click();
        wait.waitForVisibilityOfElementLocated(By.cssSelector(".alert.alert-danger"));
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-danger p")).getText(),
                "There is 1 error");
        driver.quit();
    }

    @DataProvider(name = "loginParameters")
    public Object[][] createData(){
        return new Object[][]{
                {"invalid mail 1", "invalid passwd 1"},
                {"invalid mail 2", "invalid passwd 2"},
                {"invalid mail 3", "invalid passwd 3"},
                {"invalid mail 4", "invalid passwd 4"},
                {"invalid mail 5", "invalid passwd 5"}
        };
    }
}
