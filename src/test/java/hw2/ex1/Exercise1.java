package hw2.ex1;

import hw2.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class Exercise1 extends TestBase {

    @Test
    public void exerciseOneTest() {
        //1. Open test site by URL
        openTestSite();
        //2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Wrong browser title");
        //3. Perform login
        login("Roman", "Jdi1234");
        //4. Assert Username is logged
        softAssert.assertTrue(isUsernameDisplayed());
        softAssert.assertEquals(getUsername(), "ROMAN IOVLEV");
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".m-l8 > li")))
                        .size(), 4, "Wrong number of items in header");
        String expectedHeader = "HOME\n" +
                                "CONTACT FORM\n" +
                                "SERVICE\n" +
                                "METALS & COLORS";
        String actualHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("m-l8"))).getText();
        softAssert.assertEquals(actualHeader, expectedHeader, "Wrong header");
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitImages = wait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-icon")));
        benefitImages.forEach(e -> softAssert.assertTrue(e.isDisplayed()));
        softAssert.assertEquals(benefitImages.size(), 4, "Wrong amount of images");
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-txt")))
                        .size(),4, "Wrong amount of benefit texts");
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
        String actualTextUnderIcons = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("benefits"))).getText();
        softAssert.assertEquals(actualTextUnderIcons, expectedTextUnderIcons, "Wrong text under icons");
        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement iFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame")));
        softAssert.assertTrue(iFrame.isDisplayed());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        WebElement iFrameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-frame")));
        softAssert.assertTrue(iFrameButton.isDisplayed());
        //10. Switch to original window back
        driver.switchTo().defaultContent();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sideBarMenu = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".sidebar-menu > li")));
        softAssert.assertEquals(sideBarMenu.size(), 5, "Wrong amount of elements on sidebar");
        sideBarMenu.forEach(elem -> softAssert.assertTrue(elem.isDisplayed()));
        String expectedSideBarMenuText = "Home\n" +
                                         "Contact form\n" +
                                         "Service\n" +
                                         "Metals & Colors\n" +
                                         "Elements packs";
        String actualSideBarMenuText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-menu")))
                .getText();
        softAssert.assertEquals(actualSideBarMenuText, expectedSideBarMenuText,
                "Wrong sidebar menu text");
        softAssert.assertAll();
        //12. Close Browser
        //tearDown() method in TestBase
    }

}
