package org.example;

//import com.sun.jdi.IntegerValue;

import java.util.regex.Pattern;

public class StringCalculator {

//    public String numStr;
    private int result = 0;
    public StringCalculator(){};

    String[] mySplit(String numStr,String Delimiter) throws Exception{ //throws Exception{

        if(CheckForDelimiterAtTheEnd(numStr,Delimiter)) {
        throw new Exception();
        }
        return numStr.split("["+Delimiter+"]",0);
    }


    boolean CheckForDelimiterAtTheEnd (String numStr, String Delimiter){
        String str = ("[" + Delimiter + "]$").toString();
        return Pattern.compile(str).matcher(numStr).find();
    }

    public int add (String numStr) {
        try{
        String[] StringMas = mySplit(numStr,",\n");

        if (numStr.isEmpty()) {
            return result;
        }
        if (StringMas.length == 1) {
            return Integer.parseInt(numStr);
        }
        if (StringMas.length >= 2) {
            for (String num : StringMas) {
                result += Integer.parseInt(num);
            }
            return result;
        }
            return 0;
        }catch (Exception e){
            return -1;}
    }
}



