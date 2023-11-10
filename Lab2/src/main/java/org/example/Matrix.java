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

    void writeElem(double[][] content,double value,int row,int column){
        content[row][column] = value;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
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
}