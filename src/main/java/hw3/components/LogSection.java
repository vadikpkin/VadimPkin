package hw3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LogSection extends AbstractPageComposite {

    @FindBy(css = ".logs li")
    private List<WebElement> logs;

    public LogSection(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("info-panel-body-log")));
    }

    public boolean isCheckboxLogDisplayed(String checkboxName, String status) {
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains(checkboxName + ": condition changed to " + status))
                isDisplayed = true;
        }
        return isDisplayed;
    }


    public boolean isRadioLogDisplayed(String radioName) {
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains("metal: value changed to " + radioName))
                isDisplayed = true;
        }
        return isDisplayed;
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains("Colors: value changed to " + dropdownValue))
                isDisplayed = true;
        }
        return isDisplayed;
    }
}
