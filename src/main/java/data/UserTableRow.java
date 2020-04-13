package data;

import java.util.Objects;

public class UserTableRow {
    private String number;
    private String user;
    private String description;

    public UserTableRow() {
    }

    public UserTableRow(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTableRow that = (UserTableRow) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(user, that.user) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, description);
    }
}
