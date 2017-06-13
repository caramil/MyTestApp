//TESTING 1st Commit
//TESTING 2nd Commit
package tests;
import java.util.Properties;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import functions.HotelAppBusinessFunctions;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * Created by muadnan on 2017-06-05.
 */

public class SharedUIMapTestCallFunctions extends HotelAppBusinessFunctions {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public Properties properties;

    @Before
    public void setUp() throws Exception {
        properties = new Properties();
        properties.load(new FileInputStream(".\\src\\test\\java\\tests\\SharedUIMap.properties"));
        System.setProperty("webdriver.gecko.driver", "D:\\Users\\muadnan\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://adactin.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testHotelAppBooking() throws Exception {

        driver.get(baseUrl + "/HotelApp/index.php");

                //Call Login function
        hotelLogin(driver, properties,"cnadnan81", "12345678");

        new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
        driver.findElement(By.id("Submit")).click();
        String sydneyLocation = driver.findElement(By.xpath(".//*[@id='location_1']")).getAttribute("value");
            if(sydneyLocation.equalsIgnoreCase("Sydney")) {
                System.out.println("Search OK");
            }
            else
            {       System.out.println("Search NOK");
            }
        driver.findElement(By.id("radiobutton_1")).click();
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys("Muhammad");
        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys("Adnan");
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("Hervey");
        driver.findElement(By.id("cc_num")).clear();
        driver.findElement(By.id("cc_num")).sendKeys("1234567890123456");
        new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("American Express");
        new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("November");
        new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2020");
        driver.findElement(By.id("cc_cvv")).clear();
        driver.findElement(By.id("cc_cvv")).sendKeys("1234");
        driver.findElement(By.id("book_now")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.linkText("Click here to login again")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
