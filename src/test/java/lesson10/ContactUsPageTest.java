package lesson10;

import driver_factory.DriverSetUp3;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyAllureListener;
import utils.MyTestListeners;

@Listeners({MyAllureListener.class})
public class ContactUsPageTest {
    static final Logger logger = LoggerFactory.getLogger(ContactUsPageTest.class);
    private  WebDriver driver;
    private lesson10.ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp(){
        driver = DriverSetUp3.startDriver();
        contactUsPage = new lesson10.ContactUsPage(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    @Description("This test will check positive sending message")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Positive sending")
    public void sendMessagePositive(){
        String textToSend = "My text";
        contactUsPage
                .openContactUsPage()
                .selectOptionFromSubjectHeading(lesson10.ContactUsPage.SubjectHeader.WEBMASTER)
                .setValidEmail()
                .setOrderId()
                .enterMessage(textToSend)
                .clickSendButton()
                .waitForResultMessage();
        logger.info("Lets do assertion!!!");
        Assert.assertEquals(contactUsPage.getSuccessMessage(), contactUsPage.validSuccessMessage());
    }
    @Test
    @Description("This tst will check positive sending message without order Id")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Positive sending")
    public void sendMessagePositiveWithoutOrderId(){
        String textToSend = "My text";
        contactUsPage
                .openContactUsPage()
                .selectOptionFromSubjectHeading(lesson10.ContactUsPage.SubjectHeader.WEBMASTER)
                .setValidEmail()
                .enterMessage(textToSend)
                .clickSendButton()
                .waitForAlertMessage();
        logger.info("Lets do assertion!!!");
        Assert.assertEquals(contactUsPage.getSuccessMessage(), contactUsPage.validSuccessMessage());
    }


    @Test
    @Description("This test will check negative sending message, when message is empty")
    @Severity(SeverityLevel.MINOR)
    @Feature("Negative sending")
    public void sendMessageNegativeEmptyMessage(){
        contactUsPage
                .openContactUsPage()
                .setValidEmail()
                .selectOptionFromSubjectHeading(lesson10.ContactUsPage.SubjectHeader.CUSTOM)
                .setOrderId()
                .clickSendButton()
                .waitForAlertMessage();
        logger.info("Lets do assertion!!!");
        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(ContactUsPage.Alert.MESSAGE));
    }
    @Test
    @Description("This test will check negative sending message, when message is empty")
    @Severity(SeverityLevel.TRIVIAL)
    @Feature("Negative sending")
    @TmsLink("https://murdiana.testrail.io/index.php?/cases/view/11&group_by=cases:section_id&group_order=asc&display_deleted_cases=0&group_id=3")
    public void sendMessageNegativeInvalidMail(){
        String textToSend = "My text";
        contactUsPage
                .openContactUsPage()
                .selectOptionFromSubjectHeading(lesson10.ContactUsPage.SubjectHeader.WEBMASTER)
                .setInvalidEmail()
                .setOrderId()
                .enterMessage(textToSend)
                .clickSendButton()
                .waitForAlertMessage();
        logger.info("Lets do assertion!!!");
        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(lesson10.ContactUsPage.Alert.EMAIL));
    }
    @Test
    @Description("This test will check negative sending message, when no chose")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Negative sending")
    public void sendMessageNegativeNoChose(){
        String textToSend = "My text";
        contactUsPage
                .openContactUsPage()
                .setValidEmail()
                .setOrderId()
                .enterMessage(textToSend)
                .clickSendButton()
                .waitForAlertMessage();
        logger.info("Lets do assertion!!!");
        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(lesson10.ContactUsPage.Alert.CHOSE));
    }
}
