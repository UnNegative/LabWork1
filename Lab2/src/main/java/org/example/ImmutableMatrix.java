package org.example;

public class ImmutableMatrix extends Matrix{


    public ImmutableMatrix(Matrix myMatrice) throws MuteImmutableException {
          {
            setRows(myMatrice.rows);
            setColumns(myMatrice.columns);
            copyMatrix(myMatrice);
        }
    }

    @Override
    public void setRows(int rows) throws MuteImmutableException{
        throw new MuteImmutableException("Mute Immutable not allowed!");
    }
    @Override
    public void setColumns(int rows) throws MuteImmutableException{
        throw new MuteImmutableException("Mute Immutable not allowed!");
    }
}
