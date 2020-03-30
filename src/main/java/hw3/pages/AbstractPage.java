package hw3.pages;

import hw3.components.HeaderMenu;
import hw3.components.SideBarMenu;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected SideBarMenu sideBarMenu;

    protected HeaderMenu headerMenu;

}
