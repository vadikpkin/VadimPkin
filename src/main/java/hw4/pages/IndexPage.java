package hw4.pages;

import hw4.components.HeaderMenu;
import hw4.components.SideBarMenu;
import hw4.data.User;
import org.openqa.selenium.WebDriver;


public class IndexPage extends AbstractPage {

    public IndexPage(WebDriver driver) {
        super(driver);
        this.headerMenu = new HeaderMenu(driver);
        this.sideBarMenu = new SideBarMenu(driver);
    }

    public void login(User user) {
        headerMenu.login(user);
    }

    public boolean isUserNameDisplayed() {
        return headerMenu.isUserNameDisplayed();
    }

    public String getUserName() {
        return headerMenu.getUserName();
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void goToTableWithPagesPage() {
        headerMenu.goToTableWithPagesPage();
    }

    public void goToMetalColorPage() {
        headerMenu.goToMetalColorPage();
    }

}
