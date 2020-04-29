package hw6.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.WebDriverSingleton;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.INSTANCE.setDriver("chrome");
        WebDriverSingleton.INSTANCE.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }

}
