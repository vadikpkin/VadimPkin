package hw3.pages;

import hw3.components.LogSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private LogSection logSection;

    @FindBy(css = ".colors select")
    private WebElement colorsDropdown;

    @FindBy(className = "label-radio")
    private List<WebElement> radioElements;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.logSection = new LogSection(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckboxLogDisplayed(String checkboxName, String status){
        return logSection.isCheckboxLogDisplayed(checkboxName,  status);
    }

    public boolean isRadioLogDisplayed(String radioName) {
        return logSection.isRadioLogDisplayed(radioName);
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        return logSection.isDropdownLogDisplayed(dropdownValue);
    }

    public void setColorDropDown(String color) {
        colorsDropdown = wait.until(ExpectedConditions.visibilityOf(colorsDropdown));
        Select select = new Select(colorsDropdown);
        select.selectByVisibleText(color);
    }

    public void setCheckBox(String checkboxName) {
        clickElement(checkboxName, checkBoxElements);
    }

    public void setRadio(String radioName) {
        clickElement(radioName, radioElements);
    }

    private void clickElement(String name, List<WebElement> whereToClick){
        wait.until(ExpectedConditions.visibilityOfAllElements(whereToClick));
        for (WebElement checkBoxElement : whereToClick) {
            if(!checkBoxElement.isSelected() & checkBoxElement.getText().equals(name))
                checkBoxElement.click();
        }
    }
}
