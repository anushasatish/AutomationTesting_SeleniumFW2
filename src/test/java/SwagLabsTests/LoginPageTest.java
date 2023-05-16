package SwagLabsTests;

import ExcelAndReport.ExcelDataProvider;
import SwagLabsPages.CompletePage;
import SwagLabsPages.LoginPage;
import SwagLabsPages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static driverManager.DriverManager.getDriver;

public class LoginPageTest extends BaseTest
{
 LoginPage loginpg = new LoginPage();

 //Test case to check username and password credentials - by pulling data from Excel swag through data provider
 @Test(dataProvider = "ExcelDataSwagLabs", dataProviderClass = ExcelDataProvider.class)
 public void LoginTest(String[] a)
 {
  loginpg.navigateToLoginPage();

  loginpg.getPassword().clear();
  loginpg.getUserName().sendKeys(a[0]);
  loginpg.getPassword().clear();
  loginpg.getPassword().sendKeys(a[1]);

  loginpg.login1();

  //Validation for login page
  String actualUrl = "https://www.saucedemo.com/inventory.html";
  String expectedUrl = getDriver().getCurrentUrl();
  Assert.assertEquals(actualUrl, expectedUrl);

  System.out.print(a[0] + " :: ");
  System.out.println(a[1]);
 }


 //To check the Title of the Webpage
 @Test
 public void PageTitleTest()
 {
  loginpg.navigateToLoginPage();
  String ActualTitle = loginpg.login().getTitle();
  String ExpectedTitle = "Products";
  Assert.assertEquals(ActualTitle,ExpectedTitle,"Title not as expected");
 }

}