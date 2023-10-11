package org.example;

//import org.junit.*
import org.junit.jupiter.api.*;
//import org.junit.*;

public class StringCalculatorTests {

    private final StringCalculator StrCalc = new StringCalculator();

    @Test
    public void shouldCalculateEmpty(){
        Assertions.assertEquals(0,StrCalc.add(""));
    }

    @Test
    public void shouldCalculateOne (){
        Assertions.assertEquals(1,StrCalc.add("1"));
    }

    @Test
    public void shouldCalculateTwo() {
        Assertions.assertEquals(3, StrCalc.add("1,2"));
    }

    @Test
    public void ShouldFailTwoOrMore(){
        Assertions.assertThrows(StringCalculatorInvalidInputException.class,()->StrCalc.add("1,2,3"));
    }
}