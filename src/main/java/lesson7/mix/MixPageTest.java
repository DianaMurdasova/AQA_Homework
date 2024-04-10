package lesson7.mix;

import driver_factory.DriverSetUp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MixPageTest {
    WebDriver driver;

    public MixPageTest(WebDriver driver) {
        //создаем конструктор драйвера
        this.driver = driver;
    }

    public enum Symbols {
        //собираем енамс для упрощения свитча
        STAR, BALOON, APPLE, PIZZA, ROCKET
    }

    private static class Locators {
        //забираем локаторы для упрощения работы
        private static final By star = By.id("star");
        private static final By baloon = By.id("baloon");
        private static final By apple = By.id("apple");
        private static final By pizza = By.id("pizza");
        private static final By rocket = By.id("rocket");
        private static final By dragArea2 = By.id("dragArea2");
        private static final By select = By.id("select");
        private static final By doubleClickButton = By.id("doubleClickButton");
        private static final By contextClickButton = By.id("contextClickButton");
        private static final By clickCounterButton = By.id("clickCounterButton");
        private static final By clickCounter = By.id("clickCounter");
        private static final By generateAnimalButton = By.id("generateAnimalButton");
        private static final By randomAnimal = By.id("randomAnimal");

    }

    public void openMixPage() {     //метод для открытия страницы
        String htmlFilePath = "C:\\Users\\anduser\\Desktop\\additional\\Enabled\\MixId.html";
        driver.get("file:///" + htmlFilePath);
    }

    public void closeDriver() {     //конструктор для закрытия драйвера
        driver.quit();
    }

    public void selectOption(int optionNumber) {           //метод для выпадающего списка чтобы выбирать нужное значение по id
        Select select = new Select(driver.findElement(Locators.select));
        select.selectByValue("option" + optionNumber);
    }
    public void dragNDrop(Symbols symbols){
        //в этом методе реализуем драгНдроп, перетаскивание элемента в конкретную область
        //элемент забираем свитчем используя ранее забранные енамс и локаторы

        Actions actions = new Actions(driver);
        //создаем объект By куда будем помещать нужный локатор
        By sourceElement = null;

        switch (symbols){
            case STAR -> sourceElement = Locators.star;
            case APPLE -> sourceElement = Locators.apple;
            case BALOON -> sourceElement = Locators.baloon;
            case PIZZA -> sourceElement = Locators.pizza;
            case ROCKET -> sourceElement = Locators.rocket;
        }
        //прописываем сам экшн драгНдропа - зажимаем элемент(источник/цель) - переносим в область(таргет)
        actions.dragAndDrop(driver.findElement(sourceElement), driver.findElement(Locators.dragArea2)).perform();
    }

    public void contextClickTest(String expectedContextMenuText) {
        //метод по контекстному клику на конкретную кнопку
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(Locators.contextClickButton)).perform();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals(expectedContextMenuText)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed!!");
        }
        alert.accept();
    }

    public void checkClickButton(int countOfClicks) {
        for (int i = 0; i < countOfClicks; i++) {
            driver.findElement(Locators.clickCounterButton).click();
        }
        if (Integer.parseInt(driver.findElement(Locators.clickCounter).getText()) == countOfClicks){
            System.out.println("Counter click button works correct!!!");
        } else {
            System.out.println("Counter click button works non correct!!!");
        }
    }
    public void clickUntilAndPrintSymbolOfAnimal(String animal){
        while (!(driver.findElement(Locators.randomAnimal)
                .getText().split("\\s")[0].replace(":","")).equals(animal)){
            driver.findElement(Locators.generateAnimalButton).click();
        }
        System.out.println(driver.findElement(Locators.randomAnimal)
                .getText().split("\\s")[1]);
    }

    public static void main(String[] args) throws InterruptedException {
        MixPageTest mixPageTest = new MixPageTest(DriverSetUp.setUpDriver());
        mixPageTest.openMixPage();
        mixPageTest.dragNDrop(Symbols.PIZZA);
        mixPageTest.dragNDrop(Symbols.BALOON);
        mixPageTest.selectOption(2);
        mixPageTest.selectOption(1);
        mixPageTest.contextClickTest("Context click!");
        mixPageTest.checkClickButton(11);
        mixPageTest.clickUntilAndPrintSymbolOfAnimal("Овца");
        mixPageTest.closeDriver();
    }
}
