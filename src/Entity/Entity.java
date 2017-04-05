package Entity;

import java.awt.Image;

import GUI.FrameManager;

/**
 * Die abstrakte Klasse Entity bietet eine Grundlage f�r alle Entities.
 * @version 1.0
 * @author Micha Meystre
 *
 */
public abstract class Entity {
	
	private Image image;
	private int posX;
	private int posY;
	private int sizeX;
	private int sizeY;
	private boolean canMove = true;
	
	/**
	 * Ein Entity wird erstellt.
	 * @param image
	 * @param posX
	 * @param posY
	 * @param sizeX
	 * @param sizeY
	 */
	public Entity(Image image, int posX, int posY, int sizeX, int sizeY) {
		super();
		this.image = image;
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	/**
	 * Wird �berpr�ft ob sich das Entity bewegen kann
	 * @return
	 */
	public boolean canMove() {
		return canMove;
	}

	/**
	 * Definiert ob sich das Entity bewegen kann
	 * @param canMove
	 */
	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	/**
	 * Die X Position wird zur�ckgegeben
	 * @return
	 */
	public int getPosX() {
		return posX;
	}
	
	/**
	 * Die X Position wird gesetzt
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	/**
	 * Die Y Position wird zur�ckgegeben
	 * @return
	 */
	public int getPosY() {
		return posY;
	}
	
	/**
	 * Die Y Position wird gesetzt
	 * @param posY
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	/**
	 * Das Bild wird zur�ckgegeben
	 * @return
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * Die Gr�sse auf der X Achse wird zur�ckgegeben
	 * @return
	 */
	public int getSizeX() {
		return sizeX;
	}
	
	/**
	 * Die Gr�sse auf der Y Achse wird zur�ckgegeben
	 * @return
	 */
	public int getSizeY() {
		return sizeY;
	}
	
	/**
	 * Definiert was bei einer Kollision passieren soll
	 * @param e
	 */
	public void onCollision(Entity e){
		setCanMove(false);
	}

	
}
