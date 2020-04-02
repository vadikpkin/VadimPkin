package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TablePage extends AbstractPage {
    @FindBy(name = "table-with-pages_length")
    private WebElement showDropdown;

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public String getShowDropdownValue(){
        Select select = new Select(showDropdown);
        return select.getAllSelectedOptions().toString();
    }
}
