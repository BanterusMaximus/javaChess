package piece;

import java.io.File;

import javafx.scene.image.Image;
import move.MoveList;

public abstract class Piece {
	
	protected boolean hasMoved;
	protected Image image;
	public boolean color;
	
	public Piece(boolean color) {
		
		this.color = color;
		
		hasMoved = false;
		//insert your username instead of mine
		String user = System.getProperty("user.name");
		String location = "file:///C:/Users/" + user + "/Documents/GitHub/javaChess/assets/";
		//System.out.println("lmao");
		String filename = this.getColor() + "_" + this.getName() + ".png";
		this.image = new Image(location + filename);
		
		//My dumbass trying to resize stuff 
		//Image tempImage = new Image(location+filename);
		
		
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
