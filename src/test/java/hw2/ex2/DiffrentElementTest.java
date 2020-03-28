package hw2.ex2;

import hw2.AbstractTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DiffrentElementTest extends AbstractTestBase {

    private final static String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @Test
    public void testName() {
        //1. Open test site by URL
        driver.get(URL);
        driver.manage().window().maximize();
        //2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Wrong browser title");
        //3. Perform login
        String username = "Roman";
        String pass = "Jdi1234";

        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-icon"))).click();

        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        //4. Assert Username is logged
        WebElement userName = driver.findElement(By.id("user-name"));

        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), "ROMAN IOVLEV");
        //5.Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("Service")).click();
        driver.findElement(By.linkText("Different elements")).click();
        //6. Select checkboxes Water, Wind
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("label-checkbox")));

        List<WebElement> checkboxList = driver.findElements(By.className("label-checkbox"));
        for (WebElement webElement : checkboxList) {
            if(webElement.getText().equals("Water") | webElement.getText().equals("Wind"))
            webElement.click();
        }
        //7. Select radio Selen
        List<WebElement> radioList = driver.findElements(By.className("label-radio"));
        for (WebElement webElement : radioList) {
            if(webElement.getText().equals("Selen"))
                webElement.click();
        }
        //8.Select in dropdown Yellow
        new Select(driver.findElement(By.cssSelector(".colors select"))).selectByVisibleText("Yellow");
        //9.Assert that
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //    • for radio button there is a log row and value is corresponded to the status of radio button
        //    • for dropdown there is a log row and value is corresponded to the selected value. 
        WebElement waterCheckboxLog = driver.findElement(By.xpath("//li[contains(text(),'Water: condition changed to true')]"));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Water checkbox log is not displayed");

        WebElement windCheckboxLog = driver.findElement(By.xpath("//li[contains(text(),'Wind: condition changed to true')]"));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Wind checkbox log is not displayed");

        WebElement selenRadioLog = driver.findElement(By.xpath("//li[contains(text(),'metal: value changed to  Selen')]"));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Selen radio log is not displayed");

        WebElement dropdownColorsLog = driver.findElement(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]"));
        softAssert.assertTrue(waterCheckboxLog.isDisplayed(),"Colors dropdown log is not displayed");

        softAssert.assertAll();
    }
}
