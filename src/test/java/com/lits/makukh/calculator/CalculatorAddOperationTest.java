package com.lits.makukh.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.math.BigDecimal;

public class CalculatorAddOperationTest {

    private Calculator calculator = new Calculator();

    @Test(expectedExceptions = AssertionError.class)
    public void testExpected() {
        calculator.reset();
        calculator.setValue(BigDecimal.valueOf(20.0));
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.ZERO);
    }

    @Test(groups = {"calculator", "simple-operations", "Add"},
            description = "Verify add operation returns correct result")
    public void testAdd() {
        //System.out.println(calculator.getCurrentAmount());
        BigDecimal a = BigDecimal.valueOf(0.1);
        BigDecimal b = BigDecimal.valueOf(0.2);

        calculator.setValue(a);
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        calculator.add(b);
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(0.3));
    }

    @Test(description = "Verify subtract operation returns correct result")
    public void testSubtract() {
        BigDecimal a = BigDecimal.valueOf(0.1);
        BigDecimal b = BigDecimal.valueOf(0.2);

        calculator.setValue(b);
        calculator.subtract(a);
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(0.1));
    }

    @Test(description = "Verify multiply operation returns correct result")
    public void testMultiply() {
        BigDecimal a = BigDecimal.valueOf(1);
        BigDecimal b = BigDecimal.valueOf(2);

        calculator.setValue(a);
        calculator.multiply(b);
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(2));
    }

    @Test(description = "Verify divide operation returns correct result")
    public void testDivide() {
        BigDecimal a = BigDecimal.valueOf(2);
        BigDecimal b = BigDecimal.valueOf(1);

        calculator.setValue(a);
        calculator.divide(b);
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(2));
    }
}
