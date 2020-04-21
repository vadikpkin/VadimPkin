package hw_jdi;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import hw_jdi.entities.MetalsAndColorsData;
import hw_jdi.entities.User;
import org.testng.annotations.*;
import utils.JsonParser;
import utils.PropertyReader;

import java.util.*;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static java.lang.String.*;
import static java.util.Arrays.*;

public class JdiTests {

    public static final User ROMAN = new User(PropertyReader.read("user"),
            PropertyReader.read("password"),
            PropertyReader.read("fullusername"));

    @DataProvider
    public Iterator<Object[]> dataProvider() {
        List<MetalsAndColorsData> students = JsonParser.readData();
        Collection<Object[]> data = new ArrayList<Object[]>();
        students.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverFactory.getDriver().quit();
    }

    @AfterSuite
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @Test(dataProvider = "dataProvider")
    public void metalsAndColorPageTest(MetalsAndColorsData data) {
        JdiSite.open();
        JdiSite.homepage.checkOpened();
        JdiSite.homepage.login(ROMAN);
        JdiSite.homepage.usersFullName.is().text(ROMAN.getFullName());
        JdiSite.homepage.headerMenu.select("Metals & Colors");
        JdiSite.metalsAndColorsPage.fillForm(data);
        JdiSite.metalsAndColorsPage.results.has().text(format(
                "Summary: %s\n" +
                "Elements: %s\n" +
                "Color: %s\n" +
                "Metal: %s\n" +
                "Vegetables: %s",
                stream(data.getSummary()).sum(), data.getElementsAsString(), data.getColor(), data.getMetals(), data.getVegetablesAsString()));
    }
}
