package hw6.entities;

import java.util.Objects;

public class JdiUser {
    private String numberType;
    private String user;
    private String description;

    public JdiUser(String numberType, String user, String description) {
        this.numberType = numberType;
        this.user = user;
        this.description = description;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JdiUser{" +
                "numberType='" + numberType + '\'' +
                ", user='" + user + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JdiUser jdiUser = (JdiUser) o;
        return Objects.equals(numberType, jdiUser.numberType) &&
                Objects.equals(user, jdiUser.user) &&
                Objects.equals(description, jdiUser.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberType, user, description);
    }
}
