package hw4.ex2;

import hw4.TestBase.TestBase;
import hw4.components.Colors;
import hw4.components.Metals;
import hw4.data.User;
import hw4.pages.IndexPage;
import hw4.pages.MetalsColorsPage;
import hw4.util.PropertyReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExerciseTwoTest extends TestBase {

    @Test
    public void metalsColorsPageFuncTest() throws InterruptedException {
        //1. Open test site by URL
        openTestSite();
        IndexPage indexPage = new IndexPage(driver);
        assertEquals(indexPage.getBrowserTitle(), "Home Page");
        //2. Perform login
        User user = User
                .builder()
                .setPassword(PropertyReader.read("password"))
                .setUsername(PropertyReader.read("user"))
                .build();
        indexPage.login(user);
        //3. Click on the link on the Header section
        indexPage.goToMetalColorPage();
        //4. Fill form on the page
        MetalsColorsPage metalsColorsPage = new MetalsColorsPage(driver);
        metalsColorsPage.setColor(Colors.BLUE);
        metalsColorsPage.setMetal(Metals.BRONZE);
        Thread.sleep(1500);
    }
}
