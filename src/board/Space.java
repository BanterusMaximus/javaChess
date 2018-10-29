package board;

import java.awt.Toolkit;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import piece.Piece;
import windows.Main;

public class Space extends Button {
	
	private int x;
	private int y;
	private Piece piece;
	
	public Space(boolean white, int x, int y) {
		
		super();
		this.x = x;
		this.y = y;
		this.piece = null;
		this.getStyleClass().add("chess-space");
		
		if ( white ) 
			this.getStyleClass().add("chess-space-white");
		else
			this.getStyleClass().add("chess-space-black");
		
		if ( Main.primaryStage.isFullScreen() == true)
		{
			//As there are 8 squares need to divide it by 8
			double dimensionsOfSquare = ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-25) / 8);
			
			String styleString = null;
			styleString = String.format("-fx-pref-height: %f; -fx-pref-width: %f",dimensionsOfSquare,dimensionsOfSquare);
			
			this.setStyle(styleString);

		}
		
	}
	
	public boolean isOccupied() {
		
		return (this.piece != null);
	}
	
	public Piece removePiece() {
		Piece tempPiece = this.piece;
		setPiece(null);
		return tempPiece;
	}
	
	public Piece getPiece() {
		
		return this.piece;
	}
	
	public void setPiece(Piece piece) {
		
		this.piece = piece;
		
		if ( this.piece != null )
			this.setGraphic( new ImageView ( piece.getImage() ) );
		else
			this.setGraphic( new ImageView() );
		
	}
	
	public String getPieceColor() {
		
		if ( getPiece() != null )
			return getPiece().getColor();
		else
			return "";
	}
	
	public void setX ( int xCurrent) {
		
		this.x = xCurrent;
	}
	
	public void setY ( int yCurrent ) {
		
		this.y = yCurrent;
	}
	
	public int getX() {
		
		return this.x;
	}
	
	public int getY() {
		
		return this.y;
	}
	
	

}
