package hw_jdi.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import hw_jdi.pages.forms.LoginForm;
import hw_jdi.entities.User;

public class HomePage extends WebPage {
    @Css("#login-form")
    private LoginForm loginForm;

    @Css(".m-l8 [*'%s']")
    public Menu headerMenu;

    @Css("#user-icon")
    private Icon userIcon;

    @Css("#user-name")
    public Label usersFullName;

    public String getUserFullName() {
        return usersFullName.getValue();
    }

    public void login() {
        userIcon.click();
        loginForm.login(new User("Roman", "Jdi1234", "ROMAN IOVLEV"));
    }

}
