package hw4.ex1;

import hw4.TestBase.TestBase;
import hw4.pages.IndexPage;
import hw4.pages.TablePage;
import hw4.util.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ExerciseOneTest extends TestBase {

    @Test
    public void testsmgt() {
        //1. Open test site by URL
        openTestSite();
        //2. Assert Browser title
        IndexPage indexPage = new IndexPage(driver);
        assertEquals(indexPage.getBrowserTitle(), "Home Page");
        //3. Perform login
        indexPage.login(PropertyReader.read("user"), PropertyReader.read("password"));
        //4. Assert that user is logged
        assertEquals(indexPage.getUserName(), "ROMAN IOVLEV");
        assertTrue(indexPage.isUserNameDisplayed());
        //5. Open through the header menu Service -&gt; Table with pages
        indexPage.goToTableWithPagesPage();
        //6. Check that default value for “Show entries” dropdown is 5
        TablePage tablePage = new TablePage(driver);
        System.out.println(new Select(driver.findElement(By.className("uui-form-element"))).getAllSelectedOptions());
    }
}
