package hw4.TestBase;

import hw4.util.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;

    protected final static String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.INSTANCE.setDriver("chrome");
        driver = WebDriverSingleton.INSTANCE.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void openTestSite() {
        driver.get(URL);
        driver.manage().window().maximize();
    }
}


