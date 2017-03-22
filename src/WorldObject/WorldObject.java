package WorldObject;

import java.awt.Image;
import java.awt.Rectangle;

import Entity.Entity;

public abstract class WorldObject {
	
	private Image image;
	private int posX;
	private int posY;
	
	public WorldObject(Image image, int posX, int posY) {
		super();
		this.image = image;
		this.posX = posX;
		this.posY = posY;
	}

	public Image getImage() {
		return image;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public void onCollision(Entity e){
		e.setCanMove(false);
	}

}
