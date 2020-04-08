package hw3.ex1;

import hw3.base.TestBase;
import hw3.pages.IndexPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;
import java.util.Arrays;
import java.util.List;

public class Exercise1 extends TestBase {

    @Test
    public void loginTest() {
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
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(indexPage.isHeaderMenuItemsDisplayed());
        List<String> actualHeaderMenuItemsText = indexPage.getHeaderMenuText();
        List<String> expectedHeaderMenuItemsText = Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS");
        softAssert.assertEquals(actualHeaderMenuItemsText.size(), 4);
        softAssert.assertEquals(actualHeaderMenuItemsText, expectedHeaderMenuItemsText);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(indexPage.getBenefitImagesCount(), 4);
        softAssert.assertTrue(indexPage.isBenefitIconsDisplayed());
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> actualBenefitTexts = indexPage.getBenefitTexts();
        List<String> expectedBenefitTexts = Arrays.asList("To include good practices\n" +
                                                          "and ideas from successful\n" +
                                                          "EPAM project",
                                                          "To be flexible and\n" +
                                                          "customizable", "To be multiplatform",
                                                          "Already have good base\n"+
                                                          "(about 20 internal and\n" +
                                                          "some external projects),\n" +
                                                          "wish to get more…");
        softAssert.assertEquals(actualBenefitTexts,expectedBenefitTexts);
        softAssert.assertEquals(indexPage.getBenefitTextsCount(), 4);
        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(indexPage.isFrameDisplayed());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToFrame();
        softAssert.assertTrue(indexPage.isFrameButtonDisplayed());
        //10. Switch to original window back
        indexPage.switchToDefault();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(indexPage.getSidebarElementsCount(), 5);
        softAssert.assertTrue(indexPage.isSidebarElementsDisplayed());
        List<String> expectedSideBarElementsText = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        List<String> actualSideBarElementsText = indexPage.getSideBarMenuElementsText();
        softAssert.assertEquals(actualSideBarElementsText, expectedSideBarElementsText);
        softAssert.assertAll();
    }
}
