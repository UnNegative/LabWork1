package org.example;

//import com.sun.jdi.IntegerValue;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringCalculator {

    public StringCalculator(){}

    String[] mySplit(String numStr,String Delimiter) throws StringCalculatorInvalidInputException{ //throws Exception{

        if(CheckForDelimiterAtTheEnd(numStr,Delimiter)) {
        throw new StringCalculatorInvalidInputException("Expression ends with Delimiter");
        }
        return numStr.split("["+Delimiter+"]",0);


    }String[] myBetterSplit(String numStr,String Delimiter) throws StringCalculatorInvalidInputException{ //throws Exception{

        if(CheckForDelimiterAtTheEnd(numStr,Delimiter)) {
        throw new StringCalculatorInvalidInputException("Expression ends with Delimiter");
        }
        String setOfSpecials = ".,!@#$%^&*()_+-=/~";
        String setOfSpecialsEdited = "\\.\\,\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\-\\=\\/\\~";
        Delimiter = Delimiter.replace("*","\\*");
        Delimiter = Delimiter.replace("$","\\$");
        Delimiter = Delimiter.replace(".","\\.");
        Delimiter = Delimiter.replace(",","\\,");
        Delimiter = Delimiter.replace("!","\\!");
        Delimiter = Delimiter.replace("&","\\&");
        Delimiter = Delimiter.replace("?","\\?");
        Delimiter = Delimiter.replace("#","\\#");
        Delimiter = Delimiter.replace("-","\\-");
        Delimiter = Delimiter.replace("+","\\+");
        Delimiter = Delimiter.replace("~","\\~");
//        Delimiter = Delimiter.replace("\\","\\\\");


        return numStr.split(Delimiter,0);
    }

    String DelimiterCutter(String numStr){
        return numStr.substring(numStr.indexOf("\n")+1);
    }

    String DelimiterFinder(String numStr,String index){
        if(Objects.equals(index, "WithBrackets")){

        //ADD CYCLE AND VARIABLE FOR MORE BRACKETS SITUATION

        return numStr.substring(numStr.indexOf("[")+1,numStr.indexOf("]"));
        }

        return numStr.substring(numStr.indexOf("//")+2,numStr.indexOf("\n"));
    }

    boolean CheckTemplate(String numStr){
        return Pattern.compile("//[\\W_]\n[0123456789]+[\\W_]").matcher(numStr).find();
    }
    boolean CheckSchemeWithBrackets(String numStr){
        return Pattern.compile("//\\[*[\\W,#;_]*[\\W,#;_]]\n[0123456789]*([\\W,#;_])").matcher(numStr).find();
//        return Pattern.compile("//\\[\\W,#;_+]\\n(\\d+(\\*+\\d+)*)*").matcher(numStr).find();
    }

    boolean CheckForDelimiterAtTheEnd (String numStr, String Delimiter){
        String str = ("[" + Delimiter + "]$");
        return Pattern.compile(str).matcher(numStr).find();
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

    public int add (String numStr) throws StringCalculatorInvalidInputException,StringCalculatorNegativeException {
        //    public String numStr;
        int result = 0;

        String[] StringMas;

        if (CheckSchemeWithBrackets(numStr)) {
            StringMas = myBetterSplit(DelimiterCutter(numStr), DelimiterFinder(numStr, "WithBrackets"));
        } else
        if (CheckTemplate(numStr)) {

            StringMas = mySplit(DelimiterCutter(numStr), DelimiterFinder(numStr, ""));
            } else {
                StringMas = mySplit(numStr, ",\n");
            }

        if (StringMas[0].isEmpty()) {
            return result;
        }

        if (HasNegative(StringMas)){
            String NegationMessage = "Negatives are not allowed : ";
            NegationMessage = NegationMessage.concat(ListOfNegatives(StringMas));
            throw new StringCalculatorNegativeException(NegationMessage);
        }



        for (String num : StringMas) {
            if (!(Integer.parseInt(num)>1000)){
            result += Integer.parseInt(num);
            }
        }
        return result;
    }
}




