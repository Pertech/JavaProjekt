package Entity;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.FrameManager;
import GUI.Interface.IMovement;

/**
 * 
 * @author Micha
 * @version 1.0
 * Erstellt den Gegener mit den mitgegebenen Parametern (Grösse und Position)
 */
public class Enemy extends Entity {

	private IMovement movement;
	private boolean readyForFight = true;
	/**
	 * Erstellt den Gegner
	 * @param posX Die X-Position, wo der Gegner erstellt werden soll
	 * @param posY Die Y-Position, wo der Gegner erstellt werden soll
	 * @param sizeX Die Grösse vom Gegner in der X-Achse
	 * @param sizeY Die Grösse vom Gegner in der Y-Achse
	 * @throws IOException
	 */
	public Enemy(int posX, int posY, int sizeX, int sizeY) throws IOException {
		super(ImageIO.read(new File("res/enemy.png")), posX, posY, sizeX, sizeY);
		// TODO Auto-generated constructor stub
		
		movement = new EnemyMovement(this);
	}
	
	
	/**
	 * Gibt zurück ob der Gegner bereit ist für einen Kampf. Das heisst ob der Spieler einen Kampf starten darf mit ihm
	 * @return Boolean ob der Gegner bereit ist
	 */
	public boolean isReadyForFight() {
		return readyForFight;
	}


	/**
	 * Macht den Gegner bereit für einen Kampf. Danach kann man einen Kampf starten mit diesem Gegner
	 * @param readyForFight Boolean ob er ready ist für den Kampf
	 */
	public void setReadyForFight(boolean readyForFight) {
		this.readyForFight = readyForFight;
	}


	/**
	 * Gibt das Movement zurück
	 * @return Movement des Gegners
	 */
	public IMovement getMovement() {
		return movement;
	}
	
	@Override
	/**
	 * Behandelt, was passieren soll, wenn es eine Kollision gegeben hat
	 */
	public void onCollision(Entity e){
		if(e instanceof Player){
			if(isReadyForFight()){
				FrameManager.startFight(this);
			}
		}
		e.setCanMove(false);
	}
	
}
