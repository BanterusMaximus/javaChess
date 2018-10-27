package piece;

import move.MoveList;

public class Rook extends Piece {
	
	public Rook(boolean color) {
		
		super(color);
	}
	
	public MoveList[] getPieceMoves() {
		
		MoveList[] m = {
				
				MoveList.UP,
				MoveList.RIGHT,
				MoveList.DOWN,
				MoveList.LEFT
		};
		
		return m;
	}
	
	public boolean usesSingleMove() {
		
		return false;
	}
	
	public String getName() {
		
		return "rook";
	}

}
