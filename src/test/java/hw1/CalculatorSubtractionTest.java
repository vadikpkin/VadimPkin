package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractionTest extends CalculatorTestBase {

    @Test(dataProvider = "dataProvider")
    public void subtractTwoDigits(long firstDigit, long secondDigit, long expectedResult){

        long actualResult = calculator.sub(firstDigit, secondDigit);

        assertEquals(actualResult, expectedResult, "Wrong result of subtraction");
    }

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][] {
                {5,5,0},
                {100,200,-100},
                {10,7,3}
        };
    }
}
