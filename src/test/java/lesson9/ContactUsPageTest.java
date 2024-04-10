package lesson9;

import driver_factory.DriverSetUp3;
import lesson9.pages.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners;
@Listeners(MyTestListeners.class)
public class ContactUsPageTest {
    private static WebDriver driver; //подключение драйвера
    private ContactUsPage contactUsPage; //подключение страницы

    //запуск драйвера и создание пейджи для тестирования
    @BeforeClass
    public void setUp(){
        driver = DriverSetUp3.startDriver();
        contactUsPage = new ContactUsPage(driver);
    }

    //закрытие драйвера
    @AfterClass
    public void stop(){
        driver.quit();
    }

    //тест с оправкой правильных данных и номером заказа и получением сообщения об успешной отправке сообщения
    @Test
    public void sendMessagePositive(){
        String textToSend = "My text";
        contactUsPage //текучий интерфейс
                .openContactUsPage()
                .selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.WEBMASTER)
                .setValidEmail()
                .setOrderId()
                .enterMessage(textToSend)
                .clickSendButton()
                .waitForResultMessage();
        //сравниваем текст об успешной отправке с полученным нами сообщением
        Assert.assertEquals(contactUsPage.getSuccessMessage(), contactUsPage.validSuccessMessage());
    }

    //тест с оправкой правильных данных без номера заказа и получением сообщения об успешной отправке сообщения
    @Test
    public void sendMessagePositiveWithoutOrderId(){
        String textToSend = "My text";
        contactUsPage
                .openContactUsPage()
                .selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.WEBMASTER)
                .setValidEmail()
                .enterMessage(textToSend)
                .clickSendButton()
                .waitForResultMessage();
        //сравниваем текст об успешной отправке с полученным нами сообщением
        Assert.assertEquals(contactUsPage.getSuccessMessage(), contactUsPage.validSuccessMessage());
    }

    //тест с оправкой без введения сообщения и получением алерта о неуспешной отправке сообщения
    @Test
    public void sendMessageNegativeEmptyMessage(){
        contactUsPage
                .openContactUsPage()
                .setValidEmail()
                .selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.CUSTOM)
                .setOrderId()
                .clickSendButton()
                .waitForAlertMessage();
        //сравниваем алерт о неуспешной отправке с полученным нами сообщением
        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(ContactUsPage.Alert.MESSAGE));
    }

    //тест с неправильным имейлом и получением алерта о неуспешной отправке сообщения
    @Test
    public void sendMessageNegativeInvalidMail(){
        String textToSend = "My text";
        contactUsPage
                .openContactUsPage()
                .selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.WEBMASTER)
                .setInvalidEmail()
                .setOrderId()
                .enterMessage(textToSend)
                .clickSendButton()
                .waitForAlertMessage();
        //сравниваем алерт о неуспешной отправке с полученным нами сообщением
        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(ContactUsPage.Alert.EMAIL));
    }

    //тест без выбора опции селекта и получением алерта о неуспешной отправке сообщения
    @Test
    public void sendMessageNegativeNoChose(){
        String textToSend = "My text";
        contactUsPage
                .openContactUsPage()
                .setValidEmail()
                .setOrderId()
                .enterMessage(textToSend)
                .clickSendButton()
                .waitForAlertMessage();
        //сравниваем алерт о неуспешной отправке с полученным нами сообщением
        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(ContactUsPage.Alert.CHOSE));
    }

}
