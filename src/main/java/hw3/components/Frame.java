package hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frame extends AbstractPageComposite {

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "button-frame")
    private WebElement button;

    public Frame(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame(){
        driver.switchTo().frame("frame");
    }

    public void switchToDefaultWindow(){
        driver.switchTo().defaultContent();
    }

    public boolean isButtonDisplayed(){
        return button.isDisplayed();
    }

    public boolean isFrameDisplayed(){
        return frame.isDisplayed();
    }

}
