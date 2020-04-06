package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplicationTest extends CalculatorTestBase {

    @Test(dataProvider = "dataProvider")
    public void divideTwoDigits(long firstDigit, long secondDigit, long expectedResult){

        long actualResult = calculator.mult(firstDigit, secondDigit);

        assertEquals(actualResult, expectedResult, "Wrong result of  multiplication");
    }

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][] {
                {5,5,25},
                {12,12,144},
                {0,-10,0}
        };
    }
}
