package piece;

import move.MoveList;

public class King extends Piece {
	
	public King(boolean color) {
		
		super(color);
	}
	
	public MoveList[] getPieceMoves() {
		
		MoveList[] m = {
				
				MoveList.UP,
				MoveList.UP_RIGHT,
				MoveList.UP_LEFT,
				MoveList.DOWN,
				MoveList.DOWN_LEFT,
				MoveList.DOWN_RIGHT,
				MoveList.RIGHT,
				MoveList.LEFT
		};
		
		return m;
	}
	
	public boolean usesSingleMove() {
		
		return true;
	}
	
	public String getName() {
		
		return "king";
	}

}
