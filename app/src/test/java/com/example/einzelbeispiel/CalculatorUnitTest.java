package com.example.einzelbeispiel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorUnitTest {


    @Test
    public void test_calculator_with_11808426(){
        String exp = "Index [6] und Index [7] haben denselben Teiler!";
        assertEquals(exp, Calculator.calculate_Common_factors("11808426"));

    }

    @Test
    public void test_calculator_expected_index_0_and_4(){
        String exp = "Index [0] und Index [4] haben denselben Teiler!";
        assertEquals(exp, Calculator.calculate_Common_factors("30176"));
    }

    @Test
    public void test_calculator_expected_no_common_factors(){
        String exp = "Es gibt keine Zahlen mit gleichem Teiler!";
        assertEquals(exp, Calculator.calculate_Common_factors("1101279"));
    }
}