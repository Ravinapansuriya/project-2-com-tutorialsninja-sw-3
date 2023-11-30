package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

import java.util.Random;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //  1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //   1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //  1.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        //  1.4 Verify the Product price will arrange in High to Low order
        verifyElements("Not in correct order", "Price (High > Low)", By.xpath("//option[contains(text(),'Price (High > Low)')]"));
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse hover on Currency Dropdown and click
        Thread.sleep(2000);
        mouseHoverAndClickOnElement(By.xpath("//span[normalize-space()='Currency']"));
//      Extra.2 Mouse hover on £Pound Sterling and click
        mouseHoverAndClickOnElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
//        2.1 Mouse hover on Laptops & Notebooks Tab and click
        Thread.sleep(200);
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
//        2.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
//        2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
//        2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
//        2.5 Verify the text “MacBook”
        verifyElements("error", "MacBook", By.xpath("//h1[normalize-space()='MacBook']"));
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expSuccMessage = "Success: You have added MacBook to your shopping cart!";
        String actSuccMessage = getTextFromElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 54);
        Assert.assertEquals("Not correct text", expSuccMessage, actSuccMessage);
//        2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // 2.9 Verify the text "Shopping Cart"
        String expTextShop = "Shopping Cart";
        String actTextShop = getTextFromElement(By.xpath("//h1[contains(text(), 'Shopping Cart')]")).substring(0, 13);
        Assert.assertEquals("Not correct text", expTextShop, actTextShop);
//        2.10 Verify the Product name "MacBook"
        verifyElements("error", "MacBook", By.xpath("//div[@class = 'table-responsive']/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
//        2.11 Change Quantity "2"
        String s = Keys.CONTROL + "a";
        //findBelowElement(By.xpath("//input[@class='form-control']"), By.xpath("//input[@name='quantity"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), s);
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
//        2.12 Click on “Update” Tab
        clickOnElement(By.xpath("(//button[@type='submit'])[1]"));
//        2.13 Verify the message “Success: You have modified your shopping cart!”
        //verifyElements("error", "Success: You have modified your shopping cart!", By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//        2.14 Verify the Total £737.45
        verifyElements("error", "£737.45", By.xpath("//div[@class = 'table-responsive']/table[1]/tbody[1]/tr[1]/td[6]"));
//        2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
//        2.16 Verify the text “Checkout”
        verifyElements("error", "Checkout", By.xpath("//h1[normalize-space()='Checkout']"));
//        2.17 Verify the Text “New Customer”
        verifyElements("error", "New Customer", By.xpath("//h2[normalize-space()='New Customer']"));
//        2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
//        2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
//        2.20 Fill the mandatory fields (FirstName)
        sendTextToElement(By.name("firstname"), "Abcd");
//        2.20 Fill the mandatory fields (FirstName)
        sendTextToElement(By.name("lastname"), "patel");
//        2.20 Fill the mandatory fields (Email)
        Random random = new Random();
        sendTextToElement(By.id("input-payment-email"), "abcd" + random.nextInt() + "@gmail.com");
//        2.20 Fill the mandatory fields (telephone)
        sendTextToElement(By.name("telephone"), "074424856274");
//        2.20 Fill the mandatory fields (Address)
        sendTextToElement(By.name("address_1"), "2, week street ");
//        2.20 Fill the mandatory fields (City)
        sendTextToElement(By.name("city"), "London");
//        2.20 Fill the mandatory fields (PostCode)
        sendTextToElement(By.name("postcode"), "HA0 2AB");
//        2.20 Fill the mandatory fields (Country)
        selectByVisibleTextFromDropDown(By.name("country_id"), "United Kingdom");
//        2.20 Fill the mandatory fields (Region)
        selectByVisibleTextFromDropDown(By.name("zone_id"), "Essex");
//        2.21 Click on “Continue”Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
//        2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "The product is Good.");
//        2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
//        2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
//        2.25 Verify the message “Warning: Payment method required!”
        //verifyElements("error", "Warning: Payment method required!", By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
