package hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Frame extends AbstractPageComposite {

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "button-frame")
    private WebElement button;

    public Frame(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    public void switchToDefaultWindow(){
        driver.switchTo().defaultContent();
    }

    public boolean isButtonDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(button));
        return button.isDisplayed();
    }

    public boolean isFrameDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(frame));
        return frame.isDisplayed();
    }

}
