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
 * Created by muadnan on 2017-05-21.
 */
public class MyFirstWaitTests {


    public static FirefoxDriver driver;
    @BeforeClass
    public static void setupDriver()
    {
        int timeOut = 10;
        System.setProperty("webdriver.gecko.driver", "D:\\Users\\muadnan\\Downloads\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        System.out.println("IMPLICIT WAIT: Waiting for: "+timeOut+" Seconds for the page respond...");
    }

    @Before
    public void goToAccountPage()
    {
        driver.get("http://store.demoqa.com/products-page/your-account/");
    }


    @Test
    public void findAnElement_ShouldPass()
    {
        //WebElement loginField = driver.findElement(By.id("Please use the form below to login to your account."));
        WebElement loginField = driver.findElement(By.id("login"));
        System.out.println("TEST ShouldPass PASSED");
    }
    @Test
    public void findAnElement_ShouldFail()
    {
        WebElement someField = driver.findElement(By.id("doesNotExist"));
    }


    @AfterClass
    public static void quitDriver()
    {
        driver.quit();
    }

}

