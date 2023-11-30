package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    //click on elemment
    public WebElement clickOnElement(By by) {
        driver.findElement(by).click();
        return null;
    }

    //sent text to the field
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //Clear the text
    public void clearText(By by) {
        driver.findElement(by).clear();
    }

    //get the text
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //Verify the actual and expected text
    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String Message = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, Message);
    }

    //Verify the actual and expected text
    public void verifyElementsWithSubString(String displayMessage, String expectedMessage, By by) {
        String Message = getTextFromElement(by).substring(0,100);
        Assert.assertEquals(displayMessage, expectedMessage, Message);
    }

    public boolean getNumberFromElement(By by,int expectedNumber){
        int actualNumber = driver.findElements(by).size();
        Assert.assertEquals(expectedNumber,actualNumber);
        return true;
    }


    //************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void getTextAlert() {
        driver.switchTo().alert().getText();
    }

    public void sendTextToAlert(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //************************* Dropdown Methods *****************************************************

    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(By by, int num) {
        WebElement index = driver.findElement(by);
        Select select = new Select(index);
        select.selectByIndex(num);
    }


    //*************************** Action Methods ***************************************//
    //mouse hover
    public WebElement mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        return null;
    }

    //Mouse hoverr and click
    public WebElement mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by);
        actions.moveToElement(text1).moveToElement(text2).click().build().perform();
        return text1;
    }
}