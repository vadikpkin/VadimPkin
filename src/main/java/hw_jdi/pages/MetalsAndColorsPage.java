package hw_jdi.pages;

import com.epam.jdi.light.common.FormFilters;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw_jdi.entities.MetalsAndColorsData;
import hw_jdi.pages.forms.MetalsAndColorsForm;

public class MetalsAndColorsPage extends WebPage {

    @Css(".form")
    private MetalsAndColorsForm form;

    @UI("#odds-selector p")
    private RadioButtons odd;

    public void fillForm() {
        MetalsAndColorsData metalsAndColorsData = new MetalsAndColorsData(new int[]{1, 4}, "Yellow", "Gold",
                new String[]{"Onion", "Tomato"}, new String[]{"Fire", "Water"} );
        form.setFilter(FormFilters.OPTIONAL);fill();
    }

}
