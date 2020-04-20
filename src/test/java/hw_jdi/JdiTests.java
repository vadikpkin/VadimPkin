package hw_jdi;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

public class JdiTests {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverFactory.getDriver("chrome").quit();
        killAllSeleniumDrivers();
    }

    @Test
    public void metalsAndColorPageTest() throws InterruptedException {
        JdiSite.open();
        JdiSite.homepage.checkOpened();
        JdiSite.homepage.login();
        JdiSite.homepage.usersFullName.is().text("ROMAN IOVLEV");
        JdiSite.homepage.headerMenu.select("Metals & Colors");
        JdiSite.metalsAndColorsPage.fillForm();
        Thread.sleep(1000);
    }
}
