package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.math.*;
public class Matrix {

    protected int rows;
    protected int columns;
    protected double[][] content; //= new double[rows][columns];

    //Empty matrix
    public Matrix()throws MuteImmutableException{
        rows = 0;
        columns =0;
        createMatrix(0,0);
    }

    //Create Matrix ( row x column )
    public Matrix(int row,int column) throws NegativeMatrixSizeException, MuteImmutableException {
        if (row<0 || column<0) {
            throw new NegativeMatrixSizeException("Negative number of rows or columns!");
        }
        rows =row;
        columns = column;
        createMatrix(row,column);
    }

    //copying matrix Constructor A[MxK]  -> B[MxK]
    public Matrix(Matrix myMatrice) throws MuteImmutableException {
        rows =myMatrice.rows;
        columns =myMatrice.columns;
        copyMatrix(myMatrice);
    }


    void createMatrix(int row,int column){
        content = new double[row][column];
    }

    void copyMatrix(Matrix matrice){
        this.content = new double[matrice.rows][matrice.columns];
        fillingMatrix(matrice,this.content);
    }

    public void fillingMatrix(Matrix matrice,double[][] contentB){
        for (int i = 0; i<matrice.getRows();i++){
            for (int j = 0; j< matrice.getColumns();j++){
               contentB[i][j]=matrice.content[i][j];
            }
        }
    }
    public void fillingMatrixFromArray(double[][] values,Matrix matrix) throws MuteImmutableException {
        for (int i = 0; i<matrix.getRows();i++){
            for (int j = 0; j< matrix.getColumns();j++){
                matrix.setElem(i,j,values[i][j]);
            }
        }
    }

//    void writeElem(double[][] content,double value,int row,int column){
//        content[row][column] = value;
//    }

    public void setRows(int rows) throws MuteImmutableException {
        this.rows = rows;
    }

    public void setColumns(int columns) throws MuteImmutableException {
        this.columns = columns;
    }

    public void setElem(int row,int column,double value) throws MuteImmutableException{
        this.getContent()[row][column]=value;
    }


    double getElem(int row,int column){
        if(row >= rows || row<0 ||column>=columns || column<0){
            throw new OutOfMatrixException("Out of matrix size element!");
        }
        return content[row][column];
    }

    Matrix getRow(int row) throws OutOfMatrixException, MuteImmutableException {
        if(row >= rows || row<0){
            throw new OutOfMatrixException("Out of matrix size element!");
        }
        Matrix matrix =new Matrix(1,columns);
        for (int i=0;i<columns;i++){
            matrix.content[0][i] = content[row][i];
        }
        return matrix;
    }

