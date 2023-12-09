package org.example;

public final class  ImmutableMatrix extends Matrix{

    /// FUCK THIS SHIT!




    public ImmutableMatrix(Matrix myMatrice) throws MuteImmutableException {
        this.rows = myMatrice.getRows();
        this.columns = myMatrice.getColumns();
        this.content = new double[rows][columns];
        fillingMatrix(myMatrice,content);

    }//      TROUBLES


    @Override
    public void setRows(int rows) throws MuteImmutableException{
        throw new MuteImmutableException("Mute Immutable not allowed!");
    }
    @Override
    public void setColumns(int rows) throws MuteImmutableException{
        throw new MuteImmutableException("Mute Immutable not allowed!");
    }
    @Override
    public void setElem(int row,int column,double value) throws MuteImmutableException{
        throw new MuteImmutableException("Mute Immutable not allowed!");
    }

    @Override
    double[][] getContent(){
        return content.clone();
    }
}
