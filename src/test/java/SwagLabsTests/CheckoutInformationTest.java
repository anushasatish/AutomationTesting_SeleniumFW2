package SwagLabsTests;

import SwagLabsPages.CompletePage;
import SwagLabsPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckoutInformationTest extends BaseTest
{
    LoginPage loginpg = new LoginPage();

    //To test if error message gets displayed if mandatory information is missing
    @Test
    public void MandatoryUserInfo()
    {
        loginpg.navigateToLoginPage();
        CompletePage completepage = loginpg.login()
                .singleItemCheckout()
                .missingInfo();

        String ActualError = loginpg.getError().getText();
        String ExpectedError = "Error: Postal Code is required";
        Assert.assertEquals(ActualError,ExpectedError,"Error not as expected");
    }

}
