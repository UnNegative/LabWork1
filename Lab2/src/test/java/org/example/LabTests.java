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

}
