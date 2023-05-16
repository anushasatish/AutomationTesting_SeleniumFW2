package ExcelAndReport;

import org.testng.annotations.DataProvider;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;

// To get the username and password data from excel located in resources/swag.xlsx for sauce demo webpage
public class ExcelDataProvider
{
    XSSFWorkbook wb;

    @DataProvider(name = "ExcelDataSwagLabs")
    public Object[][] exceldpSwag()
    {

            String location = "/Users/dank/Downloads/IntellijProjects/AutomationTesting_SeleniumFW2/src/main/resources/swag.xlsx";

            try
            {
                wb = new XSSFWorkbook(location);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }

            XSSFSheet sheet = wb.getSheet("login");

            //System.out.println(sheet.getLastRowNum());

            int numOfRows = sheet.getLastRowNum() +1;
            int numOfColumns = sheet.getRow(0).getLastCellNum();

            String[][] data = new String[numOfRows -1][numOfColumns];

            for (int i = 1; i< numOfRows; i ++)
            {
                XSSFRow row = sheet.getRow(i);

                // String uname = row.getCell(0).getStringCellValue();
                //String password = row.getCell(1).getStringCellValue();

                data[i-1][0] = row.getCell(0).getStringCellValue();
                data[i-1][1] = row.getCell(1).getStringCellValue();

            }
            return data;
    }
}
