package hw3.pages;

import hw3.pages.components.CheckboxRow;
import hw3.pages.components.Logs;
import hw3.pages.components.RadioRow;
import org.openqa.selenium.WebDriver;

public class DiffrentElementsPage extends AbstractPage{

    private Logs log;

    private CheckboxRow checkboxRow;

    private RadioRow radioRow;

    public DiffrentElementsPage(WebDriver driver,Logs log) {
        this.driver = driver;
        this.log = log;
        this.checkboxRow = new CheckboxRow(driver);
        this.radioRow = new RadioRow(driver);
    }

    public void setCheckbox(String checkboxName){
        checkboxRow.setCheckBox(checkboxName);
    }

    public void setRadioRow(String radioRowName){
        radioRow.setRadio(radioRowName);
    }
}
