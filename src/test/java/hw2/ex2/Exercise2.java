package hw2.ex2;

import hw2.base.AbstractTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Exercise2 extends AbstractTestBase {

    @Test
    public void exerciseTwoTest() {
        //1. Open test site by URL
        driver.get(URL);
        driver.manage().window().maximize();
        //2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Wrong browser title");
        //3. Perform login
        String username = "Roman";
        String pass = "Jdi1234";
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-icon"))).click();
        wait.until(ExpectedConditions.attributeToBe(By.className("uui-profile-menu"), "class",
                "dropdown uui-profile-menu open"));
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        //4. Assert Username is logged
        WebElement userName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), "ROMAN IOVLEV");
        //5.Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("Service")).click();
        driver.findElement(By.linkText("Different elements")).click();
        //6. Select checkboxes "Water", "Wind"
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space() = 'Water']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space() = 'Wind']"))).click();
        //7. Select radio "Selen"
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space() = 'Selen']"))).click();
        //8.Select in dropdown "Yellow"
        new Select(driver.findElement(By.cssSelector(".colors select"))).selectByVisibleText("Yellow");
        //9.Assert that
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        WebElement waterCheckboxLog = driver.findElement(By.xpath("//li[contains(text(),'Water: condition changed to true')]"));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Water checkbox log is not displayed");

        WebElement windCheckboxLog = driver.findElement(By.xpath("//li[contains(text(),'Wind: condition changed to true')]"));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Wind checkbox log is not displayed");
        //    • for radio button there is a log row and value is corresponded to the status of radio button
        WebElement selenRadioLog = driver.findElement(By.xpath("//li[contains(text(),'metal: value changed to  Selen')]"));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Selen radio log is not displayed");
        //    • for dropdown there is a log row and value is corresponded to the selected value
        WebElement dropdownColorsLog = driver.findElement(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]"));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Colors dropdown log is not displayed");
        softAssert.assertAll();
        //12. Close Browser
        //tearDown() method in AbstractTestBase
    }
}
