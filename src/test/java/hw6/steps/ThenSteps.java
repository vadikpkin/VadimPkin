package hw6.steps;

import hw3.pages.DifferentElementsPage;
import hw3.pages.UserTablePage;
import hw6.entities.JdiUser;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import utils.WebDriverSingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenSteps {

    private DifferentElementsPage differentElementsPage;
    private UserTablePage userTablePage;

    @Then("For each checkbox there is an individual log row and value is corresponded to the status of checkbox")
    public void iAssertCheckboxLogsOnDifferentElementsPage(List<String> checkboxes) {
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        checkboxes = checkboxes.subList(1, checkboxes.size());
        checkboxes.forEach(e -> assertTrue(differentElementsPage.isCheckboxLogDisplayed(e, "true")));
    }

    @Then("For radio button {string} there is a log row and value is corresponded to the status of radio button")
    public void iAssertRadioLogsOnDifferentElementsPage(String radioName) {
        assertTrue(differentElementsPage.isRadioLogDisplayed(radioName));
    }

    @Then("For dropdown value {string} there is a log row and value is corresponded to the selected value")
    public void iAssertDropdownLogsOnDifferentElementsPage(String color) {
        assertTrue(differentElementsPage.isDropdownLogDisplayed(color));
    }

    @Then("User Table page should be opened")
    public void iAssertTablePageTitle() {
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.getTitle(), "User Table");
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void iAssertDropdownsOnUserTablePage(int expectedDropdownsAmount) {
        assertEquals(userTablePage.getUsersSelects().size(), expectedDropdownsAmount);
        assertTrue(userTablePage.isUsersDropdownsDisplayed());
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void iAssertUsernamesOnUserTablePage(int expectedUsernamesAmount) {
        assertEquals(userTablePage.getUsersNames().size(), expectedUsernamesAmount);
        assertTrue(userTablePage.isUsersNamesDisplayed());
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void iAssertDescriptionsUnderImagesOnUserTablePage(int expectedDescriptionsAmount) {
        assertEquals(userTablePage.getUsersImagesDescriptions().size(), expectedDescriptionsAmount);
        assertTrue(userTablePage.isUsersImagesDescriptionDisplayed());
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void iAssertCheckboxesOnUserTablePage(int expectedCheckboxesAmount) {
        assertEquals(userTablePage.getUsersCheckboxes().size(), 6);
        assertTrue(userTablePage.isUsersCheckboxesDisplayed());
    }

    @DataTableType
    public JdiUser JdiUserEntry(Map<String, String> entry) {
        return new JdiUser(
                entry.get("numberType"),
                entry.get("user"),
                entry.get("description"));
    }

    @Then("User table should contain following values:")
    public void iAssertContentOfTableOnUserTablePAge(List<JdiUser> users) {
        List<JdiUser> actualUserTable = new ArrayList<>();
        List<String> numbers = userTablePage.getUsersIds();
        List<String> usernames = userTablePage.getUsersNames();
        List<String> description = userTablePage.getUsersImagesDescriptions();
        for (int i = 0; i < numbers.size(); i++) {
            actualUserTable.add(new JdiUser(numbers.get(i), usernames.get(i), description.get(i)));
        }
        assertThat(actualUserTable).isEqualTo(users);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void iAssertRolesOfUser(List<String> args) {
        List<String> actualUserRoles = userTablePage.getUserRoles("Roman");
        List<String> expectedUserRoles = args.subList(1, args.size());
        assertThat(actualUserRoles).isEqualTo(expectedUserRoles);
    }

    @Then("1 log row has {string} text in log section")
    public void iAssertLogRow(String expectedLogText) {
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertTrue(userTablePage.isLogTextDisplayed(expectedLogText));
    }
}
