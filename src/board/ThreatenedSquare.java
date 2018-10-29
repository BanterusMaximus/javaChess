package board;

import piece.Bishop;
import piece.King;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class ThreatenedSquare {
	
	
	//just to think
	/*
	private boolean threatenedColor;
	private Space threatenedSpace;
	private ChessBoard board;
	
	
	int[] rowDirections = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int[] colDirections = { -1, 0, 1, -1, 1, -1, 0, 1 };
	
	boolean bishopThreats[] = { true, false, true, false, false, true, false, true };
	boolean rookThreats[]   = { false, true, false, true, true, false, true, false };
	boolean queenThreats[]  = { true, true, true, true, true, true, true, true     };
	boolean kingThreats[]   = { true, true, true, true, true, true, true, true     };
	
	private boolean kill;
	
	private boolean getKill() {
	if  ( threatenedColor == false ) {
		kill = true;
	}
	else {
		kill = false;
	}
	
	return kill;
	}
	
	boolean pawnThreats[] = { kill, false, kill, false, false, !kill, false, !kill };
	
	
	private boolean threatDetected() {
		
		boolean threatDetected = false;
		
		int threatenedRow = threatenedSpace.getX();
		int threatenedCol = threatenedSpace.getY();
		
		for ( int direction = 0; direction < 8 && !threatDetected; direction++ ) {
			
			int row = threatenedRow;
			int col = threatenedCol;
			int rowIncrease = rowDirections[direction];
			int colIncrease = colDirections[direction];
			
			for ( int i = 0; i < 8; i++ ) {
				
				row = row + rowIncrease;
				col = col + colIncrease;
				
				if ( row < 0 || row > 7 || col < 0 || col > 7 ) {
					break;
				}
				else {
					
					Space space = board.getSpace(row, col);
					Piece piece = space.getPiece();
					
					if ( piece != null ) {
						
						if ( piece instanceof Bishop && bishopThreats[direction])
							threatDetected = true;
						else if ( piece instanceof Rook && rookThreats[direction])
							threatDetected = true;
						else if ( piece instanceof Queen && queenThreats[direction])
							threatDetected = true;
						else {
							
							if ( i == 0 ) {
								if ( piece instanceof Pawn && pawnThreats[direction])
									threatDetected = true;
								if ( piece instanceof King && kingThreats[direction])
									threatDetected = true;
							}
								
						}
					}
					break;
				}
			}
		}
		return threatDetected;
	}
	*/
	
	
    /*
    public Space kingSpace;
    
    public Space getKingSpace(boolean color) {
    
    	Space tempSpace;
    	for ( int i = 0; i <= 7; i++) {
    		
    		for ( int j = 0; j <= 7; j++ ) {
    			
    			tempSpace = spaces[i][j];
    			if ( tempSpace.getPiece().getName() == "king" ) {
    				
    				tempSpace = kingSpace;
    				return kingSpace;
    			}
    		}
    	
    	

    	}
    	return kingSpace;
    }
    */
    //cycle through x and y to get current king space
    //at end of move check
    //if king's space is threatened 
    //invalid move
    //if kings space is threatened AND king cannot move
    //game over noob
        
    //attempted check function!!
        
}
