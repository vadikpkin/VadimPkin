package utils;

import data.UserTableRow;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;

public final class CalculationUtils {

    private CalculationUtils() {
    }

    public static String summ(String valueOne, String valueTwo) {
        return String.valueOf(Integer.parseInt(valueOne) + Integer.parseInt(valueTwo));
    }

    public static List<UserTableRow> convertToUserTableRowList(List<String> numbers, List<String> usernames, List<String> description) {
        List<UserTableRow> userTable = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            userTable.add(new UserTableRow(numbers.get(i), usernames.get(i), description.get(i)));
        }
        return userTable;
    }

    public static List<UserTableRow> convertUserDataToList(DataTable dataTable) {
        List<UserTableRow> expectedUserTable = new ArrayList<>();
        List<List<String>> dataTableRows = dataTable.asLists(String.class);
        for (List<String> columns : dataTableRows) {
            expectedUserTable.add(new UserTableRow(columns.get(0), columns.get(1), columns.get(2)));
        }
        //to remove columns Titles
        expectedUserTable.remove(0);
        return expectedUserTable;
    }

}
