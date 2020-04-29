package hw4.ex2;

import hw4.base.TestBase;
import hw4.data.MotherEntityCreator;
import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import hw4.data.FormData;
import hw4.data.User;
import utils.CalculationUtils;
import hw4.pages.IndexPage;
import hw4.pages.MetalsColorsPage;
import utils.PropertyReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseTwoTest extends TestBase {

    private IndexPage indexPage;
    private MetalsColorsPage metalsColorsPage;
    private User user;

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {MotherEntityCreator.getDefaultFormDataBuilder().setElements(Arrays.asList(Elements.EARTH))
                        .setColors(Colors.YELLOW).setMetals(Metals.GOLD).build()},
                {MotherEntityCreator.getDefaultFormDataBuilder().setOdd("3").setEven("8")
                        .setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO)).build()},
                {MotherEntityCreator.getDefaultFormDataBuilder().setOdd("3").setEven("2").
                        setElements(Arrays.asList(Elements.WATER, Elements.WIND, Elements.FIRE)).setMetals(Metals.BRONZE)
                        .setVegetables(Arrays.asList(Vegetables.ONION)).build()},
                {MotherEntityCreator.getDefaultFormDataBuilder().setOdd("5").setEven("6")
                        .setElements(Arrays.asList(Elements.WATER)).setColors(Colors.GREEN).setMetals(Metals.SELEN)
                        .setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO, Vegetables.VEGETABLES, Vegetables.ONION)).build()},
                {MotherEntityCreator.getDefaultFormDataBuilder().setElements(Arrays.asList(Elements.FIRE)).setColors(Colors.BLUE)
                        .setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO, Vegetables.VEGETABLES)).build()}
        };
    }

    @BeforeMethod
    public void initData() {
        indexPage = new IndexPage(driver);
        metalsColorsPage = new MetalsColorsPage(driver);
        user = User
                .builder()
                .setPassword(PropertyReader.read("password"))
                .setUsername(PropertyReader.read("user"))
                .build();
    }

    @Test(dataProvider = "dataProvider")
    public void metalsColorsPageFuncTest(FormData form) {
        //1. Open test site by URL
        openTestSite();
        assertThat(indexPage.getBrowserTitle()).isEqualTo("Home Page");

        //2. Perform login
        indexPage.login(user);

        //3. Click on the link on the Header section
        indexPage.goToMetalColorPage();

        //4. Fill form on the page
        metalsColorsPage.fillForm(form);
        metalsColorsPage.submitForm();

        //5. Check Results block output on the right-side
        if (!form.getColors().equalsIgnoreCase(Colors.COLORS.toString())) {
            assertThat(metalsColorsPage.getColorResult()).isEqualToIgnoringCase(form.getColors());
        }
        if (!form.getMetals().equalsIgnoreCase(Metals.METALS.toString())) {
            assertThat(metalsColorsPage.getMetalResult()).isEqualToIgnoringCase(form.getMetals());
        }
        if (!form.getElementsAsString().equalsIgnoreCase(Elements.DEFAULT.toString())) {
            assertThat(metalsColorsPage.getElementsResult()).isEqualToIgnoringCase(form.getElementsAsString());
        }
        if (!form.getVegetablesAsString().equalsIgnoreCase(Vegetables.VEGETABLES.toString())) {
            assertThat(metalsColorsPage.getVegetableResult()).isEqualToIgnoringCase(form.getVegetablesAsString());
        }
        if (!form.getEven().equals("2") | !form.getOdd().equals("1")) {
            String expectedSum = CalculationUtils.summ(form.getEven(), form.getOdd());
            assertThat(metalsColorsPage.getSumResult()).isEqualTo(expectedSum);
        }
    }
}
