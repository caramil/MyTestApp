package tests;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by muadnan on 2017-04-16.
 */
public class MyFirstTest {


        @Test
        public void goToWebPage()
        {
            System.setProperty("webdriver.gecko.driver", "D:\\Users\\muadnan\\Downloads\\geckodriver-v0.15.0-win64\\geckodriver.exe");
            FirefoxDriver driver = new FirefoxDriver();
            driver.get("http://the-internet.herokuapp.com");
            assertTrue(driver.getTitle().equals("The Internet"));
            String title = driver.getTitle();
            System.out.println("####Title printing:" + title);
            driver.quit();
        }
    }

