public class Piece
{
    private final char colour; // b/w
    private final char abbr; //     BLANK,K,Q,R,B,N
    private final String id; //

    private byte serial;

    boolean killed;
    Square square;

    public Piece(char colour, char abbr, byte serial)
    {
        this.colour = colour;
        this.abbr = abbr;
        this.serial = serial;
        this.id = String.valueOf(colour)+String.valueOf(abbr);
        killed=false;
    }

    @Override
    public String toString()
    {
        return id;
    }

    boolean isKilled()
    {
        return killed;
    }

    public void kill()
    {
      killed=true;
      square=null;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public String getId() {
        return id;
    }

    public Square getSquare() {
        return square;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (serial != piece.serial) return false;
        return id.equals(piece.id);
    }

    @Override
    public int hashCode()
    {
        int result = id.hashCode();
        result = 31 * result + (int) serial;
        return result;
    }


}
