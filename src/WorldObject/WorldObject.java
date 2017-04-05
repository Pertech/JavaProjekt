package WorldObject;

import java.awt.Image;
import java.awt.Rectangle;

import Entity.Entity;

/**
 * Die abstrakte Klasse WorldObject bietet eine Grundlage für alle WorldObjects
 * 
 * @version 1.0
 * @author Micha
 *
 */
public abstract class WorldObject {
	
	private Image image;
	private int posX;
	private int posY;
	
	/**
	 * Erstellt ein WorldObject
	 * @param image
	 * @param posX
	 * @param posY
	 */
	public WorldObject(Image image, int posX, int posY) {
		super();
		this.image = image;
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * Gibt das Bild zurück
	 * @return
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Gibt die Position auf der X-Achse zurück
	 * @return
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Gibt die Position auf der Y-Achse zurück
	 * @return
	 */
	public int getPosY() {
		return posY;
	}
	
	/**
	 * Wird bei einer Kollision ausgeführt
	 * @param e
	 */
	public void onCollision(Entity e){
		e.setCanMove(false);
	}

}
