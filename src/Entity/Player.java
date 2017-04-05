package Entity;

import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.FrameManager;
/**
 * 
 * @author Micha Meystre
 * @version 1.0
 * Erstellt den Spieler mit den mitgegebenen Parameter (Position und Grösse)
 *
 */
public class Player extends Entity {

	private KeyListener pm;
	/**
	 * Erstellt den Player.
	 * @param posX Die X-Position, wo der Spieler erstellt werden soll
	 * @param posY Die Y-Position, wo der Spieler erstellt werden soll
	 * @param sizeX Die Grösse vom Spieler in der X-Achse
	 * @param sizeY Die Grösse vom Spieler in der Y-Achse
	 * @throws IOException
	 */
	public Player(int posX, int posY, int sizeX, int sizeY) throws IOException {
		super(ImageIO.read(new File("res/player.png")), posX, posY, sizeX, sizeY);
	}

	
	@Override
	/**
	 * Wenn der Player einen Enemy berührt wird hier der Kampf gestartet.
	 */
	public void onCollision(Entity e){
		if(e instanceof Enemy){
			if(((Enemy) e).isReadyForFight()){
				FrameManager.startFight((Enemy) e);
			}
		}
		e.setCanMove(false);
	}

}
