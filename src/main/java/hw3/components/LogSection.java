package hw3.components;

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
    }

    public boolean isCheckboxLogDisplayed(String checkboxName, String status) {
        waitForLogsToBeVisible();
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains(checkboxName + ": condition changed to " + status)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }


    public boolean isRadioLogDisplayed(String radioName) {
        waitForLogsToBeVisible();
        return isWebElementLogDisplayed(radioName, "metal: value changed to ");
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        waitForLogsToBeVisible();
        return isWebElementLogDisplayed(dropdownValue, "Colors: value changed to ");
    }

    public boolean isWebElementLogDisplayed(String value, String logText) {
        waitForLogsToBeVisible();
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains(logText + value)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

    private void waitForLogsToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElements(logs));
    }
}
