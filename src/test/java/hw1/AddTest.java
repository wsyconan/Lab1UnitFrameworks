package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddTest {
    Calculator calc = new Calculator();

    @DataProvider
    public static Object[][] LongData(){
        return new Object[][]{
            {4L, 2L, 6L}, {81L, 0L, 81L}, {4L, -4L, 0L}
        };
    }

    @DataProvider
    public static Object[][] DoubleData(){
        return new Object[][]{
                {4.0, 2.0, 6.0}, {81.0, 0.0, 81.0},
                {0.00000009, 0.00000001, 0.0000001}
        };
    }

    @Test(testName = "Addition type Long", dataProvider = "LongData")
    public void AddLong(Long addend1, Long addend2, Long res){
        Assert.assertEquals(res.longValue(), calc.sum(addend1, addend2));
    }

    @Test(testName = "Addition type Double", dataProvider = "DoubleData")
    public void AddDouble(Double addend1, Double addend2, Double res){
        Assert.assertEquals(res, calc.sum(addend1, addend2));
    }
}