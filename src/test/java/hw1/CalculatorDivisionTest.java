package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivisionTest extends CalculatorTestBase {

    @Test(dataProvider = "dataProvider")
    public void divideTwoDigits(long firstDigit, long secondDigit, long expectedResult ){

        long actualResult = calculator.div(firstDigit, secondDigit);

        assertEquals(actualResult, expectedResult, "Wrong result of division");
    }

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][] {
                {5,5,1},
                {144,12,12},
                {10,-10,-1}
        };
    }

}
