package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest {
    Calculator calc = new Calculator();

    @DataProvider
    public static Object[][] LongData(){
        return new Object[][]{
                {4L, 2L, 2L}, {81L, 81L, 0L}, {4L, -2L, 6L}
        };
    }

    @DataProvider
    public static Object[][] DoubleData(){
        return new Object[][]{
                {4.0, 2.0, 2.0}, {81.0, 0.0, 81.0},
                {0.0000001, 0.00000001, 0.00000009}
        };
    }

    @Test(testName = "Subtraction type Long", dataProvider = "LongData")
    public void SubLong(Long minuend, Long subtrahend, Long res){
        Assert.assertEquals(res.longValue(), calc.sub(minuend, subtrahend));
    }

    @Test(testName = "Subtraction type Double", dataProvider = "DoubleData")
    public void SubDouble(Double minuend, Double subtrahend, Double res){
        Assert.assertEquals(res, calc.sub(minuend, subtrahend));
    }
}