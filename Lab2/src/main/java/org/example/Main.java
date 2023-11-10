//package org.example;
//
//import java.util.Objects;
//import java.util.Random;
//import java.util.Scanner;
//import java.util.random.RandomGenerator;
//import java.util.stream.Stream;
//
//public class Main {
//    static String row;
//    private static final int capacity = 20;
//    static String column;
//    static double[][] content;
//    static String choice = "0";
//    static String choice1 = "0";
//    static String choice2 = "0";
//    static Matrix[] MasMatrices = new Matrix[capacity];
//    public static void main(String[] args) throws MuteImmutableException {
////        System.out.println("Fuck me please!");
//
////СУКА
//
//System.out.println("----------------------------------\n" +
//                   "             Welcome              \n" +
//                   "        Enter 'e' to exit         \n" +
//                   "----------------------------------\n");
//        while(true){
//            try{
//
//            System.out.println("\n\nR E S E T \n\n");
//            if (!Objects.equals(choice, "e")){
//                MenuMain();
//                System.out.print("Choose your choice: ");
//                choice = new Scanner(System.in).next();
//                if(Objects.equals(choice,"1")){
////                    MenuInner1();
//                    print("\n\t\t1.Empty\n\t\t2.Rows by Columns\n");
//                    System.out.print("Choose your choice: ");
//                    choice = new Scanner(System.in).next();
//                    if(Objects.equals(choice,"1")){
//                        print("Place :");
//                        choice = new Scanner(System.in).next();
//                        MasMatrices[Integer.parseInt(choice)]=new Matrix();
//                        choice ="negate";
//                    }
//                    if(Objects.equals(choice,"2")){
//                        print("Row :");
//                        row = new Scanner(System.in).next();
//                        print("Column :");
//                        column = new Scanner(System.in).next();
//                        print("Place :");
//                        choice = new Scanner(System.in).next();
//                        MasMatrices[Integer.parseInt(choice)]=new Matrix(Integer.parseInt(row),Integer.parseInt(column));
//                        choice ="negate";
//                    }
//                }
//
//
//                if(Objects.equals(choice,"2")) {
//                    //MenuInner2
//                    print("MenuInner2\n");
//                    print("\t\t1.Manually\n\t\t2.Random(0 - 9.9)\n");
//                    print("Choose your choice: ");
//                    choice = new Scanner(System.in).next();
//                    if (Objects.equals(choice, "1")) {
//                        print("Choose place: ");
//                        choice = new Scanner(System.in).next();
//                        content = MasMatrices[Integer.parseInt(choice)].getContent().clone();
//                        for (int i = 0; i < MasMatrices[Integer.parseInt(choice)].getRows(); i++) {
//                            for (int j = 0; j < MasMatrices[Integer.parseInt(choice)].getColumns(); j++) {
//                                print("Elem [ " + i + " ] [ " + j + " ] = ");
//                                content[i][j] = Double.parseDouble(new Scanner(System.in).next());
//                            }
//                        }
//                        MasMatrices[Integer.parseInt(choice)].fillingMatrix(MasMatrices[Integer.parseInt(choice)], content);
//                        choice = "negate";
//                    }
//                    }
//
//                    if(Objects.equals(choice,"2")){
//                        print("Choose place");
//                        choice = new Scanner(System.in).next();
//                        content = MasMatrices[Integer.parseInt(choice)].getContent().clone();
//                        for (int i = 0; i<MasMatrices[Integer.parseInt(choice)].getRows();i++){
//                            for (int j = 0; j< MasMatrices[Integer.parseInt(choice)].getColumns();j++){
//                                content[i][j] = (double) Math.round(100 * Math.random()) /10;
//                            }
//                        }
//                    MasMatrices[Integer.parseInt(choice)].fillingMatrix(MasMatrices[Integer.parseInt(choice)],content);
//                    choice ="negate";
//                    }
//
//
//                if(Objects.equals(choice,"3")) {
//
//                    print("Choose what copy: ");
//                    choice = new Scanner(System.in).next();
//                    print("Choose place for copy: ");
//                    choice1 = new Scanner(System.in).next();
//                    MasMatrices[Integer.parseInt(choice1)]=new Matrix(MasMatrices[Integer.parseInt(choice)]);
//                    choice ="negate";
//                }
//
//                if(Objects.equals(choice,"4")){
//                    print("\t1.Full \n\t2.Row\n\t3.Column\n\t4.Element\n");
//                    print("Choose your choice: ");
//                    choice = new Scanner(System.in).next();
//                    if(Objects.equals(choice,"1")){
//                        print("Choose matrix: ");
//                        choice = new Scanner(System.in).next();
//                        printMas(MasMatrices[Integer.parseInt(choice)],"Matrix "+Integer.parseInt(choice));
//                        choice ="negate";
//
//                    }
//
//                    if(Objects.equals(choice,"2")){
//                        print("Choose matrix: ");
//                        choice = new Scanner(System.in).next();
//                        print("Choose row: ");
//                        choice1 = new Scanner(System.in).next();
//                        print("Save at :");
//                        choice2 = new Scanner(System.in).next();
//                        MasMatrices[Integer.parseInt(choice2)] = MasMatrices[Integer.parseInt(choice)].getRow(Integer.parseInt(choice1));
//                        printMas(MasMatrices[Integer.parseInt(choice)].getRow(Integer.parseInt(choice1)),"Matrix "+Integer.parseInt(choice));
//                        choice ="negate";
//                    }
//
//                    if(Objects.equals(choice,"3")){
//                        print("Choose matrix: ");
//                        choice = new Scanner(System.in).next();
//                        print("Choose Column: ");
//                        choice1 = new Scanner(System.in).next();
//                        print("Save at :");
//                        choice2 = new Scanner(System.in).next();
//                        MasMatrices[Integer.parseInt(choice2)] = MasMatrices[Integer.parseInt(choice)].getRow(Integer.parseInt(choice1));
//                        printMas(MasMatrices[Integer.parseInt(choice)].getColumn(Integer.parseInt(choice1)),"Matrix "+Integer.parseInt(choice));
//                        choice ="negate";
//                    }
//
//                    if(Objects.equals(choice,"4")){
//                        print("Choose matrix: ");
//                        choice = new Scanner(System.in).next();
//                        print("Choose Row :");
//                        choice1 = new Scanner(System.in).next();
//                        print("Choose Column: ");
//                        choice2 = new Scanner(System.in).next();
//                        print("Matrix "+Integer.parseInt(choice)+"Element [ "+choice1+" ] [ "+choice2+" ] = "+ MasMatrices[Integer.parseInt(choice)].getElem(Integer.parseInt(choice1),Integer.parseInt(choice2)));
//                        choice ="negate";
//                    }
//                }
//            }
//         else break;
//        }catch (Exception e){
//                print(e.getMessage());
//            }
//        }
//
//
//    }
//        public static void printMas(Matrix Z,String str) {
//            System.out.println("Rows " + str + " = " + Z.getRows() + "       Columns " + str + " = " + Z.getColumns()+"\n");
//            for (int i = 0; i < Z.getRows(); i++) {
//                for (int j = 0; j < Z.getColumns(); j++) {
//                    System.out.print("       "+Z.getContent()[i][j]);
//                }
//                System.out.println();
//                System.out.println();
//            }
//        }
//    public static void print(String string){
//        System.out.print(string);
//    }
//    public static void MenuMain(){
//        System.out.println("Main Menu:");
//        System.out.println("\t1.Create Matrix");
//        System.out.println("\t2.Fill Matrix");
//        System.out.println("\t3.Copy");
//        System.out.println("\t4.Show");
//        System.out.println("\t5.");
//    }
//
//}
