package board;

import javafx.scene.layout.GridPane;
import move.MoveInformation;
import move.MoveList;
import piece.Piece;

public class ChessBoard extends GridPane {

	public Space[][] spaces = new Space[8][8];

	public Space activeSpace = null;

	public ChessBoard() {
		
		super();
		
		for ( int i = 0; i < spaces[0].length; i++ ) {
			for ( int j = 0; j < spaces[1].length; j++ ) {
				
				boolean whiteSpace = ( ( i + j ) % 2 != 0 );
				spaces[i][j] = new Space ( whiteSpace, i, j );
				
				
				this.add(spaces[i][j], i, 7 - j);
				
				
				final int xVal = i;
				final int yVal = j;
				
				spaces[i][j].setOnAction ( e -> onSpaceClick (xVal, yVal) );
			}
		}
	
		
		this.defineStartPositions();
	}
	
	public Space getSpace( int x, int y ) {
		return spaces[x][y];
	}
	
	public void setActiveSpace(Space s) {
		
		if ( this.activeSpace != null )
			this.activeSpace.getStyleClass().removeAll("chess-active-space");
		
		this.activeSpace = s;
		
		if ( this.activeSpace != null )
			this.activeSpace.getStyleClass().add("chess-active-space");
		
		
	}
	
	public Space getActiveSpace() {
		
		return this.activeSpace;
	}
	
	public String toString() {
		
		String pieceList = "";
		
		for ( int i = 0; i < spaces[0].length; i++ ) {
			for ( int j = 0; j < spaces[1].length; j++ ) {
				if ( spaces[i][j].isOccupied()) {
					
					pieceList += spaces[i][j].toString();
				}
			}
		}
		
		return pieceList;
	}
	
    public void defineStartPositions()
    {
        // white pieces
        this.spaces[0][0].setPiece( new Rook  (true) );
        this.spaces[1][0].setPiece( new Knight(true) );
        this.spaces[2][0].setPiece( new Bishop(true) );
        this.spaces[3][0].setPiece( new Queen (true) );
        this.spaces[4][0].setPiece( new King  (true) );
        this.spaces[5][0].setPiece( new Bishop(true) );
        this.spaces[6][0].setPiece( new Knight(true) );
        this.spaces[7][0].setPiece( new Rook  (true) );

        for (int i = 0; i < this.spaces[0].length; i++)
            this.spaces[i][1].setPiece( new Pawn(true) );

        // black pieces
        this.spaces[0][7].setPiece( new Rook  (false) );
        this.spaces[1][7].setPiece( new Knight(false) );
        this.spaces[2][7].setPiece( new Bishop(false) );
        this.spaces[3][7].setPiece( new Queen (false) );
        this.spaces[4][7].setPiece( new King  (false) );
        this.spaces[5][7].setPiece( new Bishop(false) );
        this.spaces[6][7].setPiece( new Knight(false) );
        this.spaces[7][7].setPiece( new Rook  (false) );

        for (int i = 0; i < this.spaces[0].length; i++)
            this.spaces[i][6].setPiece( new Pawn(false) );
    }
	
    
    public void onSpaceClick(int x, int y) {
    	
    	Space clickedSpace = spaces[x][y];
    	
    	if ( activeSpace != null && activeSpace.getPiece() != null
    			&& clickedSpace.getPieceColor() != activeSpace.getPieceColor()) {
    		
    		MoveInformation m;
    		m = new MoveInformation(activeSpace.getX(), activeSpace.getY(), x, y);
    		
    		
    	}
    	
    	else {
    		
    		if ( spaces[x][y].getPiece() != null ) {
    			
    			this.setActiveSpace(spaces[x][y]);
    		}
    	}
    }
    
    public boolean moveIsValid(MoveInformation p)
    {
        Space oldSpace;
        Space newSpace;
        Piece piece;
        MoveList[] moves;

        // TODO:
        //  -Check if player's king is put into check
        //  -Pawn logic (Possibly implement as part of pawn's movelist?)
        //  -Castling logic

        // Check for null move
        if (p == null) { return false; }

        // Note: Ideally we would check the space coordinates
        //       beforehand, but the try-catch blocks below were
        //       easier to implement.

        // Check if oldSpace in range
        try { oldSpace = spaces[p.getOldX()][p.getOldY()]; }
        catch (NullPointerException e) { return false; }

        // Check if newSpace in range
        try { newSpace = spaces[p.getNewX()][p.getNewY()]; }
        catch (NullPointerException e) { return false; }

        // Check if oldSpace is empty; (no movable piece)
        if (!oldSpace.isOccupied()) { return false; }

        // Check piece's move list
        piece = oldSpace.getPiece();
        moves = piece.getPieceMoves();
        boolean matchesPieceMoves = false;

        //for Pieces that move more than 1 base move (Bishop, Rook, Queen)
        int multiMoveCount;
        int stretchedMoveX;
        int stretchedMoveY;

        //labels this loop to break out later
        MoveLoop:
        for (MoveList m : moves)
        {//iterates through multiple times if has multiple possible moves
            multiMoveCount = 1;
            if(piece.usesSingleMove() == false) {multiMoveCount = 8;}

            boolean hasCollided = false;

            for(int c = 1; c <= multiMoveCount; c++)
            {
                //if the prior run hit a piece of opponent's color, done with this move
                if (hasCollided){break;}

                //stretches a base move out to see if it matches the move made
                stretchedMoveX = m.getX() * c;
                stretchedMoveY = m.getY() * c;

                Space tempSpace;

                //If OOB, go to next move of the piece -- ensures space exists later
                try
                {
                    tempSpace = spaces[p.getOldX() + stretchedMoveX]
                    [p.getOldY() + stretchedMoveY];
                }
                catch (Exception e) { break; }

                //handles piece collision and capturing
                if(tempSpace.isOccupied())
                {
                    hasCollided = true;
                    boolean piecesSameColor = tempSpace.getPiece().getColor() == oldSpace.getPiece().getColor();
                    //stops checking this move if pieces are the same color
                    if (piecesSameColor){ break; }
                }

                //if stretched move matches made move
                if ( p.getGapX() == stretchedMoveX && p.getGapY() == stretchedMoveY)
                {
                    matchesPieceMoves = true;

                    if (pawnValidityCheck(p) == false) {return false;}

                    piece.setHasMoved(true);
                    //breaks out of MoveLoop (both loops)
                    break MoveLoop;
                }
            }
        }
        if (!matchesPieceMoves) { return false; }

        return true;
    }

    protected boolean pawnValidityCheck(MoveInformation p)
    {
        //this should only be called in moveIsValid, so checks are done there
        Space oldSpace = spaces[p.getOldX()][p.getOldY()];
        Space newSpace = spaces[p.getNewX()][p.getNewY()];
        Piece piece = oldSpace.getPiece();

        //If it's not a pawn, it passes
        if ( !piece.getName().equals("pawn")) {return true;}

        //if this is a "straight" move
        if (p.getGapX() == 0)
        {
            //black is negative 1, white is positive 1, for direction later
            int colorMod = p.getGapY() / Math.abs(p.getGapY());

            //if there's a piece in the way for a straight move, don't allow move
            for(int c = 1; c <= Math.abs(p.getGapY()); c++)
            {
                if (  spaces[p.getOldX()][p.getOldY() + (c * colorMod)].isOccupied()  )
                {return false;}
            }
        }
        else //if it's a diagonal move
        {
            //if the target square doesn't have an opposing piece, don't allow move
            if ( (!newSpace.isOccupied()) ||
                    piece.getColor() == newSpace.getPiece().getColor())
            {return false;}
        }

        return true;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
