package hw_jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw_jdi.LoginForm;

public class HomePage extends WebPage {
    @Css("#login-form")
    private LoginForm loginForm;

    public String getUserFullName() {
        return loginForm.getName();
    }
}
