package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Created by muadnan on 2017-06-12.
 */
public class HotelAppBusinessFunctions {
    public static Properties properties;
  //  public static WebDriver driver;
    public void hotelLogin(WebDriver driver,Properties properties, String username, String password)
    {
        //driver.findElement(By.id("username")).clear();
        //driver.findElement(By.id("username")).sendKeys("cnadnan81");
        driver.findElement(By.id(properties.getProperty("Txt_Login_Username"))).clear();
        driver.findElement(By.id(properties.getProperty("Txt_Login_Username"))).sendKeys("cnadnan81");

        //driver.findElement(By.id("password")).clear();
        //driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id(properties.getProperty("Txt_Login_Password"))).clear();
        driver.findElement(By.id(properties.getProperty("Txt_Login_Password"))).sendKeys("12345678");
        driver.findElement(By.id("login")).click();
    }
}
