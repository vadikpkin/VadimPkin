package hw4.ex1;

import hw4.TestBase.TestBase;
import hw4.data.User;
import hw4.pages.IndexPage;
import hw4.pages.TablePage;
import hw4.util.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ExerciseOneTest extends TestBase {

    @Test
    public void tablePageFuncTest() {
        //1. Open test site by URL
        openTestSite();
        //2. Assert Browser title
        IndexPage indexPage = new IndexPage(driver);
        assertEquals(indexPage.getBrowserTitle(), "Home Page");
        //3. Perform login
        User user = User.builder()
                .setPassword(PropertyReader.read("password"))
                .setUsername(PropertyReader.read("user"))
                .build();
        indexPage.login(user);
        //4. Assert that user is logged
        assertEquals(indexPage.getUserName(), "ROMAN IOVLEV");
        assertTrue(indexPage.isUserNameDisplayed());
        //5. Open through the header menu Service -&gt; Table with pages
        indexPage.goToTableWithPagesPage();
        //6. Check that default value for “Show entries” dropdown is 5
        TablePage tablePage = new TablePage(driver);
        assertEquals(tablePage.getDropdownValue(), "5");
        //7.Select new value for the entries in the dropdown list
        tablePage.setDropdownValue("10");
        //8. Assert that in the table displayed corrected amount of rows
        assertEquals(tablePage.getTableRowsCount(), 10);
        //9. Type in “Search” field text "junit"
        String searchValue = "junit";
        tablePage.searchFor(searchValue);
        //10. Assert the table contains only records with Search field value
        assertTrue(tablePage.isSearchByCorrect("junit"));
    }
}
