package hw_jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw_jdi.pages.HomePage;
import hw_jdi.pages.MetalsAndColorsPage;

public class JdiSite {
    @Url("/index.html")
    public static HomePage homepage;

    @Url("/metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        homepage.open();
    }


}
