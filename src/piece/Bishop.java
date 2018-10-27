package piece;

import move.MoveList;

public class Bishop extends Piece {
	
	public Bishop(boolean color) {
		
		super(color);
	}
	
	public MoveList[] getPieceMoves() {
		
		MoveList[] m = {
				
				MoveList.UP_RIGHT,
				MoveList.UP_LEFT,
				MoveList.DOWN_RIGHT,
				MoveList.DOWN_LEFT
		};
		
		return m;
	}
	
	public boolean usesSingleMove() {
		
		return false;
	}
	
	public String getName() {
		
		return "bishop";
	}

}
