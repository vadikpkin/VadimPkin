package hw3.pages;

import hw3.components.LogSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends AbstractPage {

    private LogSection logSection;

    @FindBy(css = "#user-table tr")
    private List<WebElement> tableRows;

    @FindBy(css = "#user-table select")
    private List<WebElement> usersSelects;

    @FindBy(css = "#user-table a")
    private List<WebElement> usersNames;

    @FindBy(css = "#user-table span")
    private List<WebElement> usersImagesDescriptions;

    @FindBy(css = "#user-table input")
    private List<WebElement> usersCheckboxes;

    @FindBy(xpath = "//td[text()=number()]")
    private List<WebElement> usersIds;

    public UserTablePage(WebDriver driver) {
        super(driver);
        logSection = new LogSection(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<String> getUserRoles(String username) {
        waitForVisibilityOf(tableRows);
        for (WebElement webElement : tableRows) {
            if (webElement.getText().contains(username)) {
                return getListAsString(webElement.findElements(By.cssSelector("select option")));
            }
        }
        return null;
    }

    public void setVipCheckbox(String username) {
        waitForVisibilityOf(tableRows);
        for (WebElement webElement : tableRows) {
            if (webElement.getText().contains(username)) {
                webElement.findElement(By.tagName("input")).click();
            }
        }
    }

    public boolean isLogTextDisplayed(String logText) {
        return logSection.isLogTextDisplayed(logText);
    }

    public List<String> getUsersIds() {
        waitForVisibilityOf(usersIds);
        return getListAsString(usersIds);
    }

    public List<String> getUsersNames() {
        waitForVisibilityOf(usersNames);
        return getListAsString(usersNames);
    }

    public List<String> getUsersImagesDescriptions() {
        waitForVisibilityOf(usersImagesDescriptions);
        return getListAsString(usersImagesDescriptions);
    }

    public List<WebElement> getUsersSelects() {
        waitForVisibilityOf(usersSelects);
        return usersSelects;
    }

    public List<WebElement> getUsersCheckboxes() {
        waitForVisibilityOf(usersCheckboxes);
        return usersCheckboxes;
    }

    public boolean isUsersDropdownsDisplayed() {
        waitForVisibilityOf(usersSelects);
        return isDisplayed(usersSelects);
    }

    public boolean isUsersNamesDisplayed() {
        waitForVisibilityOf(usersNames);
        return isDisplayed(usersNames);
    }

    public boolean isUsersImagesDescriptionDisplayed() {
        waitForVisibilityOf(usersImagesDescriptions);
        return isDisplayed(usersImagesDescriptions);
    }

    public boolean isUsersCheckboxesDisplayed() {
        waitForVisibilityOf(usersCheckboxes);
        return isDisplayed(usersCheckboxes);
    }

    public boolean isUsersSelectsDisplayed() {
        waitForVisibilityOf(usersSelects);
        return isDisplayed(usersSelects);
    }

    private boolean isDisplayed(List<WebElement> elements) {
        boolean isDisplayed = false;
        for (WebElement element : elements) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }

    private List<String> getListAsString(List<WebElement> elements) {
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private void waitForVisibilityOf(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
