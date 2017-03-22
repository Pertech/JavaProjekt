package Entity;

import java.awt.Image;

public abstract class Entity {
	
	private Image image;
	private int posX;
	private int posY;
	private int sizeX;
	private int sizeY;
	private boolean canMove = true;
	
	public Entity(Image image, int posX, int posY, int sizeX, int sizeY) {
		super();
		this.image = image;
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public boolean canMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getSizeX() {
		return sizeX;
	}
	
	public int getSizeY() {
		return sizeY;
	}
	
	public void onCollision(Entity e){
		e.setCanMove(false);
	}

	
}
