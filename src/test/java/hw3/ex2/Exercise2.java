package hw3.ex2;

import hw3.base.TestBase;
import hw3.pages.IndexPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;


public class Exercise2 extends TestBase {

    @Test
    public void exerciseTwoTest() {
        //1. Open test site by URL
        openTestSite();
        IndexPage indexPage = new IndexPage(driver);
        //2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(indexPage.getBrowserTitle(), "Home Page");
        //3. Perform login
        indexPage.login(PropertyReader.read("user"), PropertyReader.read("password"));
        //4. Assert Username is logged
        softAssert.assertTrue(indexPage.isUserNameDisplayed());
        softAssert.assertEquals(indexPage.getUserName(), "ROMAN IOVLEV");
        //5.Open through the header menu Service -> Different Elements Page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        indexPage.goToDifferentElementsPage();


        /* //6. Select checkboxes "Water", "Wind"
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space() = 'Water']"))).click();
        driver.findElement(By.xpath("//label[normalize-space() = 'Wind']")).click();
        //7. Select radio "Selen"
        driver.findElement(By.xpath("//label[normalize-space() = 'Selen']")).click();
        //8.Select in dropdown "Yellow"
        new Select(driver.findElement(By.cssSelector(".colors select"))).selectByVisibleText("Yellow");
        //9.Assert that
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        ///WebElement waterCheckboxLog = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//li[contains(text(),'Water: condition changed to true')]")));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Water checkbox log is not displayed");

        WebElement windCheckboxLog = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//li[contains(text(),'Wind: condition changed to true')]")));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Wind checkbox log is not displayed");
        //    • for radio button there is a log row and value is corresponded to the status of radio button
        WebElement selenRadioLog = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//li[contains(text(),'metal: value changed to  Selen')]")));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Selen radio log is not displayed");
        //    • for dropdown there is a log row and value is corresponded to the selected value
        WebElement dropdownColorsLog = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]")));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Colors dropdown log is not displayed");

         */
        softAssert.assertAll();
        //12. Close Browser
        //tearDown() method in AbstractTestBase


    }
}
