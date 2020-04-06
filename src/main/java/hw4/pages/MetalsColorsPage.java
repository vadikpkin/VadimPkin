package hw4.pages;

import hw4.components.*;
import hw4.data.FormData;
import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MetalsColorsPage extends AbstractPage {

    private Result result;

    @FindBy(css = "#odds-selector > p label")
    private List<WebElement> summaryRadioOdd;

    @FindBy(css = "#even-selector > p label")
    private List<WebElement> summaryRadioEven;

    @FindBy(css = "#elements-checklist label")
    private List<WebElement> elements;

    @FindBy(css = "#colors .bootstrap-select")
    private WebElement colors;

    @FindBy(css = "#colors ul > li")
    private List<WebElement> colorsDropdownElements;

    @FindBy(css = ".metals .bootstrap-select")
    private WebElement metals;

    @FindBy(css = ".metals .caret")
    private WebElement metalsCaret;

    @FindBy(css = "#metals ul > li")
    private List<WebElement> metalsDropdownElements;

    @FindBy(id = "vegetables")
    private WebElement vegetables;

    @FindBy(css = "#vegetables .dropdown-menu li")
    private List<WebElement> vegetablesDropdownElements;

    @FindBy(id = "submit-button")
    private WebElement submitButton;


    public MetalsColorsPage(WebDriver driver) {
        super(driver);
        result = new Result(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillForm(FormData form) {
        setColor(form.getColors());
        setMetal(form.getMetals());
        setVegetable(form.getVegetables());
        setElement(form.getElements());
        setEven(form.getEven());
        setOdd(form.getOdd());
    }

    public void setColor(String color) {
        if (!color.equalsIgnoreCase(Colors.COLORS.toString())) {
            setWebElement(colors, colorsDropdownElements, colors, color);
        }
    }

    public void setMetal(String metal) {
        if (!metal.equalsIgnoreCase(Metals.METALS.toString())) {
            setWebElement(metalsCaret, metalsDropdownElements, metals, metal);
        }
    }

    public void setVegetable(List<Vegetables> vegetable) {
        if (!vegetable.get(0).toString().equalsIgnoreCase(Vegetables.VEGETABLES.toString())) {
            wait.until(ExpectedConditions.elementToBeClickable(vegetables)).click();
            wait.until(ExpectedConditions
                    .attributeToBe(By.cssSelector("#vegetables .dropdown-menu"), "style", "display: block;"));
            // to uncheck vegetables checkbox, because by default it is checked
            driver.findElement(By.xpath("//*[@id='vegetables']//label[text()='Vegetables']")).click();
            for (Vegetables vegetableToSet : vegetable) {
                for (WebElement vegetablesDropdownElement : vegetablesDropdownElements) {
                    if (vegetablesDropdownElement.getText().equalsIgnoreCase(vegetableToSet.toString())) {
                        vegetablesDropdownElement.click();
                    }
                }
            }
        }
    }

    public void setElement(List<Elements> element) {
        if (element != null) {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            for (Elements elemToSet : element) {
                for (WebElement webElement : elements) {
                    if (webElement.getText().equalsIgnoreCase(elemToSet.toString())) {
                        webElement.click();
                    }
                }
            }
        }
    }

    public void setOdd(String value) {
        setNumber(value, summaryRadioOdd);
    }

    public void setEven(String value) {
        setNumber(value, summaryRadioEven);
    }

    private void setNumber(String value, List<WebElement> whereToSet) {
        if (!value.equals("2") | !value.equals("1")) {
            wait.until(ExpectedConditions.visibilityOfAllElements(whereToSet));
            for (WebElement webElement : whereToSet) {
                if (webElement.getText().equalsIgnoreCase(value)) {
                    webElement.click();
                }
            }
        }
    }

    private void setWebElement(WebElement elemToSet, List<WebElement> whatWaitToAppear, WebElement elemTocCheck, String valueToSet) {
        wait.until(ExpectedConditions.elementToBeClickable(elemToSet)).click();
        wait.until(ExpectedConditions
                .attributeToBe(elemTocCheck, "class", "btn-group bootstrap-select uui-form-element open"));
        for (WebElement colorsDropdownElement : whatWaitToAppear) {
            if (colorsDropdownElement.getText().equalsIgnoreCase(valueToSet)) {
                colorsDropdownElement.click();
            }
        }
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getSumResult() {
        return result.getSumResult();
    }

    public String getColorResult() {
        return result.getColorResult();
    }

    public String getMetalResult() {
        return result.getMetalResult();
    }

    public String getVegetableResult() {
        return result.getVegetableResult();
    }

    public String getElementsResult() {
        return result.getElementsResult();
    }

}
