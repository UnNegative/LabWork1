package org.example;

import java.lang.reflect.Array;

public class Matrix {

    private int rows;
    private int columns;
    private double[][] content;

    //Empty matrix
    public Matrix(){
        setRows(0);
        setColumns(0);
        createMatrix(0,0);
    }

    //Create Matrix ( row x column )
    public Matrix(int row,int column) throws NegativeMatrixSizeException{
        if (row<0 || column<0)
        {
            throw new NegativeMatrixSizeException("Negative number of rows or columns!");
        }
        setRows(row);
        setColumns(column);
        createMatrix(row,column);
    }

    //copying matrix Constructor A[MxK]  -> B[MxK]
    public Matrix(Matrix myMatrice){
        setRows(myMatrice.rows);
        setColumns(myMatrice.columns);
        copyMatrix(myMatrice);
    }


    void createMatrix(int row,int column){
        content = new double[row][column];
    }

    void copyMatrix(Matrix matrice){
        content = new double[matrice.rows][matrice.columns];
        fillingMatrix(matrice,content);
    }

    public void fillingMatrix(Matrix matrice,double[][] contentB){
        for (int i = 0; i<matrice.getRows();i++){
            for (int j = 0; j< matrice.getColumns();j++){
                writeElem(contentB,matrice.content[i][j],i,j);
            }
        }
    }
    public void fillingMatrixFromArray(double[][] values,Matrix matrix){
        for (int i = 0; i<matrix.getRows();i++){
            for (int j = 0; j< matrix.getColumns();j++){
                writeElem(matrix.content,values[i][j],i,j);
            }
        }
    }

    void writeElem(double[][] content,double value,int row,int column){
        content[row][column] = value;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    double getElem(int row,int column){
        if(row >= rows || row<0 ||column>=columns || column<0){
            throw new OutOfMatrixException("Out of matrix size element!");
        }
        return content[row][column];
    }

    Matrix getRow(int row) throws OutOfMatrixException{
        if(row >= rows || row<0){
            throw new OutOfMatrixException("Out of matrix size element!");
        }
        Matrix matrix =new Matrix(1,columns);
        for (int i=0;i<columns;i++){
            writeElem(matrix.getContent(),content[row][i],0,i);
        }
        return matrix;
    }

    Matrix getColumn(int column) throws OutOfMatrixException{
        if(column >= columns || column<0) {
            throw new OutOfMatrixException("Out of matrix size element!");
        }
        Matrix matrix =new Matrix(rows,1);
        for (int i=0;i<rows;i++){
            writeElem(matrix.getContent(),content[i][column],i,0);
        }
        return matrix;
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
}