package hw_jdi.entities;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class User {
    private String login;
    private String password;
    private String fullName;
}
