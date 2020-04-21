package hw_jdi.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw_jdi.entities.MetalsAndColorsData;

import static java.util.Arrays.*;


public class MetalsAndColorsPage extends WebPage {
    @JDropdown(root = "div[id=colors]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown color;

    @JDropdown(root = "div[id=metals]",
            value = "input",
            list = "li",
            expand = ".caret")
    private Dropdown metal;

    @JDropdown(root = "div[id=vegetables]",
            value = "button",
            list = "li",
            expand = ".caret")
    private Dropdown vegetable;


    @UI("[name=custom_radio_odd]")
    private RadioButtons odd;

    @UI("[name=custom_radio_even]")
    private RadioButtons even;

    @Css("#elements-checklist input")
    private Checklist elements;

    @Css("#submit-button")
    private Button submit;

    @Css(".results")
    public Section results;

    public void fillForm(MetalsAndColorsData data) {
        odd.select(String.valueOf(data.getOdd()));
        even.select(String.valueOf(data.getEven()));
        color.select(data.getColor());
        metal.select(data.getMetals());
        if (!asList(data.getVegetables()).contains("Vegetables")) {
            vegetable.select("Vegetables");
        }
        for (String dataVegetable : data.getVegetables()) {
            if (!"Vegetables".equals(dataVegetable)) {
                vegetable.select(dataVegetable);
            }
        }
        for (String element : data.getElements()) {
            elements.select(element);
        }
        submit.click();
    }
}
