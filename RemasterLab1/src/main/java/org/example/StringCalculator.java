package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {

    //    public String numStr;
//    private int result = 0;
    public StringCalculator(){}

    String DelimiterReplacement(String numbers,String[] delimiters) {
        for (String delimiter : delimiters) {
            numbers = numbers.replace(delimiter, ",");
        }
        return numbers;
    }
    boolean CheckForNearDelimiters(String numbers,String[] delimiters){
        numbers = DelimiterReplacement(numbers,delimiters);
        ArrayList<String> sLst = new ArrayList<>(Arrays.asList(numbers.split(",")));
        return sLst.contains("");
    }
    
    int add(String numbers) throws StringCalculatorInvalidInputException {

        int result = 0;

        if (numbers.isEmpty()) {
            return result;
        }
        numbers = numbers +",0";

        if(CheckForNearDelimiters(numbers, new String[]{",","\n"})){
            throw new StringCalculatorInvalidInputException("Near Delimiters not allowed!");
        }

        numbers = DelimiterReplacement(numbers,new String[]{",","\n"});

//        if (numbers.split(",").length == 1) {
//            return Integer.parseInt(numbers);
//        }
        if (numbers.split(",").length >= 2) {
            for (String num : numbers.split(",")) {
                result += Integer.parseInt(num);
            }
            return result;
        }
//        if (numStr.split(",").length >2) {
////            System.out.println("ERROR More than 2 numbers inserted");
//            throw new StringCalculatorInvalidInputException("ERROR More than 2 numbers inserted");
//        }
        return result;
    }
}

