package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorAdditionTest extends CalculatorTestBase {

    @Test(dataProvider = "dataProvider")
    public void sumTwoDigits(long firstDigit, long secondDigit, long expectedResult){

        long actualResult = calculator.sum(firstDigit, secondDigit);

        assertEquals(actualResult, expectedResult, "Wrong result of summation");
    }

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][] {
                {5,5,10},
                {10,5,15},
                {5,-10,-5}
        };
    }

}
