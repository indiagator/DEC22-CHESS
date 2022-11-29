public class Square
{
    final char file;

    final int rank;

    final String sqrId;


    private Piece piece;

    public void clear()
    {
        piece=null;
    }

    public Square(char file, int rank)
    {
        this.file = file;
        this.rank = rank;
        this.sqrId = String.valueOf(file)+rank;
        piece = null;
    }

    public String getSqrId() {
        return sqrId;
    }

    public boolean isEmpty()
    {
        return piece == null?true:false;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public char getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString()
    {
        return String.valueOf(file)+rank;
    }
}
