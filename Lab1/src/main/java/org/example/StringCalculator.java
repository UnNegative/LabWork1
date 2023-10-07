package org.example;

//import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public StringCalculator(){}

    String[] mySplit(String numStr,String Delimiter) throws StringCalculatorInvalidInputException{ //throws Exception{

        if(CheckForDelimiterAtTheEnd(numStr)) {
        throw new StringCalculatorInvalidInputException("Expression ends with Delimiter");
        }
        return numStr.split("["+Delimiter+"]",0);
    }

    public static String[] MasSplit(String numStr, String[] Delimiters) {
        List<String> result = new ArrayList<>();
        result.add(numStr);

        for (String delimiter : Delimiters) {
            List<String> tempResult = new ArrayList<>();
            for (String part : result) {
                String[] parts = part.split(delimiter);
                for (String subPart : parts) {
                    if (!subPart.isEmpty()) {
                        tempResult.add(subPart);
                    }
                }
            }
            result = tempResult;
        }

        return result.toArray(new String[0]);
    }

    String[] myBestSplit(String numStr,String[] Delimiter) throws StringCalculatorInvalidInputException{ //throws Exception{

        if(CheckForDelimiterAtTheEnd(numStr)) {
        throw new StringCalculatorInvalidInputException("Expression ends with Delimiter");
        }
        for (int i = 0 ; i< Delimiter.length;i++){
            Delimiter[i] = Delimiter[i].replace("*", "\\*");
            Delimiter[i] = Delimiter[i].replace("$", "\\$");
            Delimiter[i] = Delimiter[i].replace(".", "\\.");
            Delimiter[i] = Delimiter[i].replace(",", "\\,");
            Delimiter[i] = Delimiter[i].replace("!", "\\!");
            Delimiter[i] = Delimiter[i].replace("&", "\\&");
            Delimiter[i] = Delimiter[i].replace("?", "\\?");
            Delimiter[i] = Delimiter[i].replace("%", "\\%");
            Delimiter[i] = Delimiter[i].replace("-", "\\-");
            Delimiter[i] = Delimiter[i].replace("+", "\\+");
            Delimiter[i] = Delimiter[i].replace("~", "\\~");
        }
        return MasSplit(numStr,Delimiter);

        //return numStr.split(Delimiter,0);
    }
//    String[] myBetterSplit(String numStr,String Delimiter) throws StringCalculatorInvalidInputException{ //throws Exception{
//
//        if(CheckForDelimiterAtTheEnd(numStr)) {
//        throw new StringCalculatorInvalidInputException("Expression ends with Delimiter");
//        }
//        Delimiter = Delimiter.replace("*","\\*");
//        Delimiter = Delimiter.replace("$","\\$");
//        Delimiter = Delimiter.replace(".","\\.");
//        Delimiter = Delimiter.replace(",","\\,");
//        Delimiter = Delimiter.replace("!","\\!");
//        Delimiter = Delimiter.replace("&","\\&");
//        Delimiter = Delimiter.replace("?","\\?");
//        Delimiter = Delimiter.replace("%","\\%");
//        Delimiter = Delimiter.replace("-","\\-");
//        Delimiter = Delimiter.replace("+","\\+");
//        Delimiter = Delimiter.replace("~","\\~");
//
//
//        return numStr.split(Delimiter,0);
//    }

    String DelimiterCutter(String numStr){
        return numStr.substring(numStr.indexOf("\n")+1);
    }

    String DelimiterFinder(String numStr){
//        if(Objects.equals(index, "WithBrackets")){
//
//        //ADD CYCLE AND VARIABLE FOR MORE BRACKETS SITUATION
//
//        return numStr.substring(numStr.indexOf("[")+1,numStr.indexOf("]"));
//        }

        return numStr.substring(numStr.indexOf("//")+2,numStr.indexOf("\n"));
    }







    public static String[] MasDelimiterFinder(String numStr) {
        ArrayList<String> valuesInBrackets = new ArrayList<>();
        int startIndex, endIndex;

        while ((startIndex = numStr.indexOf('[')) != -1 && (endIndex = numStr.indexOf(']', startIndex)) != -1) {
            // Extract the value within the brackets
            String value = numStr.substring(startIndex + 1, endIndex);

            // Add the extracted value to the list
            valuesInBrackets.add(value);

            // Remove the extracted value (including brackets) from the input string
            numStr = numStr.substring(0, startIndex) + numStr.substring(endIndex + 1);
        }

        return valuesInBrackets.toArray(new String[0]);
    }








//    private String[] MasDelimiterFinder(String numStr) {
//        ArrayList<String> temp = new ArrayList<>();
//        while (numStr.contains("[")&&numStr.contains("]")){
//            temp.add(numStr.substring(numStr.indexOf("[")+1,numStr.indexOf("]")));
//            numStr = numStr.replaceFirst("\\[{0,}.]","");
//        }
//        return temp.toArray(new String[0]);
//    }



//    String [] BetterDelimiterFinder(String numStr,String index) {
//    }

    boolean CheckTemplate(String numStr){
        return Pattern.compile("//[\\W_]\n[0123456789]+[\\W_]").matcher(numStr).find();
    }
        boolean CheckMultiSchemeWithBrackets(String numStr){
        return Pattern.compile("//+(\\[*[\\W,#;_]*[\\W,#;_]])\n[0123456789]*([\\W,#;_])").matcher(numStr).find();
//        return Pattern.compile("//\\[\\W,#;_+]\\n(\\d+(\\*+\\d+)*)*").matcher(numStr).find();
    }
    boolean CheckSingleSchemeWithBrackets(String numStr){
        return Pattern.compile("//\\[*[\\W,#;_]*[\\W,#;_]]\n[0123456789]*([\\W,#;_])").matcher(numStr).find();}
//        return Pattern.compile("//\\[\\W,#;_+]\\n(\\d+(\\*+\\d+)*)*").matcher(numStr).find();


    boolean CheckForDelimiterAtTheEnd(String numStr){
        String str = ("[\\W]$");
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

        if (CheckSingleSchemeWithBrackets(numStr)) {
            if(CheckMultiSchemeWithBrackets(numStr)){
                StringMas = myBestSplit(DelimiterCutter(numStr),MasDelimiterFinder(numStr));
            }
//                StringMas = myBetterSplit(DelimiterCutter(numStr), DelimiterFinder(numStr, "WithBrackets"));
                StringMas = myBestSplit(DelimiterCutter(numStr),MasDelimiterFinder(numStr));
        } else
        if (CheckTemplate(numStr)) {

            StringMas = mySplit(DelimiterCutter(numStr), DelimiterFinder(numStr));
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




