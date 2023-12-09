package org.example;

import java.util.Objects;
import java.util.Scanner;

public class MainGARBAGE {
    static String row;
    private static final int capacity = 20;
    static String column;
    static double[][] content;
//    static String choice = "0";
//    static String choice1 = "0";
//    static String choice2 = "0";
    static Matrix[] MasMatrices = new Matrix[capacity];
    public static void main(String[] args) throws MuteImmutableException {
//        System.out.println("Fuck me please!");

//suka



        try {


//        Matrix A = new Matrix(3,4);
////        for (int i = 0; i < A.getRows(); i++) {
////            for (int j = 0; j < A.getColumns(); j++) {
////                A.setElem(i,j,(double) Math.round(100 * Math.random()) / 10);
////            }
////        }
//        A = Matrix.RandomFilling(A);
//
//
//        printMas(A,"A-ta");
//
//        Matrix Aim =new ImmutableMatrix(A);
//        printMas(Aim,"Aim-ty");
            double[][] a={{1,2,3},{3,4,4},{2,4,3}};
            double[][] d = {{2, 1,1},
                            {1, 1,5}};
//                    {3, 2, 1}};
//
            Matrix m1 = new Matrix(4,4);
            m1 = Matrix.RandomFilling(m1);
            printMas(m1,"m1");

            ImmutableMatrix m2 = new ImmutableMatrix(m1);

            printArray(m2.getSize());


            ImmutableMatrix m3 =new ImmutableMatrix(m2.inverse());

            printMas(m3,"m3");
            printMas(Matrix.multiplicate(m3,m1),"m3*m1");

//            double[][] val = {{2,3},{4,5}};
//            Matrix A = new Matrix(2,2);
//            A.fillingMatrixFromArray(val,A);
//            Matrix B = A.inverse();
//            printMas(B,"B");
//            Matrix C = Matrix.multiplicate(A,B);
//            printMas(C,"Multiple");
//

            double []val1 ={2,3,4,5,6};
            ImmutableMatrix m6=new ImmutableMatrix(Matrix.vectorDiag(val1));
            printMas(m6,"m6");

//            Matrix A = new Matrix(2,3);
//
//            ImmutableMatrix B = new ImmutableMatrix(A);
//
//            B.fillingMatrixFromArray(a,B);
//
//            printMas(B,"BBBB");


//            Matrix B = new Matrix(2, 2);
//            B.fillingMatrixFromArray(d, B);
//            printMas(B, "B-ta");
//            double detB = Matrix.Determinant(B);
//            print("Determinant B = " + detB + "\n");
//            Matrix C = new Matrix(Matrix.Inverse(B));
//            printMas(C, "C-ta");
//            Matrix M = Matrix.multiplicate(C,B);
//            printMas(M, "Multiply");
//            printArray(C.getSize());



//            Matrix D = new Matrix(B);
//            ImmutableMatrix C = new ImmutableMatrix(B);
//            print("YEAH : " + B.equals(C) + "\n");
//            print("YEAH : " + C.equals(B) + "\n");
//
//            print("AHAAA : " + (C.hashCode() == B.hashCode()) + "\n");
//
//            print("YEAH : " + B.equals(D) + "\n");
//            print("YEAH : " + D.equals(B) + "\n");

        }

        catch (Exception er){print("DAAAAAA   "+er.getMessage());}

//        System.out.println("----------------------------------\n" +
//                "             Welcome              \n" +
//                "        Enter 'e' to exit         \n" +
//                "----------------------------------\n");




    }
        public static void printMas(Matrix Z,String str) {
            System.out.println("\nRows " + str + " = " + Z.getRows() + "       Columns " + str + " = " + Z.getColumns()+"\n");
            for (int i = 0; i < Z.getRows(); i++) {
                for (int j = 0; j < Z.getColumns(); j++) {
                    System.out.print("       "+Z.getContent()[i][j]);
                }
                System.out.println();
                System.out.println();
            }
        }

        public static void printArray(int[] array){
        print("Size : ");
                print(" "+array[0]+" by " +array[1]);
            print("\n\n");
        }

    public static void print(String string){
        System.out.print(string);
    }


}
