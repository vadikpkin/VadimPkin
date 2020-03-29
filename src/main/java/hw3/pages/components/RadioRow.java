package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadioRow extends AbstractPageComposite{

    @FindBy(className = "label-radio")
    private List<WebElement> radioElements;

    public RadioRow(WebDriver driver) {
        super(driver);
    }

    public void setRadio(String checkboxName){
        for (WebElement checkBoxElement : radioElements) {
            if(!checkBoxElement.isSelected() & checkBoxElement.getText().equals(checkboxName))
                checkBoxElement.click();
        }
    }
}
