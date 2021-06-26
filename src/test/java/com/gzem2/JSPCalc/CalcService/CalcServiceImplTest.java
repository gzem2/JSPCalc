package com.gzem2.JSPCalc.CalcService;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import junit.framework.*;

@Testable
public class CalcServiceImplTest extends TestCase {
    protected CalcServiceImpl service;

    protected void setUp() {
        this.service = new CalcServiceImpl();
    }

    @Test
    public void testAdd() {
        Double result = this.service.calculateInput("1+1");
        assertTrue(result == 2.0);
    }

    @Test
    public void testSub() {
        Double result = this.service.calculateInput("1-1");
        assertTrue(result == 0.0);
    }

    @Test
    public void testMultiply() {
        Double result = this.service.calculateInput("10*10");
        assertTrue(result == 100.0);
    }

    @Test
    public void testDiv() {
        Double result = this.service.calculateInput("20/4");
        assertTrue(result == 5.0);

        result = this.service.calculateInput("20/0");
        assertTrue(result == null);
    }

    @Test
    public void testSeveralOps() {
        Double result = this.service.calculateInput("1+2-3");
        assertTrue(result == 0.0);

        result = this.service.calculateInput("3*10+50-20/3");
        assertTrue(result == 20.0);

        result = this.service.calculateInput("3*10+0-0*0+50-20/3");
        assertTrue(result == 10.0);

        result = this.service.calculateInput("3*10+0-0/0*0+50-20/3");
        assertTrue(result == null);
    }

    @Test
    public void testNegative() {
        Double result = this.service.calculateInput("-3*-6");
        assertTrue(result == 18);

        result = this.service.calculateInput("-3*6");
        assertTrue(result == -18);

        result = this.service.calculateInput("3*-6");
        assertTrue(result == -18);
    }
}
