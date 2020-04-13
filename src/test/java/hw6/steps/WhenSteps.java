package hw6.steps;

import hw3.pages.DifferentElementsPage;
import hw3.pages.UserTablePage;
import io.cucumber.java.en.When;
import utils.WebDriverSingleton;

public class WhenSteps {

    private DifferentElementsPage differentElementsPage;
    private UserTablePage userTablePage;

    @When("I select checkboxes {string}, {string}")
    public void iSelectCheckboxesOnDifferentElementsPage(String firstCheckbox, String secondCheckbox) {
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        differentElementsPage.setCheckBox(firstCheckbox);
        differentElementsPage.setCheckBox(secondCheckbox);
    }

    @When("I select radio {string}")
    public void iSelectRadioOnDifferentElementsPage(String radio) {
        differentElementsPage.setRadio(radio);
    }

    @When("I select dropdown {string}")
    public void iSelectDropdownOnDifferentElementsPage(String color) {
        differentElementsPage.setColorDropDown(color);
    }

    @When("I select 'vip' checkbox for {string}")
    public void iSetCheckbox(String username) {
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        userTablePage.setVipCheckbox(username);
    }

}
