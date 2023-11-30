package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "baseUrl: http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    //created method with one parameter name 'menu'
    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
      //2.1 Mouse hover on “Desktops" Tab and click
        mouseHoverAndClickOnElement(By.xpath("//nav/div/ul/li/a[contains(text(),'Desktops')]"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");
        //1.3 Verify the text ‘Desktops'
        verifyElements("error","Desktops",By.xpath("//h2[contains(text(),'Desktops')]"));
//        String expectedText = "Desktops";
//        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
//        Assert.assertEquals("NotMatching", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClickOnElement(By.linkText("Laptops & Notebooks"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyElements("error","Laptops & Notebooks",By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverAndClickOnElement(By.linkText("Components"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");

        //3.3 Verify the text ‘Components’
        verifyElements("error","Components",By.xpath("//h2[contains(text(),'Components')]"));

    }


    @After
    public void closeBrowser() {
        driver.quit();
    }

}
