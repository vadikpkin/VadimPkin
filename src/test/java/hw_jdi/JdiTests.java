package hw_jdi;

import hw_jdi.pages.HomePage;
import org.testng.annotations.Test;

public class JdiTests {

    @Test
    public void metalsAndColorPageTest() {
        JdiSite.open();
        HomePage homePage = new HomePage();
        homePage.login(new User.ROMAN);
        String fullName = JdiSite.homepage.getUserFullName();
    }
}
