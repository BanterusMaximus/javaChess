package piece;

import java.util.ArrayList;

import move.MoveList;

public class Pawn extends Piece {
	
	public Pawn(boolean color) {
		
		super(color);
	}
	
	public MoveList[] getPieceMoves() {
		
		boolean isWhite = this.color;
		
		MoveList[] moves = {};
		
		if (isWhite) {
			
			ArrayList<MoveList> whiteMoves = new ArrayList<MoveList>();
			
			whiteMoves.add(MoveList.UP);
			
			whiteMoves.add(MoveList.UP_RIGHT);
			whiteMoves.add(MoveList.UP_LEFT);
			
			if (!hasMoved) {
				whiteMoves.add(MoveList.DOUBLE_UP);
			}
			
			moves = whiteMoves.toArray(moves);
		}
		
		else {
			
			ArrayList<MoveList> blackMoves = new ArrayList<MoveList>();
			
			blackMoves.add(MoveList.DOWN);
			
			blackMoves.add(MoveList.DOWN_RIGHT);
			blackMoves.add(MoveList.DOWN_LEFT);
			
			if (!hasMoved) {
				blackMoves.add(MoveList.DOUBLE_DOWN);
			}
			
			moves = blackMoves.toArray(moves);
		}
		
		return moves;
	}
	
	public boolean usesSingleMove() {
		
		return true;
	}
	
	public String getName() {
		
		return "pawn";
	}
	

}
