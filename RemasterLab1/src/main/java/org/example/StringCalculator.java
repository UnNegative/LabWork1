package org.example;

public class StringCalculator {

    //    public String numStr;
//    private int result = 0;
    public StringCalculator(){};

    int add(String numStr) throws StringCalculatorInvalidInputException {

        int result = 0;

        if (numStr.isEmpty()) {
            return result;
        }
        if (numStr.split(",").length == 1) {
            return Integer.parseInt(numStr);
        }
        if (numStr.split(",").length >= 2) {
            for (String num : numStr.split(",")) {
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

