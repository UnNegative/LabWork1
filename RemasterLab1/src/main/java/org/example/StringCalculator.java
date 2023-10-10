package org.example;

//import com.sun.jdi.IntegerValue;

import java.security.InvalidParameterException;

public class StringCalculator {

//    public String numStr;
    private int result = 0;
    public StringCalculator(){};

    int add(String numStr)/* throws Exception*/ {
        if (numStr.isEmpty()) {
            return result;
        }
        if (numStr.split(",").length == 1) {
            return Integer.parseInt(numStr);
        }
        if (numStr.split(",").length == 2) {
            for (String num : numStr.split(",")) {
                result += Integer.parseInt(num);
            }
            return result;
        }
            if (numStr.split(",").length >2) {
                System.out.println("ERROR More than 2 numbers inserted");

            }
            return result;
    }
    }

