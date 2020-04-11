package hw4.pages;

import hw4.components.HeaderMenu;
import hw4.components.SideBarMenu;
import org.openqa.selenium.WebDriver;
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