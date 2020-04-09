package hw5.steps;

import hw3.pages.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPageSteps {

    private final static String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private WebDriver driver;
    private IndexPage indexPage;

    public IndexPageSteps(WebDriver driver) {
        this.driver = driver;
        indexPage = new IndexPage(driver);
    }

    @Step("I opened Index page")
    public void open() {
        driver.get(URL);
    }

    @Step("Browser title should be '{0}'")
    public void browserTitleShouldBe(String expectedValue) {
        String actualValue = driver.getTitle();
        assertEquals(actualValue, expectedValue);
    }

    @Step("I login as username:'{0}' password:'{1}'")
    public void login(String username, String password) {
        indexPage.login(username, password);
    }

    @Step("User name should be displayed")
    public void usernameShouldBeDisplayed() {
        assertTrue(indexPage.isUserNameDisplayed());
    }

    @Step("User name should be '{0}'")
    public void usernameShouldBe(String value) {
        assertEquals(indexPage.getUserName(), value);
    }

    @Step("Header menu should be displayed")
    public void headerMenuShouldBeDisplayed() {
        assertTrue(indexPage.isHeaderMenuItemsDisplayed());
    }

    @Step("Header section should have '{0}' items")
    public void headerMenuShouldHaveSize(int amountOfItems) {
        assertEquals(indexPage.getHeaderMenuText().size(), amountOfItems);
    }

    @Step("Header menu should be '{0}'")
    public void headerMenuShouldBe(List<String> expectedHeaderText) {
        List<String> actualHeaderMenuItemsText = indexPage.getHeaderMenuText();
        assertEquals(actualHeaderMenuItemsText.size(), 4);
        assertEquals(actualHeaderMenuItemsText, expectedHeaderText);
    }

    @Step("Index page should have '{0}' images")
    public void amountOfImagesShouldBe(int amountOfItems) {
        assertEquals(indexPage.getBenefitImagesCount(), amountOfItems);
    }

    @Step("Images on Index page should be displayed")
    public void imagesOnIndexPageShouldBeDisplayed() {
        assertTrue(indexPage.isBenefitIconsDisplayed());
    }

    @Step("Index page should have '{0}' texts under images")
    public void amountOfTextsUnderImagesShouldBe(int amountOfItems) {
        assertEquals(indexPage.getBenefitTexts().size(), amountOfItems);
    }

    @Step("Texts under images on Index page should be '{}'")
    public void textsUnderImagesShouldBe(List<String> expectedText) {
        List<String> actualBenefitTexts = indexPage.getBenefitTexts();
        assertEquals(actualBenefitTexts, expectedText);
    }

    @Step("Frame with button should be displayed")
    public void frameWithButtonShouldBeDisplayed() {
        assertTrue(indexPage.isFrameDisplayed());
    }

    @Step("Switch to frame with button")
    public void switchToFrameWithButton() {
        indexPage.switchToFrame();
    }

    @Step("Button in frame should be displayed")
    public void buttonInFrameShouldBeDisplayed() {
        assertTrue(indexPage.isFrameButtonDisplayed());
    }

    @Step("Switch back to default")
    public void switchToOriginalWindow() {
        indexPage.switchToDefault();
    }

    @Step("Index page should have '{0}' items in left section")
    public void amountOfItemsOnLeftSectionShouldBe(int value) {
        assertEquals(indexPage.getSidebarElementsCount(), value);
    }

    @Step("Left section should be '{0}'")
    public void leftSectionShouldBe(List<String> expectedText) {
        assertEquals(indexPage.getSideBarMenuElementsText(), expectedText);
    }

    @Step("Left section elements should be displayed")
    public void leftSectionItemsShouldBeDisplayed() {
        assertTrue(indexPage.isSidebarElementsDisplayed());
    }

}
