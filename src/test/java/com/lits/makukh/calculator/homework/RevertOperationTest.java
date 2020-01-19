package com.lits.makukh.calculator.homework;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class RevertOperationTest {

    @Test(dataProvider = "revertData", groups = {"regression", "acceptance"})
    public void testRevert(BigDecimal a, BigDecimal b, BigDecimal result){
        Calculator calculator = new Calculator();
        calculator.setValue(a);
        calculator.multiply(b);
        calculator.subtract(b);
        calculator.revert();
        Assert.assertEquals(calculator.getCurrentAmount(), result);
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class, groups = {"regression"})
    public void testRevertWithoutValue(){
        Calculator calculator = new Calculator();
        calculator.revert();
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.ZERO);
    }


    @DataProvider
    public Object[][] revertData(){
        return new Object[][]{
                {BigDecimal.valueOf(6), BigDecimal.valueOf(2), BigDecimal.valueOf(12)}
        };
    }
}
