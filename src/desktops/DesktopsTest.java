package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverAndClickOnElement(By.xpath("//a[@class = 'dropdown-toggle' and contains(text(), 'Desktops')]"));
        //1.2 Click on “Show All Desktops”
        mouseHoverAndClickOnElement(By.xpath(" //a[contains(text(), 'Show AllDesktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"), "https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC");
        //1.4 Verify the Product will arrange in Descending order.
        verifyElements("error", "Name (Z - A)", By.xpath("//select/option[contains(text(), 'Name (Z - A)')]"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Currency Dropdown and click
        mouseHoverAndClickOnElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and contains(text(), 'Currency')]"));
        //2.2 Mouse hover on £Pound Sterling and click
        mouseHoverAndClickOnElement(By.xpath("//button[@name='GBP' and contains(text(), '£Pound Sterling')]"));
        //2.3 Mouse hover on Desktops Tab.
        mouseHoverAndClickOnElement(By.xpath("//a[@class = 'dropdown-toggle' and contains(text(), 'Desktops')]"));
        //2.4 Click on “Show All Desktops”
        mouseHoverAndClickOnElement(By.xpath(" //a[contains(text(), 'Show AllDesktops')]"));
        //2.5 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");
        //2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.7 Verify the Text "HP LP3065"
        verifyElements("error", "HP LP3065", By.xpath("//h1[contains(text(),'HP LP3065')]"));
        //2.8 Select Delivery Date "2023-11-27"
        WebElement deliveryDateField = driver.findElement(By.id("input-option225"));
       deliveryDateField.sendKeys("2022-11-27");
//        String date = "23";
//        String month = "November";
//        String year = "2023";
//
//        clickOnElement(By.xpath("//button[@class = 'btn btn-default' and @type = 'button']//i[@class='fa fa-calendar']"));
//        while (true) {
//            String monthYear = getTextFromElement(By.xpath("//th[@class ='picker-switch' and contains(text(),'April,2011')]"));
//            System.out.println(monthYear);
//            String[] a = monthYear.split(" ");
//            String mon = a[0];
//            String yer = a[1];
//            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
//                break;
//            } else {
//                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
//            }
//        }
//        //select the date
//        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker']//tbody//tr/td"));
//        for (WebElement dt : allDates) {
//            if (dt.getText().equalsIgnoreCase(date)) {
//                dt.click();
//                break;
//           }
//        }
        //2.9.Enter Qty "1” using Select class. -- There is no Dropdown menu to choose from.
        clearText(By.xpath("//input[@id='input-quantity']"));
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
        //2.10 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        //verifyElements("Not correct text", "Success: You have added HP LP3065 to your shopping cart!", By.xpath("//div[@class = 'alert alert-success alert-dismissible']"));
        Thread.sleep(5000);
        //2.12 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.13 Verify the text "Shopping Cart"
        String expMessage1 = "Shopping Cart";
        String actMessage1 = getTextFromElement(By.xpath("//h1[contains(text(), 'Shopping Cart')]")).substring(0, 13);
        Assert.assertEquals("Not correct text", expMessage1, actMessage1);
        //2.14 Verify the Product name "HP LP3065"
        verifyElements("error", "HP LP3065", By.xpath("(//a[text()='HP LP3065'])[2]"));
        //2.15 Verify the Delivery Date "2022-11-30"
        String expTextDate = "2022-11-30";
        String actTextDate = getTextFromElement(By.xpath("(//small[contains(text(), '2022-11-30')])[2]")).substring(15, 25);
        Assert.assertEquals("Not correct Text", expTextDate, actTextDate);
        //assertAssert("Not Matching", expTextDate, actTextDate);
        //2.16 Verify the Model "Product21"
        verifyElements("error", "Not correct Text", By.xpath("//td[contains(text(),'Product 21')]"));
        clickOnElement(By.xpath("//form[@id='form-currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
        //2.17 Verify the Total "£74.73"
        verifyElements("error", "£74.73", By.xpath("//td[@class='text-right' and text()='£74.73'])[5]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
