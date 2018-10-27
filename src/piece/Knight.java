package piece;

import move.MoveList;

public class Knight extends Piece {
	
	public Knight(boolean color) {
		
		super(color);
	}
	
	public MoveList[] getPieceMoves() {
		
		MoveList[] m = {
				
				MoveList.KNIGHT_LEFT_UP,
				MoveList.KNIGHT_UP_LEFT,
				MoveList.KNIGHT_RIGHT_UP,
				MoveList.KNIGHT_UP_RIGHT,
				MoveList.KNIGHT_LEFT_DOWN,
				MoveList.KNIGHT_DOWN_LEFT,
				MoveList.KNIGHT_RIGHT_DOWN,
				MoveList.KNIGHT_DOWN_RIGHT
		};
		
		return m;
	}
	
	public boolean usesSingleMove() {
		
		return true;
	}
	
	public String getName() {
		
		return "knight";
	}
}