    Matrix getColumn(int column) throws OutOfMatrixException, MuteImmutableException {
        if(column >= columns || column<0) {
            throw new OutOfMatrixException("Out of matrix size element!");
        }
        Matrix matrix =new Matrix(rows,1);
        for (int i=0;i<rows;i++){
         matrix.content[i][0] = content[i][column];
        }
        return matrix;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return getRows() == matrix.getRows() && getColumns() == matrix.getColumns() && Arrays.deepEquals(getContent(), matrix.getContent());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getRows(), getColumns());
        result = 41 * result + Arrays.deepHashCode(getContent());
        return result;
    }

    int getRows(){
        return this.rows;
    }
    int getColumns(){
        return this.columns;
    }
    double[][] getContent(){
        return content;
    }
    int[] getSize(){
        return new int[]{rows,columns};
    }

    static Matrix add(Matrix A,Matrix B) throws MuteImmutableException, IllegalArgumentException {
        if (A.getRows() != B.getRows() || A.getColumns() != B.getColumns()){
            throw new IllegalArgumentException("A and B has different size");
        }
        Matrix matrix = new Matrix(A.getRows(),A.getColumns());
        for (int i = 0; i <A.getRows() ; i++) {
            for (int j = 0; j <A.getColumns() ; j++) {
                matrix.content[i][j] = (A.content[i][j] + B.content[i][j]);
            }
        }
        return matrix;
    }

    static Matrix multiplicate(Matrix A, double lambda) throws MuteImmutableException {
        Matrix matrix = new Matrix(A.getRows(),A.getColumns());
        for (int i = 0; i <A.getRows() ; i++) {
            for (int j = 0; j <A.getColumns() ; j++) {
                matrix.content[i][j] = (A.content[i][j]*lambda);
            }
        }
        return matrix;
    }


    static double Addition(Matrix A,Matrix B,int i ,int j){
        double summa=0;
        for (int k = 0; k < A.rows; k++) {
            summa+= (A.content[i][k]*B.content[k][j]);
        }
        return summa;
    }
    static Matrix multiplicate(Matrix A,Matrix B) throws MuteImmutableException {
        if (A.columns != B.rows){
            throw new IllegalArgumentException("Not suggested matrices!");
        }
        Matrix matrix = new Matrix(A.getRows(),A.getColumns());
        for (int i = 0; i <A.getRows() ; i++) {
            for (int j = 0; j <A.getColumns() ; j++) {
                for (int k =0;k< A.columns;k++){
                matrix.content[i][j] =Addition(A,B,i,j);
                }
            }
        }
        return matrix;
    }

    static Matrix transpose(Matrix matrix) throws MuteImmutableException {
        Matrix transMatrix = new Matrix(matrix.columns, matrix.rows);
        for (int i = 0; i <matrix.getRows() ; i++) {
            for (int j = 0; j <matrix.getColumns() ; j++) {
                transMatrix.content[j][i] = matrix.content[i][j];
            }
        }
        return transMatrix;
    }

    static Matrix identity(int dimension) throws MuteImmutableException {
        Matrix solo = new Matrix(dimension,dimension);
        for (int i = 0; i < dimension; i++) {
            solo.content[i][i] = 1.0;
        }
        return solo;
    }
    static Matrix vectorDiag(double[] values) throws MuteImmutableException {
        Matrix solo = new Matrix(values.length, values.length);
        for (int i = 0; i < values.length; i++) {
            solo.content[i][i] = values[i] ;
        }
        return solo;
    }

    static Matrix getRowRand(int row) throws OutOfMatrixException, MuteImmutableException {
        if(row<0){
            throw new OutOfMatrixException("Out of matrix size element!");
        }
        Matrix matrix =new Matrix(1,row);
        for (int i=0;i<row;i++){
            matrix.content[0][i] = Math.pow (-1,(double) Math.round(1000 * Math.random())) * (double) Math.round(100 * Math.random()) / 10; ;
        }
        return matrix;
    }

    static Matrix getColumnRand(int column) throws OutOfMatrixException, MuteImmutableException {
        if(column<0) {
            throw new OutOfMatrixException("Out of matrix size element!");
        }
        Matrix matrix =new Matrix(column, 1);
        for (int i=0;i<column;i++){
            matrix.content[i][0] = Math.pow (-1,(double) Math.round(1000 * Math.random())) * (double) Math.round(100 * Math.random()) / 10;
        }
        return matrix;
    }

    static Matrix RandomFilling(Matrix A) throws MuteImmutableException {
        Matrix randomMatrix = new Matrix(A.rows,A.columns);
        for (int i = 0; i <A.rows; i++) {
            for (int j = 0; j <A.columns; j++) {
                randomMatrix.setElem(i,j,  (double) Math.round(10 * Math.random()));
            }
        }
            return randomMatrix;
    }

    static double[][] Cutting(double[][] A,int j,int i,int row,int column){
        double[][] minor = new double[row - 1][column - 1];
            for (int m = 0; m < row; m++) {
                for (int n = 0; n < column; n++) {
                    if (n==j||m==i){continue;}
                    if (n>j & m<i){minor[m][n-1]=A[m][n];continue;}
                    if (n>j & m>i){minor[m-1][n-1]=A[m][n];continue;}
                    if (n<j & m>i){minor[m-1][n]=A[m][n];continue;}
                    if (n<j & m<i){minor[m][n]=A[m][n];continue;}
                }
            }
            return minor;
    }
    static double Minor(double[][] A,int row,int column,int orderRow,int orderColumn){
        double minorDet=0;
        double [][] minorMas = Cutting(A,orderRow,orderColumn,row,column);
            if(row == 2){return minorMas[0][0];}
            else{
                for (int i = 0; i < row-1; i++) {

                    minorDet+= Math.pow(-1,i)*(Minor(minorMas,row-1,column-1,i,0));
                }
                return minorDet;
            }
    }

    static double Determinant(Matrix A) throws IllegalMatrixDeterminantException {
        if (A.rows != A.columns) {
            throw new IllegalMatrixDeterminantException("Allowed only square matrices");
        }
        if(A.rows == 1){return A.content[0][0];}
        double det = 0;
        for (int j = 0; j < A.columns; j++) {
            det += A.content[0][j] *Math.pow(-1,j)* Minor(A.content, A.rows, A.columns,j,0);
        }

        return det;
    }



    private double determinant(double[][] matrix) {
        double det = 0;
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        for (int i = 0; i < matrix[0].length; i++) {
            double[][] subMatrix = new double[matrix.length - 1][matrix[0].length - 1];
            for (int m = 1; m < matrix.length; m++) {
                for (int n = 0; n < matrix[0].length; n++) {
                    if (n < i) {
                        subMatrix[m - 1][n] = matrix[m][n];
                    } else if (n > i) {
                        subMatrix[m - 1][n - 1] = matrix[m][n];
                    }
                }
            }
            det += matrix[0][i] * Math.pow(-1, i) * determinant(subMatrix);
        }
        return det;
    }

    public Matrix inverse() throws MuteImmutableException {
        double det = determinant(this.content);
        if (det == 0) {
            throw new IllegalStateException("Matrix is singular and cannot be inverted.");
        }
        double[][] joined = Joined(this.content);
        Matrix inverseMatrix = new Matrix(this.getRows(), this.getColumns());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                inverseMatrix.content[i][j] = joined[i][j] / det;
            }
        }
        return inverseMatrix;
    }

    private double[][] Joined(double[][] matrix) {
        double[][] adj = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                adj[i][j] = Math.pow(-1, i + j) * determinant(minor(matrix, i, j));
            }
        }
        return transpose(adj);
    }

    private double[][] minor(double[][] matrix, int row, int col) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != row && j != col) {
                    minor[i < row ? i : i - 1][j < col ? j : j - 1] = matrix[i][j];
                }
            }
        }
        return minor;
    }
    private double[][] transpose(double[][] matrix) {
        double[][] transposedMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

}