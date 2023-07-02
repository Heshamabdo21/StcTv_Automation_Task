
/*
 * Copyright (c) 2023.
 * Hesham Abd Elhamed Gharib
 */

package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {


    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                // Fix for chrome driver remote origin issue
                // See also: https://stackoverflow.com/questions/75678572/java-io-ioexception-invalid-status-code-403-text-forbidden
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                //driver = new ChromeDriver();

                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions opts = new ChromeOptions();
                // Fix for chrome driver remote origin issue
                // See also: https://stackoverflow.com/questions/75678572/java-io-ioexception-invalid-status-code-403-text-forbidden
                opts.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(opts);
                break;
        }
        return driver;
    }
}
