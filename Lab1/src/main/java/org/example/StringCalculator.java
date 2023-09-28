package org.example;

//import com.sun.jdi.IntegerValue;

import java.util.regex.Pattern;

public class StringCalculator {

//    public String numStr;
    private int result = 0;

    public StringCalculator(){}

    String[] mySplit(String numStr,String Delimiter) throws StringCalculatorInvalidInputException{ //throws Exception{

        if(CheckForDelimiterAtTheEnd(numStr,Delimiter)) {
        throw new StringCalculatorInvalidInputException("Expression ends with Delimiter");
        }
        return numStr.split("["+Delimiter+"]",0);
    }

    String DelimiterCutter(String numStr){
        return numStr.substring(numStr.indexOf("\n")+1);
    }

    String DelimiterFinder(String numStr){
        return numStr.substring(numStr.indexOf("//")+2,numStr.indexOf("\n"));
    }

    boolean CheckTemplate(String numStr){
        return Pattern.compile("//[~/!@#$%^&*)(+=:;.,_?-]\n[0123456789~/!@#$%^&*)(+=.,_?-]").matcher(numStr).find();
    }

    boolean CheckForDelimiterAtTheEnd (String numStr, String Delimiter){
        String str = ("[" + Delimiter + "]$");
        return Pattern.compile(str).matcher(numStr).find();
    }

    public int add (String numStr) throws StringCalculatorInvalidInputException {

        String[] StringMas;

        if (CheckTemplate(numStr)){

        StringMas = mySplit(DelimiterCutter(numStr),DelimiterFinder(numStr));
        }
        else{
        StringMas = mySplit(numStr,",\n");
        }

        if (numStr.isEmpty()) {
            return result;
        }
        if (StringMas.length == 1) {
            return Integer.parseInt(StringMas[0]);
        }
        if (StringMas.length >= 2) {
            for (String num : StringMas) {
                result += Integer.parseInt(num);
            }
            return result;
        }
            return 0;

    }
}



