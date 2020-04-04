package hw4.pages;

import hw4.components.Colors;
import hw4.components.Metals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class MetalsColorsPage extends AbstractPage {

    @FindBy(css = ".horizontal-group > p")
    private List<WebElement> summaryRadio;

    @FindBy(css = "#elements-checklist > p")
    private List<WebElement> elements;

    @FindBy(css = ".colors .bootstrap-select")
    private WebElement colorsSelect;

    @FindBy(css = "#colors ul > li")
    private List<WebElement> colorsDropdownElements;

    @FindBy(css = ".metals .bootstrap-select")
    private WebElement metalsSelect;

    @FindBy(css = ".metals .caret")
    private WebElement metalsCaret;

    @FindBy(css = "#metals ul > li")
    private List<WebElement> metalsDropdownElements;


    public MetalsColorsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setColor(Colors color) {
        wait.until(ExpectedConditions.visibilityOf(colorsSelect)).click();
        wait.until(ExpectedConditions
                .attributeToBe(colorsSelect, "class", "btn-group bootstrap-select uui-form-element open"));
        for (WebElement colorsDropdownElement : colorsDropdownElements) {
            if (colorsDropdownElement.getText().equalsIgnoreCase(color.toString()))
                colorsDropdownElement.click();
        }
    }

    public void setMetal(Metals metal) {
        wait.until(ExpectedConditions.visibilityOf(metalsCaret)).click();
        wait.until(ExpectedConditions
                .attributeToBe(metalsSelect, "class", "btn-group bootstrap-select uui-form-element open"));
        for (WebElement webElementMetal : metalsDropdownElements) {
            if (webElementMetal.getText().equalsIgnoreCase(metal.toString()))
                webElementMetal.click();
        }
    }


}
