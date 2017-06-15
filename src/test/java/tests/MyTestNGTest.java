package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.Reporter;

import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MyTestNGTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D:\\Users\\muadnan\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://www.adactin.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testMyFirstWebDriver() throws Exception {
        driver.get(baseUrl + "/HotelApp/");
        driver.findElement(By.xpath(".//*[@id='username']")).clear();
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("adactin123");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("adactin123");
        driver.findElement(By.id("login")).click();

        Reporter.log("Login was successfull", true);


        new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
        driver.findElement(By.id("Submit")).click();
        driver.findElement(By.id("radiobutton_1")).click();
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys("test");
        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys("test");
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("test");
        driver.findElement(By.id("cc_num")).clear();
        driver.findElement(By.id("cc_num")).sendKeys("1212121212121212");
        new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("American Express");
        new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("March");
        new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2015");
        driver.findElement(By.id("cc_cvv")).clear();
        driver.findElement(By.id("cc_cvv")).sendKeys("111");
        driver.findElement(By.id("book_now")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.linkText("Click here to login again")).click();
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            AssertJUnit.fail(verificationErrorString);


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
