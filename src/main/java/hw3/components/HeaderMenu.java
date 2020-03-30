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
    private WebElement serviceDropdown;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-icon"))).click();
        wait.until(ExpectedConditions.attributeToBe(By.className("uui-profile-menu"), "class",
                "dropdown uui-profile-menu open"));
        userNameInputField.sendKeys(user);
        passwordInputField.sendKeys(pass);
        submitLoginButton.click();
    }

    public boolean isUserNameDisplayed(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        return userName.isDisplayed();
    }

    public String getUserName(){
        return userName.getText();
    }

    public List<String> getHeaderMenuElementsText(){
        return headerMenuElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isHeaderMenuItemsDisplayed(){
        boolean isDisplayed = false;
        for (WebElement element : headerMenuElements) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }

    public void goToDifferentElementPage(){
        serviceDropdown.click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".m-l8 .dropdown"),"class","dropdown open"));
        driver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("main-content-hg")));
    }
}
