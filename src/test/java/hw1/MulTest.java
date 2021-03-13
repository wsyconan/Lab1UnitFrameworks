package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class MulTest {
    Calculator calc = new Calculator();

    @DataProvider
    public static Object[][] LongData(){
        return new Object[][]{
                {4L, 2L, 8L}, {81L, 0L, 0L},
                {4L, -4L, -16L}, {-4L, -4L, 16L},
                {4L, 2L, 9L}
        };
    }

    @DataProvider
    public static Object[][] DoubleData(){
        return new Object[][]{
                {4.0, 2.0, 8.0}, {81.0, 0.0, 0.0},
                {4.0, -4.0, -16.0}, {-4.0, -4.0, 16.0},
                {0.00000009, 0.1, 0.000000009}
        };
    }

    @Test(testName = "Multiplication type Long", dataProvider = "LongData")
    public void AddLong(Long multiplier1, Long multiplier2, Long res){
        Assert.assertEquals(res.longValue(), calc.mult(multiplier1, multiplier2));
    }

    @Test(testName = "Multiplication type Double", dataProvider = "DoubleData")
    public void AddDouble(Double multiplier1, Double multiplier2, Double res){
        Assert.assertEquals(res, calc.mult(multiplier1, multiplier2));
    }
}