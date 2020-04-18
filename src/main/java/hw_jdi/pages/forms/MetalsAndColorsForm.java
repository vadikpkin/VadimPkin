package hw_jdi.pages.forms;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw_jdi.entities.MetalsAndColorsData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {
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

}
