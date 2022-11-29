public class Move
{
    final private int number;
    final private Piece whitePiece;
    final private Piece blackPiece;
    final private Square whiteSquare;
    final private Square blackSquare;
    final private char whiteSpecialNotation;
    final private char blackSpecialNotation;

    Move(int number, Piece whitePiece, Piece blackPiece, Square whiteSquare, Square blackSquare, char whiteSpecialNotation, char blackSpecialNotation)
    {
        this.number = number;
        this.whitePiece = whitePiece;
        this.blackPiece = blackPiece;
        this.whiteSquare = whiteSquare;
        this.blackSquare = blackSquare;
        this.whiteSpecialNotation = whiteSpecialNotation;
        this.blackSpecialNotation = blackSpecialNotation;
    }

    @Override
    public String toString()
    {
        String moveNotation = "";
        String wSpclNotationString="";
        String bSpclNotationString="";

        if(whiteSpecialNotation == 'x')
        {
            wSpclNotationString = "x";
        }

        if(blackSpecialNotation == 'x')
        {
            bSpclNotationString = "x";
        }

       return number+".     "+whitePiece.getId()+wSpclNotationString+whiteSquare.getSqrId()+"   "+blackPiece.getId()+bSpclNotationString+blackSquare.getSqrId();
    }
}
