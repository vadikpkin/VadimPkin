package hw4.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum WebDriverSingleton {

    INSTANCE;

    private WebDriver driver;

    public void setDriver(String browserName) {
        if ("CHROME".equalsIgnoreCase(browserName)) {
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
