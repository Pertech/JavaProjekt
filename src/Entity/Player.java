package Entity;

import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {

	private KeyListener pm;
	
	public Player(int posX, int posY, int sizeX, int sizeY) throws IOException {
		super(ImageIO.read(new File("res/player.png")), posX, posY, sizeX, sizeY);
		//pm = new PlayerMovement(this);
		// TODO Auto-generated constructor stub
	}

	/*public KeyListener getPlayerMovement() {
		return pm;
	}*/

}
