package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LabTests {
    @Test
    void EmptyMatriceCreate(){
        Matrix A = new Matrix();
        Assertions.assertEquals(A.getRows(),0);
        Assertions.assertEquals(A.getColumns(),0);
    }
    @Test
    void RowByColumnMatriceCreate() throws NegativeMatrixSizeException {
        Matrix A = new Matrix(4,4);
        Assertions.assertEquals(A.getRows(),4);
        Assertions.assertEquals(A.getColumns(),4);
    }
    @Test
    void NegativeDimensinOfMatrice() throws NegativeMatrixSizeException {
//        Matrix A = new Matrix(-3,-1);
        Assertions.assertThrows(NegativeMatrixSizeException.class,()->new Matrix(-3,-1));
        Assertions.assertThrows(NegativeMatrixSizeException.class,()->new Matrix(-3,-1));
    }

    @Test
    void CopyingMatricesDimension() throws NegativeMatrixSizeException {
        Matrix A = new Matrix(4, 4);
        Matrix B = new Matrix(A);
        Assertions.assertEquals(B.getRows(), A.getRows());
        Assertions.assertEquals(B.getColumns(), A.getColumns());
    }

    @Test
    void FullCopyingMatrices() throws NegativeMatrixSizeException {
        Matrix A = new Matrix(4, 4);
        double[][] val = {{1,  2,  3,  4 },
                          {5,  6,  7,  8 },
                          {9,  10, 11, 12},
                          {13, 14, 15, 16}};
        A.fillingMatrixFromArray(val,A);
        Matrix B = new Matrix(A);
        for (int i = 0; i<A.getRows();i++){
            for (int j = 0; j< A.getColumns();j++){
                Assertions.assertEquals(A.getContent()[i][j],B.getContent()[i][j]);
            }
        }
        for (int i = 0; i<A.getRows();i++){
            for (int j = 0; j< A.getColumns();j++){
                Assertions.assertEquals(A.getContent()[i][j],val[i][j]);
            }
        }
        Assertions.assertEquals(val[0][0],1.0);
    }
    @Test
    void SlicingTest(){
        Matrix A = new Matrix(5, 4);
        double[][] val = {{1,  2,  3,  4 },
                          {5,  6,  7,  8 },
                          {9,  10, 11, 12},
                          {13, 14, 15, 16},
                          {17, 18, 19, 20}};
        A.fillingMatrixFromArray(val,A);
        Matrix ARow = A.getRow(3); // 13 14 15 16
        Matrix AColumn = A.getColumn(2); // 3,7,11,15,19
        double AElem = A.getElem(2,3); // 12
        for (int j=0 ; j< A.getColumns();j++){
            Assertions.assertEquals(val[3][j],ARow.getContent()[0][j]);
        }
        for (int j=0 ; j< A.getRows();j++){
            Assertions.assertEquals(val[j][2],AColumn.getContent()[j][0]);
        }
        Assertions.assertEquals(AElem,12.0);
    }
    @Test
    void SlicingTestErrors(){
        Matrix A = new Matrix(5, 4);
        double[][] val = {{1,  2,  3,  4 },
                          {5,  6,  7,  8 },
                          {9,  10, 11, 12},
                          {13, 14, 15, 16},
                          {17, 18, 19, 20}};
        A.fillingMatrixFromArray(val,A);
        Assertions.assertThrows(OutOfMatrixException.class,()->A.getColumn(6));
        Assertions.assertThrows(OutOfMatrixException.class,()->A.getRow(6));
        Assertions.assertThrows(OutOfMatrixException.class,()->A.getElem(3,14));
        Assertions.assertThrows(OutOfMatrixException.class,()->A.getColumn(-6));
        Assertions.assertThrows(OutOfMatrixException.class,()->A.getRow(-6));
        Assertions.assertThrows(OutOfMatrixException.class,()->A.getElem(-3,1));
    }
    @Test
    void GetSizeTest(){
        Matrix A = new Matrix(3,14);
        int[] val = new int[]{3,14};
        for (int i=0;i<2;i++) {
        Assertions.assertEquals(A.getSize()[i],val[i]);
        }
    }
}
