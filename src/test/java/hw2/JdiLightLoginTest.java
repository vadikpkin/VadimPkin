package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JdiLightLoginTest extends AbstractTestBase{

    private final static String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @Test
    public void loginTest() throws InterruptedException {
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
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        //4. Assert Username is logged
        WebElement userName = driver.findElement(By.id("user-name"));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), "ROMAN IOVLEV");
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String expectedHeader = "HOME\n" +
                                "CONTACT FORM\n" +
                                "SERVICE\n" +
                                "METALS & COLORS";
        String actualHeader = driver.findElement(By.className("m-l8")).getText();
        softAssert.assertEquals(actualHeader, expectedHeader, "Wrong header");
        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(driver.findElements(By.className("benefit-icon")).size(), 4, "Wrong amount" +
                "of images");
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String expectedTextUnderIcons = "To include good practices\n" +
                                        "and ideas from successful\n" +
                                        "EPAM project\n" +
                                        "To be flexible and\n" +
                                        "customizable\n" +
                                        "To be multiplatform\n" +
                                        "Already have good base\n" +
                                        "(about 20 internal and\n" +
                                        "some external projects),\n" +
                                        "wish to get more…";
        String actualTextUnderIcons = driver.findElement(By.className("benefits")).getText();
        softAssert.assertEquals(actualTextUnderIcons, expectedTextUnderIcons, "Wrong text under icons");
        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(driver.findElement(By.id("frame")).isDisplayed());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssert.assertTrue(driver.findElement(By.id("button-frame")).isDisplayed());
        //10. Switch to original window back
        driver.switchTo().defaultContent();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sideBarMenu = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        sideBarMenu.forEach(elem -> softAssert.assertTrue(elem.isDisplayed()));
        List<String> expectedSideBarMenuText = new ArrayList<>();
        expectedSideBarMenuText.add("Home");
        expectedSideBarMenuText.add("Contact form");
        expectedSideBarMenuText.add("Service");
        expectedSideBarMenuText.add("Metals & Colors");
        expectedSideBarMenuText.add("Elements packs");
        List<String> sideBarMenuText = sideBarMenu.stream().map(elem -> elem.getText()).collect(Collectors.toList());
        softAssert.assertEquals(sideBarMenuText, expectedSideBarMenuText, "Wrong sidebar menu text");
        softAssert.assertAll();
        //12. Close Browser
        //tearDown() method in AbstractTestBase
    }

}
