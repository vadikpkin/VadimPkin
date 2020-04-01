package hw3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.stream.Collectors;

public class HeaderMenu extends AbstractPageComposite{
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement submitLoginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".m-l8 > li")
    List<WebElement> headerMenuElements;

    @FindBy(css = ".m-l8 .dropdown")
    private WebElement serviceMenu;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass){
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
        wait.until(ExpectedConditions.attributeToBe(By.className("uui-profile-menu"), "class",
                "dropdown uui-profile-menu open"));
        wait.until(ExpectedConditions.elementToBeClickable(userNameInputField)).sendKeys(user);
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputField)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(submitLoginButton)).click();
    }

    public boolean isUserNameDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(userName)).isDisplayed();
    }

    public String getUserName(){
        return wait.until(ExpectedConditions.visibilityOf(userName)).getText();
    }

    public List<String> getHeaderMenuElementsText(){
        wait.until(ExpectedConditions.visibilityOfAllElements(headerMenuElements));
        return headerMenuElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isHeaderMenuItemsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfAllElements(headerMenuElements));
        boolean isDisplayed = false;
        for (WebElement element : headerMenuElements) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }

    public void goToDifferentElementPage(){
        wait.until(ExpectedConditions.visibilityOf(serviceMenu)).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".m-l8 .dropdown"),"class","dropdown open"));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("DIFFERENT ELEMENTS"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("main-content-hg")));
    }
}
