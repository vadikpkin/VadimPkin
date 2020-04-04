package hw4.pages;

import hw4.components.HeaderMenu;
import hw4.components.SideBarMenu;
import hw4.data.User;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class IndexPage extends AbstractPage{

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.sideBarMenu = new SideBarMenu(driver);
    }

    public void login(User user){
        headerMenu.login(user);
    }

    public boolean isUserNameDisplayed(){
        return headerMenu.isUserNameDisplayed();
    }

    public String getUserName(){
        return headerMenu.getUserName();
    }

    public String getBrowserTitle(){
        return driver.getTitle();
    }

    public List<String> getHeaderMenuText(){
        return headerMenu.getHeaderMenuElementsText();
    }

    public boolean isHeaderMenuItemsDisplayed(){ return headerMenu.isHeaderMenuItemsDisplayed(); }


    public boolean isSidebarElementsDisplayed(){
        return sideBarMenu.isSidebarElementsDisplayed();
    }

    public List<String> getSideBarMenuElementsText(){ return sideBarMenu.getSideBarMenuElementsText(); }

    public int getSidebarElementsCount(){
        return sideBarMenu.getSidebarElementsCount();
    }

    public void goToTableWithPagesPage(){ headerMenu.goToTableWithPagesPage(); }

    public void goToMetalColorPage(){ headerMenu.goToMetalColorPage(); }

}
