package hw5.ex1;

import hw5.base.TestBase;
import hw5.steps.IndexPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyReader;
import java.util.Arrays;

@Feature("Index page func testing")
public class Exercise1 extends TestBase {

    private IndexPageSteps indexPageSteps;

    @BeforeMethod
    public void init() {
        indexPageSteps = new IndexPageSteps(driver);
    }

    @Story("Login on index page and assert web elements on page")
    @Test
    public void loginTest() {
        //1. Open test site by URL

        indexPageSteps.open();
        // 2. Assert Browser title

        indexPageSteps.browserTitleShouldBe("Home Page");
        //3. Perform login

        indexPageSteps.login(PropertyReader.read("user"), PropertyReader.read("password"));
        //4. Assert Username is logged

        indexPageSteps.usernameShouldBeDisplayed();
        indexPageSteps.headerMenuShouldHaveSize(4);
        indexPageSteps.usernameShouldBe("ROMAN IOVLEV");
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts

        indexPageSteps.headerMenuShouldBeDisplayed();
        indexPageSteps.headerMenuShouldBe(Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS"));
        //6. Assert that there are 4 images on the Index Page and they are displayed

        indexPageSteps.amountOfImagesShouldBe(4);
        indexPageSteps.imagesOnIndexPageShouldBeDisplayed();
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text

        indexPageSteps.amountOfTextsUnderImagesShouldBe(4);
        indexPageSteps.textsUnderImagesShouldBe(Arrays.asList("To include good practices\n" +
                                                                         "and ideas from successful\n" +
                                                                                        "EPAM project",
                                                                                "To be flexible and\n" +
                                                                 "customizable", "To be multiplatform",
                                                                            "Already have good base\n"+
                                                                            "(about 20 internal and\n" +
                                                                          "some external projects),\n" +
                                                                                   "wish to get more…"));
        //8. Assert that there is the iframe with “Frame Button” exist

        indexPageSteps.frameWithButtonShouldBeDisplayed();
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe

        indexPageSteps.switchToFrameWithButton();
        indexPageSteps.buttonInFrameShouldBeDisplayed();
        //10. Switch to original window back
        indexPageSteps.switchToOriginalWindow();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text

        indexPageSteps.amountOfItemsOnLeftSectionShouldBe(5);
        indexPageSteps.leftSectionItemsShouldBeDisplayed();
        indexPageSteps.leftSectionShouldBe(Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs"));
    }
}
