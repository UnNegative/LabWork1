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
        Assertions.assertThrows(StringCalculatorInvalidInputException.class,()->StrCalc.add("//[,]\n1,2,"));

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

    @Test
    public void shouldIgnoreMore1000(){
        Assertions.assertEquals(1999,StrCalc.add("1000,999,1001"));
        Assertions.assertEquals(2888,StrCalc.add("//#\n2000#1000#1000#800#1080#80#8#9847")); //ERROR by comma
    }

    @Test
    public void ShouldSeeLongDelimiters() {
        Assertions.assertTrue(StrCalc.CheckSingleSchemeWithBrackets("//[*]\n10*5*1*1"));
        Assertions.assertTrue(StrCalc.CheckSingleSchemeWithBrackets("//[**]\n10**5**1**1"));
        Assertions.assertTrue(StrCalc.CheckSingleSchemeWithBrackets("//[***]\n10***5***1***1"));
    }

        @Test
        public void ShouldCalculateLongDelimiters(){
        Assertions.assertEquals(17,StrCalc.add("//[***]\n10***5***1***1"));
        Assertions.assertEquals(17,StrCalc.add("//[$$]\n10$$5$$1$$1"));
        Assertions.assertEquals(17,StrCalc.add("//[$%]\n10$%5$%1$%1"));

    }

    @Test
    public void ShouldSeeManyDelimiters(){
        Assertions.assertTrue(StrCalc.CheckMultiSchemeWithBrackets("//[*][%]\n1*2%3"));
    }
    @Test
    public void ShouldCalculateManyDelimiters(){
        Assertions.assertEquals(6,StrCalc.add("//[*][%]\n1*2%3"));
        Assertions.assertEquals(15,StrCalc.add("//[&][@][-][=]\n1&2@3-4=5"));
    }
}
