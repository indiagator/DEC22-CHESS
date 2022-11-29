import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChessApp
{
    List<List<Square>> board = new ArrayList<>(); // File is the Outer List | Rank is the Inner List
    Set<Piece> pieces =new HashSet<>();
    List<Move> moves = new ArrayList<>();

    void initBoard()
    {
        int pieceCntr = 0;
        for (int i = 0; i < 8; i++) // file
        {
            char file='!';
            switch (i)
            {
                case 0 : file = 'a';break;
                case 1 : file = 'b';break;
                case 2 : file = 'c';break;
                case 3 : file = 'd';break;
                case 4 : file = 'e';break;
                case 5 : file = 'f';break;
                case 6 : file = 'g';break;
                case 7 : file = 'h';break;
            }

            List<Square> fileList = new ArrayList<>();

            for (int j = 1; j < 9; j++) // rank
            {
                int rank =j;
                Square square = new Square(file,rank);
                Piece piece = null;

                if(rank == 8)
                {
                    switch (file)
                    {
                        case 'e' : piece = new Piece('w','K',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'd' : piece = new Piece('w','Q',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'a' : piece = new Piece('w','R',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'h' : piece = new Piece('w','R',(byte)2);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'b' : piece = new Piece('w','N',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'g' : piece = new Piece('w','N',(byte)2);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'c' : piece = new Piece('w','B',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'f' : piece = new Piece('w','B',(byte)2);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;

                    }
                }

                if(rank == 1)
                {
                    switch (file)
                    {

                        case 'e' : piece = new Piece('b','K',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'd' : piece = new Piece('b','Q',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'a' : piece = new Piece('b','R',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'h' : piece = new Piece('b','R',(byte)2);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'b' : piece = new Piece('b','N',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'g' : piece = new Piece('b','N',(byte)2);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'c' : piece = new Piece('b','B',(byte)1);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;
                        case 'f' : piece = new Piece('b','B',(byte)2);pieces.add(piece);pieceCntr++; piece.setSquare(square); square.setPiece(piece);break;

                    }
                }


                if( rank == 7 )
                {
                   piece = new Piece('w','p', (byte) i);
                   pieces.add(piece);
                   pieceCntr++;
                   piece.setSquare(square);
                   square.setPiece(piece);
                }
                else if ( rank == 2 )
                {
                    piece = new Piece('b','p',(byte)i);
                    pieces.add(piece);
                    pieceCntr++;
                    piece.setSquare(square);
                    square.setPiece(piece);
                }

              fileList.add(square);

                //board[i+j] = square;
                //System.out.print(String.valueOf(file)+String.valueOf(rank)+" ");
            }
            board.add(fileList);
            //System.out.println();
        }

        printBoard();

        //for ( Square[] outerElement: board )
       // {
        //    for ( Square sqr: outerElement)
         //   {
         //       System.out.print(String.valueOf(sqr.getFile())+sqr.getRank()+" ");
         //   }
        //    System.out.println();
        //}

       // System.out.println("*******************");

       // for (int i = 0; i < 8; i++)
       // {
        //    for (int j = 0; j < 8; j++)
         //   {
        //        Square sqr = board[j][i];
         //       System.out.print(String.valueOf(sqr.getFile())+sqr.getRank()+" ");
          //  }
         //   System.out.println();
      //  }

       // System.out.println("*******************");


       // for (int i = 7; i > -1; i--)
        //{
         //   for (int j = 0; j < 8; j++)
         //   {
         //       Square sqr = board[j][i];
         //       System.out.print(String.valueOf(sqr.getFile())+sqr.getRank()+" ");
        //    }
         //   System.out.println();
       // }




        //for (Square s : board)
        //{
        //    System.out.println(s);
        //}
    }

    public void printBoard()
    {
        System.out.println("*******************");

        for (int i = 7; i > -1; i--)
        {
            int rank  = i+1;
            System.out.print(rank+":    ");
            for (int j = 0; j < 8; j++)
            {
                Square sqr =  board.get(j).get(i);           //board[j][i]
                if(sqr.getPiece() != null)
                    System.out.print("["+sqr.getPiece()+"]");
                else System.out.print(" .. ");
            }
            System.out.println();
        }
        System.out.println("        a   b   c   d   e   f   g   h");
    }

    public void printMoves()
    {
        moves.forEach(System.out::println);
    }

    void printKilledPieces()
    {
        List<Piece> killedPieces = pieces.stream().filter(piece -> piece.isKilled()).collect(Collectors.toList());
        System.out.print("Killed Pieces: ");
        killedPieces.forEach(piece -> System.out.print(piece+" "));
        System.out.println();
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to the BOARD");
        ChessApp chessApp = new ChessApp();
        chessApp.initBoard();

        boolean continueGame = true;

        int moveCntr = 1;

        while(continueGame)
        {
            boolean wKillFlag=false;
            boolean bKillFlag=false;

            System.out.print("White Player's Move --> "); // squareIdOld,squareIdNew
            Scanner movescanner = new Scanner(System.in);
            String whiteMoveString = movescanner.next();

            String[] whiteMoveData = whiteMoveString.split(",");

            Function< String, Predicate< List<Square> > > outerFunction = sqrId -> {

                Predicate<List<Square>> outerPredicate = fileList -> fileList.stream().filter(square -> square.getSqrId().equals(sqrId)).findFirst().isPresent();
                return outerPredicate;
            };

            Function<String, Predicate<Square> > innerFunction = sqrId -> {

                Predicate<Square> innerPredicate = square -> square.getSqrId().equals(sqrId);
                return innerPredicate;

            };

            Square oldWhiteSquare = chessApp.board.stream().filter(outerFunction.apply(whiteMoveData[0])).findFirst().get().stream().filter(innerFunction.apply(whiteMoveData[0])).findFirst().get();
            Square newWhiteSquare = chessApp.board.stream().filter(outerFunction.apply(whiteMoveData[1])).findFirst().get().stream().filter(innerFunction.apply(whiteMoveData[1])).findFirst().get();

            Piece wPiece = oldWhiteSquare.getPiece();
            wPiece.setSquare(newWhiteSquare);
            wKillFlag = newWhiteSquare.isEmpty()?false:true;
            if (wKillFlag == true)
                newWhiteSquare.getPiece().kill();
            newWhiteSquare.setPiece(wPiece);
            oldWhiteSquare.clear();

            chessApp.printBoard();
            chessApp.printMoves();

            System.out.print("Black Player's Move --> "); // squareIdOld,squareIdNew
            String blackMoveString = movescanner.next();

            String[] blackMoveData = blackMoveString.split(",");
            Square oldBlackSquare = chessApp.board.stream().filter(outerFunction.apply(blackMoveData[0])).findFirst().get().stream().filter(innerFunction.apply(blackMoveData[0])).findFirst().get();
            Square newBlackSquare = chessApp.board.stream().filter(outerFunction.apply(blackMoveData[1])).findFirst().get().stream().filter(innerFunction.apply(blackMoveData[1])).findFirst().get();

            Piece bPiece = oldBlackSquare.getPiece();
            bPiece.setSquare(newBlackSquare);
            bKillFlag = newBlackSquare.isEmpty()?false:true;
            if (bKillFlag == true)
                newBlackSquare.getPiece().kill();
            newBlackSquare.setPiece(bPiece);
            oldBlackSquare.clear();

            chessApp.printBoard();

            //Creating and Storing the Move

            char wSpclNotation ='!';
            char bSpclNotation ='!';

            if(wKillFlag == true)
            {
                wSpclNotation = 'x';
            }

            if(bKillFlag == true)
            {
                bSpclNotation = 'x';
            }

            Move move = new Move(moveCntr,wPiece,bPiece,newWhiteSquare,newBlackSquare,wSpclNotation,bSpclNotation);
            chessApp.moves.add(move);
            chessApp.printKilledPieces();
            chessApp.printMoves();
            moveCntr++;




            //Scanner movescanner = new Scanner(System.in);


            //Predicate<List<Square>> outerPredicate = fileList -> fileList.stream().filter(square -> square.getSqrId().equals(whiteMoveData[0])).findFirst().isPresent();
            //Predicate<Square> innerPredicate = square -> square.getSqrId().equals(whiteMoveData[0]);




            //Predicate<List<Square>> outerPredicate = fileList -> fileList.stream().filter(square -> square.getSqrId().equals(whiteMoveData[0])).findFirst().isPresent();
            //Predicate<Square> innerPredicate = square -> square.getSqrId().equals(whiteMoveData[0]);




            // int wI=0;int wJ=0;

           // outer:for (int i = 0; i < 8; i++)
            //{
            //    for (int j = 0; j < 8 ; j++)
             //   {
               //     if(chessApp.board.get(i).get(j).getSqrId().equals(whiteMoveData[1]))
               //     {
                  //      wI = i; wJ=j;
                  //      break outer;
                  ///  }
              //  }
           // }


           // = chessApp.board[wI][wJ];

            //int wPI=0;
           // for (int i = 0; i < 32; i++)
           // {
             //   if(chessApp.pieces[i].getId().equals(whiteMoveData[0]))
             //   {
             //       wPI = i;break;
             //   }
           // }

           // Piece whitePiece = chessApp.pieces[wPI];
           // whitePiece.getSquare().clear();
          //  whitePiece.setSquare(newWhiteSquare);
          //  newWhiteSquare.setPiece(whitePiece);

          //  chessApp.printBoard();


           // System.out.print("Black Player's Move --> "); // pieceId,squareId
           // String blackMoveString = movescanner.next();

           // String[] blackMoveData = blackMoveString.split(",");

          //  int bI=0;int bJ=0;

          //  outer:for (int i = 0; i < 8; i++)
          //  {
            //    for (int j = 0; j < 8 ; j++)
            //    {
            //        if(chessApp.board[i][j].getSqrId().equals(blackMoveData[1]))
             //       {
               //         bI = i; bJ=j;
                //        break outer;
                 //   }
              //  }
            //}

           // Square newBlackSquare= chessApp.board[wI][wJ];

           // int bPI=0;
          //  for (int i = 0; i < 32; i++)
           // {
             //   if(chessApp.pieces[i].getId().equals(blackMoveData[0]))
             //   {
             //       bPI = i;break;
              //  }
           // }

            //Piece blackPiece = chessApp.pieces[bPI];
           // blackPiece.getSquare().clear();
           // blackPiece.setSquare(newBlackSquare);
           // newBlackSquare.setPiece(blackPiece);

           // chessApp.printBoard();






        }

    }
}