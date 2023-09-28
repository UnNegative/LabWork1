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
    public void shouldCalculateTwo(){
        Assertions.assertEquals(3,StrCalc.add("1,2"));
    }
    @Test
    public void shouldCalculateManyNumbers(){
        Assertions.assertEquals(20,StrCalc.add("1,2,4,6,7"));
    }
    @Test
    public void shouldCalculateNewDelimiter(){
        Assertions.assertEquals(7,StrCalc.add("1,2\n4"));
    }

    @Test
    public void shouldErrorEndingWithDelimiter(){
        Assertions.assertThrows(StringCalculatorInvalidInputException.class,()->StrCalc.add("1,2\n"));
        Assertions.assertThrows(StringCalculatorInvalidInputException.class,()->StrCalc.add("1,2,"));
    }
//    @Test
//    public void shouldErrorEndingWithDelimiterComma(){
//    }

//    @Test
//    public void shouldWorkWithTemplateComma(){
//
//    }

    @Test
    public void shouldWorkWithTemplate(){
        Assertions.assertEquals(3,StrCalc.add("//,\n1,2"));
        Assertions.assertEquals(3,StrCalc.add("//;\n1;2"));

    }
    @Test
    public void shouldExtractNegativesFromString(){
        Assertions.assertEquals("[-2,-32]",StrCalc.ListOfNegatives(new String[]{"1", "-2", "-32", "9"}));
    }

    @Test
    public void shouldReturnErrorWithListOfNegatives(){
        Assertions.assertThrows(StringCalculatorNegativeException.class,()->StrCalc.add("//#\n1#-2#9#-32"));
        Assertions.assertThrows(StringCalculatorNegativeException.class,()->StrCalc.add("1,-2\n9,-32"));

    }

}
