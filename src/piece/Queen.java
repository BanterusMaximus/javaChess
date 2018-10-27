package piece;

import move.MoveList;

public class Queen extends Piece {
	
	public Queen(boolean color) {
		
		super(color);
	}
	
	public MoveList[] getPieceMoves() {
		
		MoveList[] m = {
				
				MoveList.UP,
				MoveList.UP_RIGHT,
				MoveList.RIGHT,
				MoveList.DOWN_RIGHT,
				MoveList.DOWN,
				MoveList.DOWN_LEFT,
				MoveList.LEFT,
				MoveList.UP_LEFT
		};
		
		return m;
	}
	
	public boolean usesSingleMove() {
		
		return false;
	}
	
	public String getName() {

		return "queen";
	}
}
