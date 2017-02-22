package Entity;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {

	public Player(int posX, int posY, int sizeX, int sizeY) throws IOException {
		super(ImageIO.read(new File("res/wall.png")), posX, posY, sizeX, sizeY);
		// TODO Auto-generated constructor stub
	}

}
