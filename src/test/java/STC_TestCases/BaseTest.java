package STC_TestCases;

import Utils.BrowserConfiguration;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    protected BrowserConfiguration webConfig;

    public BaseTest() {
        this.webConfig = new BrowserConfiguration();
    }

    @BeforeTest()
    public void setup() {
        driver = BrowserFactory.getDriver(this.webConfig.browser());
        driver.get(this.webConfig.baseUrl());
        if (this.webConfig.maximized()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(this.webConfig.implicitWait()));
    }

    @AfterTest()
    public void teardown() {
        if (driver != null) driver.quit();

    }

    @BeforeSuite
    public void clear_old_allure_report()
    {

        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("cmd /c start \"\" Clear_allure_report.bat");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterSuite
    public void generate_allure_report(){
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("cmd /c start \"\" generate_allure_report.bat");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
