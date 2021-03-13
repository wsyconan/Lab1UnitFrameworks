package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class DivTest {
    Calculator calc = new Calculator();

    @DataProvider
    public static Object[][] LongData() {
        return new Object[][]{
                {4L, 2L, 2L}, {81L, -1L, -81L},
                {-4L, -4L, 1L}, {0L, 81L, 0L}
        };
    }

    @DataProvider
    public static Object[][] DoubleData() {
        return new Object[][]{
                {4.0, 2.0, 2.0}, {81.0, 0.0, Double.POSITIVE_INFINITY},
                {-81.0, 0.0, Double.NEGATIVE_INFINITY}, {81.0, -1.0, -81.0},
                {0.00000009, 0.00000001, 9.0}
        };
    }

    @DataProvider
    public static Object[][] ZeroDivisor() {
        return new Object[][]{
                {81L, 0L}, {-81L, 0L}
        };
    }

    @Test(testName = "Division type Long", dataProvider = "LongData")
    public void DivLong(Long dividend, Long divisor, Long res) {
        Assert.assertEquals(res.longValue(), calc.div(dividend, divisor));
    }

    @Test(testName = "Division type Double", dataProvider = "DoubleData")
    public void DivDouble(Double dividend, Double divisor, Double res) {
        Assert.assertEquals(res, calc.div(dividend, divisor));
    }

    @Test(testName = "Division with zero divisor",
            dataProvider = "ZeroDivisor",
            expectedExceptions = {NumberFormatException.class})
    public void DivDouble(Long dividend, Long divisor) {
        calc.div(dividend, divisor);
    }
}