package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

//import static java.util.regex.Pattern.*;

public class StringCalculator {

    //    public String numStr;
//    private int result = 0;
    public StringCalculator(){}


    String DelimiterFinder(String numbers){
        return numbers.substring(numbers.indexOf("/")+2,numbers.indexOf("\n"));
    }
    String DelimiterCutter(String numStr){
        return numStr.substring(numStr.indexOf("\n")+1);
    }

    String DelimiterReplacement(String numbers,String[] delimiters) {
        for (String delimiter : delimiters) {
            numbers = numbers.replace(delimiter, ",");
        }
        return numbers;
    }

    boolean CheckForTemplate(String numbers){
//        return Pattern.compile("").matcher(numbers).find();
        return Pattern.compile("//+\\D\n\\d*\\D").matcher(numbers).find();
    }

    boolean CheckForNearDelimiters(String numbers,String[] delimiters){
        numbers = DelimiterReplacement(numbers,delimiters);
        ArrayList<String> sLst = new ArrayList<>(Arrays.asList(numbers.split(",")));
        return sLst.contains("");
    }


    boolean HasNegative(String[] numbers){
        boolean b = false;
        for (String num : numbers ) {
            b |= (Integer.parseInt(num)<0);
        }
        return b;
    }

    String ListOfNegatives(String[] numbers){
        String list = "[";
        for (String num:numbers) {
            if (Integer.parseInt(num) < 0){
                list = list.concat(num);
                list += ",";
            }
        }
        list = list.substring(0, list.length() - 1);
        list = list.concat("]");
        return list;
    }



    int add(String numbers) throws StringCalculatorInvalidInputException, StringCalculatorNegativeException {

        int result = 0;

        if (numbers.isEmpty()) {
            return result;
        }

        ArrayList<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add("\n");



        numbers +=",0";

        if(CheckForTemplate(numbers)){
            delimiters.add((DelimiterFinder(numbers)));
            numbers = DelimiterCutter(numbers);
        }


        if(CheckForNearDelimiters(numbers,delimiters.toArray(new String[0]))){
            throw new StringCalculatorInvalidInputException("Near Delimiters not allowed!");
        }

        numbers = DelimiterReplacement(numbers,delimiters.toArray(new String[0]));

//        if (numbers.split(",").length == 1) {
//            return Integer.parseInt(numbers);
//        }
        if(HasNegative(numbers.split(","))){
            String message ="Negatives not allowed " + ListOfNegatives(numbers.split(","));
            throw new StringCalculatorNegativeException(message);
        }

        if (numbers.split(",").length >= 2) {
            for (String num : numbers.split(",")) {
                if(Integer.parseInt(num)<1001){
                    result += Integer.parseInt(num);
                }
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

