package hw3.pages;

import hw3.components.HeaderMenu;
import hw3.components.SideBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected SideBarMenu sideBarMenu;

    protected HeaderMenu headerMenu;

    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }
}
