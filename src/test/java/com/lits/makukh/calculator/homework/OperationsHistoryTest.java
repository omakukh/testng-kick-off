package com.lits.makukh.calculator.homework;

import com.lits.calculator.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class OperationsHistoryTest {

    @Test(description = "Verify operations history correctness: add, subtract", dataProvider = "data", groups = {"acceptance", "regression"})
    public void testOperationsHistoryAddSubtract(BigDecimal a, BigDecimal b) {
        Calculator calculator = new Calculator();
        calculator.setValue(a);
        BigDecimal c = calculator.add(b);
        calculator.subtract(b);
        List<Operation> expectedResult = Arrays.asList(new AddOperation(a, b), new SubtractOperation(c, b));
        Assert.assertEquals(calculator.getOperationsHistory().toString(), expectedResult.toString());
    }

    @Test(dataProvider = "data", description = "Verify operations history correctness: multiply, divide", groups = {"regression"})
    public void testOperationHistoryMultiplySubtract(BigDecimal a, BigDecimal b) {
        Calculator calculator = new Calculator();
        calculator.setValue(a);
        BigDecimal c = calculator.multiply(b);
        calculator.divide(b);
        List<Operation> expectedResult = Arrays.asList(new MultiplyOperation(a, b), new DivideOperation(c, b));
        Assert.assertEquals(calculator.getOperationsHistory().toString(), expectedResult.toString());
    }

    @Test(dataProvider = "data", description = "Verify operations history: RAD to DEG, DEG to RAD", groups = {"regression"})
    public void testOperationHistoryConversion(BigDecimal a, BigDecimal b) {
        Calculator calculator = new Calculator();
        calculator.setValue(a);
        calculator.convertToDEG();
        calculator.setValue(b);
        calculator.convertToRAD();
//        List<Operation> expectedResult = Arrays.asList(new RadToDegOperation(a), new DedToRadOperation(b));
//        Assert.assertEquals(calculator.getOperationsHistory().toString(), expectedResult.toString());
//        there is no toString method for DedToRadOperation
        Assert.assertTrue(calculator.getOperationsHistory().get(0) instanceof RadToDegOperation);
        Assert.assertTrue(calculator.getOperationsHistory().get(1) instanceof DedToRadOperation);
    }

    @DataProvider
    public Object[][] data(Method testMethod) {
        return new Object[][]{
                {BigDecimal.valueOf(3), BigDecimal.valueOf(1)}
        };
    }
}

