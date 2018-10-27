package piece;

import javafx.scene.image.Image;
import move.MoveList;

public abstract class Piece {
	
	protected boolean hasMoved;
	protected Image image;
	protected boolean color;
	
	public Piece(boolean color) {
		
		this.color = color;
		
		hasMoved = false;
		
		String location = "assets/";
		//System.out.println("lmao");
		String filename = this.getColor() + "_" + this.getName() + ".png";
		System.out.printf("%s", filename);
		this.image = new Image(location + filename);
		
	}
	
	public boolean getHasMoved() {
		
		return this.hasMoved;
	}
	
	public void setHasMoved(boolean shouldBeTrue) {
		
		this.hasMoved = shouldBeTrue;
	}
	
	public Image getImage() {
		
		return this.image;
	}
	
	public String getColor() {
		
		if ( this.color == true ) 
			return "white";
		else
			return "black";
	}
	
	public boolean isWhite() {
		
		return this.color;
	}
	
	public String toString() {
		
		return ( this.getName() + " " + this.getColor());
	}
	
	public abstract MoveList[] getPieceMoves();
	public abstract boolean usesSingleMove();
	public abstract String getName();

}
