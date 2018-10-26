package move;

import java.io.Serializable;


public class MoveInformation implements Serializable {
	
	
	int oldX;
	int oldY;
	int newX;
	int newY;
	
	public MoveInformation() {
		
		oldX = 0;
		oldY = 0;
		newX = 1;
		newY = 1;
	}
	
	public MoveInformation (int oldX, int oldY, int newX, int newY) {
		
		this.oldX = oldX;
		this.oldY = oldY;
		this.newX = newX;
		this.newY = newY;
	}
	
	public String toString() {
		
		return ( getCharLabel( oldX + 1 ) + ( oldY + 1) + " to " 
		+ getCharLabel( newX + 1) + ( newY + 1));
	}
	
	public int getOldX() {
		return this.oldX;
	}
	public int getOldY() {
		return this.oldY;
	}
	public int getNewX() {
		return this.newX;
	}
	public int getNewY() {
		return this.newY;
	}
	
	public void setOldX(int oldX) {
		this.oldX = oldX;
	}
	public void setOldY(int oldY) {
		this.oldY = oldY;
	}
	public void setNewX(int newX) {
		this.newX = newX;
	}
	public void setNewY(int newY) {
		this.newY = newY;
	}
	
    public int getGapX(){return this.newX - this.oldX;}
    public int getGapY(){return this.newY - this.oldY;}
	
	private String getCharLabel(int i) {
		
		String result;
		if ( i > 0 && i < 27 ) {
			result = String.valueOf((char)(i + 64));
		}
		else
			result = null;
		return result;
		}
	}

