package hw3.ex2;

import hw3.base.TestBase;
import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.PropertyReader;
import static org.testng.Assert.*;


public class Exercise2 extends TestBase {

    @Test
    public void differentElementPageFunctionalityTest() {
        //1. Open test site by URL
        openTestSite();
        IndexPage indexPage = new IndexPage(driver);
        //2. Assert Browser title
        assertEquals(indexPage.getBrowserTitle(), "Home Page");
        //3. Perform login
        indexPage.login(PropertyReader.read("user"), PropertyReader.read("password"));
        //4. Assert Username is logged
        assertTrue(indexPage.isUserNameDisplayed());
        assertEquals(indexPage.getUserName(), "ROMAN IOVLEV");
        //5.Open through the header menu Service -> Different Elements Page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        indexPage.goToDifferentElementsPage();
        //6. Select checkboxes "Water", "Wind"
        String checkBoxOne = "Water";
        String checkBoxTwo = "Wind";
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.setCheckBox(checkBoxOne);
        differentElementsPage.setCheckBox(checkBoxTwo);
        //7. Select radio "Selen"
        String radio = "Selen";
        differentElementsPage.setRadio(radio);
        //8.Select in dropdown "Yellow"
        String color = "Yellow";
        differentElementsPage.setColorDropDown(color);
        //9.Assert that
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkBoxOne, "true"));
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkBoxTwo, "true"));
        //    • for radio button there is a log row and value is corresponded to the status of radio button
        assertTrue(differentElementsPage.isRadioLogDisplayed(radio));
        //    • for dropdown there is a log row and value is corresponded to the selected value
        assertTrue(differentElementsPage.isDropdownLogDisplayed(color));
    }
}
