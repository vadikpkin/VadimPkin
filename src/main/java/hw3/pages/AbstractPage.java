package hw3.pages;

import hw3.pages.components.HeaderMenu;
import hw3.pages.components.SideBarMenu;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected SideBarMenu sideBarMenu;

    protected HeaderMenu headerMenu;

}
