package com.lits.makukh.calculator.homework;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class DEGToRADOperationTest {
    private Calculator calculator = new Calculator();

    @Test(dataProvider = "DEGtoRADdata", description = "Verify degrees to radians conversion", groups = {"acceptance", "regression"})
    public void testDEGToRAD(BigDecimal a, BigDecimal result){
        calculator.setValue(a);
        calculator.convertToRAD();
        int compareResult  = calculator.getCurrentAmount().compareTo(result);
        Assert.assertEquals(compareResult, 0);
    }

    @DataProvider
    public Object[][] DEGtoRADdata(){
        return new Object[][]{
                {BigDecimal.valueOf(0), BigDecimal.valueOf(0)},
                {BigDecimal.valueOf(180), BigDecimal.valueOf(3.141592653589740)}
        };
    }
}
