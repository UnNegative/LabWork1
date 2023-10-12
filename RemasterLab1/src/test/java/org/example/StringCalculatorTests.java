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
    public void ShouldCalculateTwoOrMore(){
        Assertions.assertEquals(6,StrCalc.add("1,2,3"));
        Assertions.assertEquals(10,StrCalc.add("1,2,3,4"));
        }
    @Test
    public void ShouldErrorTwoNearDelimiters(){
        Assertions.assertThrows(StringCalculatorInvalidInputException.class,()->StrCalc.add("1,2,\n"));
        }
    @Test
    public void ShouldCalculateNewDelimiter(){
        Assertions.assertEquals(3,StrCalc.add("1,1\n1"));
    }
    @Test
    public void ShouldErrorIfDelimiterAtTheEnd(){
        Assertions.assertThrows(StringCalculatorInvalidInputException.class,()->StrCalc.add("1,2\n3,"));
    }
    @Test
    public void ShouldCalculateAnyDelimiter(){
        Assertions.assertEquals(3,StrCalc.add("//;\n1;1;1"));
        Assertions.assertEquals(3,StrCalc.add("//p\n1p1p1"));
        Assertions.assertEquals(3,StrCalc.add("//p\n1\n1,1"));
    }
    @Test
    public void ShouldErrorWithNegatives(){
        Assertions.assertThrows(StringCalculatorNegativeException.class,()->StrCalc.add("-1,1,-2,-3,2"));
        Assertions.assertThrows(StringCalculatorNegativeException.class,()->StrCalc.add("//#\n1#-1#-2"));
    }
    @Test
    public void ShouldIgnoreNumbersMoreThan1000(){
        Assertions.assertEquals(1999,StrCalc.add("1000,1001\n999"));
        Assertions.assertEquals(1001,StrCalc.add("//;\n1001,2002,1,1000"));
    }
}