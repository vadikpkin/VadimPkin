package hw_jdi;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw4.data.User;

public class LoginForm extends Form<User> {
    @Css("#user-icon")
    private Icon userIcon;

    @Css("#name")
    private TextField login;

    @Css("#password")
    private TextField password;

    @Css("#user-name")
    private Label fullName;
}
