package hw6.steps;

import data.UserTableRow;
import hw3.pages.DifferentElementsPage;
import hw3.pages.UserTablePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import utils.CalculationUtils;
import utils.WebDriverSingleton;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenSteps {

    private DifferentElementsPage differentElementsPage;
    private UserTablePage userTablePage;

    @Then("For each checkboxes {string} and {string} there is an individual log row and value is corresponded to the status of checkbox")
    public void iAssertCheckboxLogsOnDifferentElementsPage(String checkboxOne, String checkBoxTwo) {
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkboxOne, "true"));
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkBoxTwo, "true"));
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

    @Then("User table should contain following values:")
    public void iAssertContentOfTableOnUserTablePAge(DataTable dataTable) {
        List<UserTableRow> actualUserTable = CalculationUtils
                .convertToUserTableRowList(userTablePage.getUsersIds(), userTablePage.getUsersNames(), userTablePage.getUsersImagesDescriptions());
        List<UserTableRow> expectedUserTable = CalculationUtils.convertUserDataToList(dataTable);
        assertThat(actualUserTable).isEqualTo(expectedUserTable);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void iAssertRolesOfUser(List<String> args) {
        List<String> actualUserRoles = userTablePage.getUserRoles("Roman");
        List<String> expectedUserRoles = args.subList(1,args.size());
        assertThat(actualUserRoles).isEqualTo(expectedUserRoles);
    }

    @Then("1 log row has {string} text in log section")
    public void iAssertLogRow(String expectedLogText) {
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertTrue(userTablePage.isLogTextDisplayed(expectedLogText));
    }
}
