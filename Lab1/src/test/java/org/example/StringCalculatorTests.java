package org.example;

//import org.junit.*
import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTests {

    private final StringCalculator StrCalc = new StringCalculator();

    @Test
    public void shouldCalculateEmpty (){
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
        Assertions.assertEquals(6,StrCalc.add("1,2\n3"));
    }

    @Test
    public void shouldErrorEndingWithDelimiter(){
        Assertions.assertEquals(-1,StrCalc.add("1,2\n"));
    }
    @Test
    public void shouldErrorEndingWithDelimiterKoma(){
        Assertions.assertEquals(-1,StrCalc.add("1,2,"));
    }


}
