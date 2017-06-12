package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by muadnan on 2017-05-23.
 */
public class FailingImplicitWaitTest {

    public static FirefoxDriver driver;

    @BeforeClass
    public static void setupDriver()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\Users\\muadnan\\Downloads\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }


    @Test
    public void failingImplicitWaitTest()
    {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        WebElement helloWorldText = driver.findElement(By.id("finish"));
    }

    @AfterClass
    public static void quitDriver()
    {
        driver.quit();
    }
}
