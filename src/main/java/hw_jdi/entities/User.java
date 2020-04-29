package hw_jdi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import utils.PropertyReader;

@AllArgsConstructor
@Setter
@Getter
public class User {
    public static User ROMAN = new User(PropertyReader.read("user"),
            PropertyReader.read("password"),
            PropertyReader.read("fullusername"));
    private String login;
    private String password;
    private String fullName;

}
