package STC_TestCases;

import DataProviders.StcTvDataProvider;
import STC_Pages.SubscriptionPage;
import Utils.ExtentReportManager;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class Stc_TestCase extends BaseTest {
     SubscriptionPage subscriptionPage;

    @BeforeClass()
    public void init() throws Exception {
        subscriptionPage = new SubscriptionPage(this.driver);
    }

    @Test(enabled = true, dataProvider = "DataProvider", dataProviderClass = StcTvDataProvider.class)
  //  @Description("Assert Plan type, price and currency for {countryName}")

    public void stcTv_TestCases(String countryName,String liteName, String litePrice,String classicName,
                                        String classicPrice, String premiumName,   String premiumPrice, String currency)
            throws InterruptedException, IOException, Exception {
        subscriptionPage.selectCountry(countryName);
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.updateTestCase(testResult -> testResult.setName("Test Case to verifiy Plan type, price and currency for "+countryName));
        lifecycle.updateTestCase(testResult -> testResult.setDescription("Assert Plan type, price and currency for "+countryName));

        ExtentReportManager.createTest("STC TV Test case - Assertion for country (" + countryName
                + ") to have correct type, price and currency");
        subscriptionPage.Verify_Plan_Type(subscriptionPage.getPlanType("Lite").toLowerCase(),
                liteName.toLowerCase());

        subscriptionPage.Verify_Plan_Price(subscriptionPage.getPlanPrice("Lite"),litePrice);

        subscriptionPage.Verify_Plan_Currency(subscriptionPage.getPlanCurrency("Lite"),currency);

        ///////////////////////////
        subscriptionPage.Verify_Plan_Currency(subscriptionPage.getPlanCurrency("Classic"),currency);
        subscriptionPage.Verify_Plan_Price(subscriptionPage.getPlanPrice("Classic"),classicPrice);
        subscriptionPage.Verify_Plan_Type(subscriptionPage.getPlanType("Classic").toLowerCase(),
                classicName.toLowerCase());
        ////////////////////////////////
        subscriptionPage.Verify_Plan_Currency(subscriptionPage.getPlanCurrency("Premium"),currency);
        subscriptionPage.Verify_Plan_Price(subscriptionPage.getPlanPrice("Premium"),premiumPrice);
        subscriptionPage.Verify_Plan_Type(subscriptionPage.getPlanType("Premium").toLowerCase(),
                premiumName.toLowerCase());

        ExtentReportManager.pass("Price and currency are as expected.");
    }



    @AfterMethod()
    public void leave() {
        subscriptionPage.screenshot();
    }
}
