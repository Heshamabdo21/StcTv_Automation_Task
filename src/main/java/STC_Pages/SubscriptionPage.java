
/*
 * Copyright (c) 2023.
 * Hesham Abd Elhamed Gharib
 */

package STC_Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SubscriptionPage extends BasePage {

    private By countrySelectionBtn = By.id("country-btn");
    private By countrySelectOverlay = By.id("country-selct");

    public SubscriptionPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select User Country {country}")
    public void selectCountry(String country) throws Exception {
        // Dynamically choose subscription country to avoid a method for each country
        Map<String, By> countries = new HashMap<>();
        countries.put("KSA", By.id("sa"));
        countries.put("Bahrain", By.id("bh"));
        countries.put("Kuwait", By.id("kw"));
        // select the country
        By toBeSelected = countries.get(country);
        this.clickCountrySelection();
        // Wait until country selection overlay is there
        this.isElementVisible(countrySelectOverlay);
        this.clickElement(toBeSelected);
        // Verify country is selected
        assertTrue(this.checkCountrySelected(country));

    }

    @Step("Click Country Selection Button in Navbar")
    public void clickCountrySelection() throws Exception {
        this.clickElement(countrySelectionBtn);

    }

    @Step("Verify Selected Country {country}")
    public Boolean checkCountrySelected(String country) {
        WebElement el = this.findElement(countrySelectionBtn);
        return el.getText().contains(country);
    }

    @Step("Get Desired Plan Container for {planName}")
    public WebElement getPlanContainer(String planName) {
        String planContainerSelector = String.format("//div[contains(@class, 'plan-names')]/div[contains(., '{}')]", planName);
        WebElement planContainer = this.findElement(By.xpath(planContainerSelector));
        return planContainer;
    }

    @Step("Get Plan Type for {planName}")
    public String getPlanType(String planName) {
        Map<String, By> plans = new HashMap<>();
        plans.put("Lite", By.id("name-lite"));
        plans.put("Classic", By.id("name-classic"));
        plans.put("Premium", By.id("name-premium"));
        By planTypeLocator = plans.get(planName);
        this.wait.until(ExpectedConditions.presenceOfElementLocated(planTypeLocator));
        WebElement type = this.findElement(planTypeLocator);
        return type.getText();
    }
    @Step("Verify Plan Type {Expected}")
    public void Verify_Plan_Type(String Expected,String Actual)
    {
        assertEquals(Actual,Expected  );
    }

    @Step("Get Plan Price for {planName}")
    public String getPlanPrice(String planName) {
        Map<String, By> prices = new HashMap<>();
        prices.put("Lite", By.cssSelector("#currency-lite > b"));
        prices.put("Classic", By.cssSelector("#currency-classic > b"));
        prices.put("Premium", By.cssSelector("#currency-premium > b"));
        By priceLocator = prices.get(planName);
        WebElement price = this.findElement(priceLocator);
        return price.getText();
    }
    @Step("Verify Plan Price {Expected}")
    public void Verify_Plan_Price(String Expected,String Actual)
    {
        assertEquals(Actual,Expected );

    }
    @Step("Get Plan Currency for {planName}")
    public String getPlanCurrency(String planName) {
        Map<String, By> currencies = new HashMap<>();
        currencies.put("Lite", By.cssSelector("#currency-lite > i"));
        currencies.put("Classic", By.cssSelector("#currency-classic > i"));
        currencies.put("Premium", By.cssSelector("#currency-premium > i"));
        By currencyLocator = currencies.get(planName);
        WebElement currency = this.findElement(currencyLocator);
        return currency.getText();
    }

    @Step("Verify Plan Currency {Expected}")
    public void Verify_Plan_Currency(String Expected,String Actual)
    {
        assertTrue(Expected.contains(Actual));

    }

}
