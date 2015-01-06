package com.nortal.commander.foo;

import org.junit.Assert;
import org.junit.Test;

public class FooTest {

    private Foo foo = new Foo();

    @Test
    public void testCalculate() {
        int result = foo.calculate(10, 5);
        Assert.assertEquals(3, result);
    }

    @Test(expected = ArithmeticException.class)
    public void calculateDivideByZero() {
        int result = foo.calculate(10, 10);
    }

}
