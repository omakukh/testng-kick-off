package com.lits.makukh.calculator.homework;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class RADToDEGOperationTest {
    private Calculator calculator = new Calculator();

    @Test(dataProvider = "RADtoDEGdata", description = "Verify radians to degrees conversion", groups = {"regression", "acceptance"})
    public void testRADToDEG(BigDecimal a, BigDecimal result){
        calculator.setValue(a);
        calculator.convertToDEG();
        int compareResult = calculator.getCurrentAmount().compareTo(result);
        Assert.assertEquals(compareResult, 0);
    }

    @DataProvider
    public Object[][] RADtoDEGdata(){
        return new Object[][]{
                {BigDecimal.valueOf(0.05), BigDecimal.valueOf(2.85)},
                {BigDecimal.ZERO, BigDecimal.ZERO}
        };
    }
}
