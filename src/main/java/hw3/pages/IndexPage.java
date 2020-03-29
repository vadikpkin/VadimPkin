package hw3.pages;

import hw3.pages.components.Benefits;
import hw3.pages.components.Frame;
import hw3.pages.components.HeaderMenu;
import hw3.pages.components.SideBarMenu;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class IndexPage extends AbstractPage{

    private Benefits benefits;

    private Frame frame;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.benefits = new Benefits(driver);
        this.frame = new Frame(driver);
        this.sideBarMenu = new SideBarMenu(driver);
    }

    public void login(String username, String password){
        headerMenu.login(username, password);
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

    public int getBenefitImagesCount(){
        return benefits.getBenefitImagesCount();
    }

    public int getBenefitTextsCount(){
        return benefits.getBenefitTextsCount();
    }

    public List<String> getBenefitTexts(){
        return benefits.getBenefitTexts();
    }

    public boolean isBenefitIconsDisplayed(){
        return benefits.isBenefitIconsDisplayed();
    }

    public boolean isFrameDisplayed(){
        return frame.isFrameDisplayed();
    }

    public boolean isFrameButtonDisplayed(){
        return frame.isButtonDisplayed();
    }

    public void switchToFrame(){
        frame.switchToFrame();
    }

    public void switchToDefault(){
        frame.switchToDefaultWindow();
    }

    public boolean isSidebarElementsDisplayed(){
        return sideBarMenu.isSidebarElementsDisplayed();
    }

    public List<String> getSideBarMenuElementsText(){ return sideBarMenu.getSideBarMenuElementsText(); }

    public int getSidebarElementsCount(){
        return sideBarMenu.getSidebarElementsCount();
    }

    public void goToDifferentElementsPage(){
        headerMenu.goToDifferentElementPage();
    }
}
