package functions;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by muadnan on 2017-06-12.
 */
public class HotelAppBusinessFunctions {
   // public static Properties properties;
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


    //This function is used to read data from specified cell of Excel sheet once you give Excelsheet name and path

    public static String readHotelLocation (int row, String column, String strFilePath)
    {
        Cell c= null;
        int reqCol=0;
        WorkbookSettings ws = null;
        Workbook workbook = null;
        Sheet sheet = null;
        FileInputStream fs = null;
        try{
            fs = new FileInputStream(new File(strFilePath));
            ws = new WorkbookSettings();
            ws.setLocale(new Locale("en", "EN"));

            // opening the work book and sheet for reading data
            workbook = Workbook.getWorkbook(fs, ws);
            sheet = workbook.getSheet(0);

            // Sanitise given data
            String col = column.trim();

            //loop for going through the given row
            for(int j=0; j<sheet.getColumns(); j++)
            {
                Cell cell = sheet.getCell(j,0);
                if((cell.getContents().trim()).equalsIgnoreCase(col))
                {
                    reqCol= cell.getColumn();
                    //System.out.println("column No:"+reqCol);
                    c = sheet.getCell(reqCol, row);
                    fs.close();
                    return c.getContents();
                }
            }
        }
        catch(BiffException be)
        {

            System.out.println("The given file should have .xls extension.");
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
        System.out.println("NO MATCH FOUND IN GIVEN FILE: PROBLEM IS COMING FROM DATA FILE");

        return null;
    }

    public static int excelRowCount(String strFilePath, String strColumn)
    {
    int k;
        for (k=1;k<1000;k++) {
        String strParamerterValue = readHotelLocation(k,strColumn,strFilePath);
            if(strParamerterValue.equals("ENDOFROW"))
            {
                break;
            }
        }
    return k;
    }
}
