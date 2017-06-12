package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by muadnan on 2017-05-23.
 */
public class MyFirstExplicitWait {

    public static FirefoxDriver driver;

    @BeforeClass
    public static void setupDriver()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\Users\\muadnan\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }


    @Test
    public void explicitWaitTest()
    {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        WebDriverWait waitForStartButton = new WebDriverWait(driver, 2);
        waitForStartButton.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#start>button")));
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        WebDriverWait waitForHelloText = new WebDriverWait(driver, 10);
        waitForHelloText.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        WebElement helloWorldText = driver.findElement(By.id("finish"));
        String textFromElement = helloWorldText.getText();
        assertThat(textFromElement, equalTo("Hello World!"));
    }


    @AfterClass
    public static void quitDriver()
    {
        driver.quit();
    }

}
