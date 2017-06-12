package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by muadnan on 2017-05-21.
 */
public class MyFirstAssertionTests {


    public static FirefoxDriver driver;
        @BeforeClass
        public static void setupDriver()
        {
            System.setProperty("webdriver.gecko.driver", "D:\\Users\\muadnan\\Downloads\\geckodriver-v0.15.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        @Before
        public void goToAccountPage()
        {
            driver.get("http://store.demoqa.com/products-page/your-account/");
        }

        @Test
        public void assertTrue_PageTitle()
        {
            assertTrue(driver.getTitle().equals("Your Account | ONLINE STORE"));
            System.out.println("TEST1:###################### TRUE");
            //assertTrue("Error with page title on 'Your Account' page",driver.getTitle().equals("DUMMY DUMMY DUMMY"));
        }
        @Test
        public void assertEquals_FormTitleIsYourAccount()
        {
            WebElement yourAccountLabel = driver.findElement(By.className("entry-title"));
            String yourAccountLabelText = yourAccountLabel.getText();
            //assertEquals("Test in the title is NOT OK",yourAccountLabelText, "!Your Account");
            assertEquals("Test in the title is NOT OK",yourAccountLabelText, "Your Account");
            System.out.println("TEST2:###################### TRUE");
        }
        @Test
        public void assertThat_FooterContainsCertainText() {
            WebElement footerLaber = driver.findElement(By.cssSelector("#footer_nav>p"));
            String footerLabelText = footerLaber.getText();
            assertThat("Error in the footer text",footerLabelText, containsString("Splashing Pixels"));
            //assertThat("Error in the footer text", footerLabelText, containsString("Some dummy text"));
            System.out.println("TEST3:###################### TRUE");
        }

        @AfterClass
        public static void quitDriver()
        {
            driver.quit();
        }

    }

