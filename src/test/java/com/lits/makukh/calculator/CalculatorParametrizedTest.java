package com.lits.makukh.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorParametrizedTest {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "data", groups = "Add")
    public void testAddTwoNumbers(BigDecimal a, BigDecimal b, BigDecimal result){
         calculator.setValue(a);
         calculator.add(b);
         //Assert.assertEquals(calculator.getCurrentAmount(), result);
        int compareResult = result.compareTo(calculator.getCurrentAmount());
        Assert.assertEquals(compareResult, 0);
    }

    @DataProvider//(parallel = true)
    public Object[][] data(){
        return new Object[][]{
                {BigDecimal.valueOf(1.5), BigDecimal.valueOf(1.5),BigDecimal.valueOf(3.0)},
                {BigDecimal.valueOf(-1.5), BigDecimal.valueOf(1.5),BigDecimal.valueOf(0.0)},
                {BigDecimal.valueOf(1000000), BigDecimal.valueOf(1.5), BigDecimal.valueOf(1000001.5)},
                {BigDecimal.valueOf(2.5), BigDecimal.ZERO, BigDecimal.valueOf(2.5)},
                {BigDecimal.valueOf(-9.143), BigDecimal.valueOf(0.143), BigDecimal.valueOf(-9.0)},
        };
    }

    @Test(dataProvider = "dataSubtract")
    public void testSubtractParam(BigDecimal a, BigDecimal b, BigDecimal result){
        calculator.setValue(b);
        calculator.subtract(a);
        Assert.assertEquals(calculator.getCurrentAmount(), result);

    }

    @DataProvider
    public Object[][] dataSubtract(){
        return new Object[][]{
                {BigDecimal.valueOf(1.5), BigDecimal.valueOf(1.5),BigDecimal.valueOf(0.0)},
                {BigDecimal.valueOf(-1.5), BigDecimal.valueOf(1.5),BigDecimal.valueOf(3.0)}
        };
    }

}
