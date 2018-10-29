package piece;


import javafx.scene.image.Image;
import move.MoveList;
import windows.Main;

public abstract class Piece {
	
	protected boolean hasMoved;
	protected Image image;
	public boolean color;
	
	public Piece(boolean color) {
		
		this.color = color;
		
		hasMoved = false;

		String user = System.getProperty("user.name");
		String location = "file:///C:/Users/" + user + "/Documents/GitHub/javaChess/assets/";
		
		String filename = this.getColor() + "_" + this.getName() + ".png";

		if (Main.primaryStage.isFullScreen() == true){
			this.image = ifFullscreen(location, filename);
		}
		else{
			this.image = new Image(location + filename);
		}	
	}

	public Image ifFullscreen(String location, String filename)
	{
			Image tempImage = new Image((location + filename), 100, 100, true, true); 
			return tempImage;
	}
	
	public boolean getHasMoved() 
	{
		return this.hasMoved;
	}
	
	public void setHasMoved(boolean shouldBeTrue) 
	{
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
