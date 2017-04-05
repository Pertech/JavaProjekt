package WorldObject;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Das Objekt "Wall"
 * Wird für die Wände verwendet.
 * @version 1.0
 * @author Micha
 *
 */
public class Wall extends WorldObject {

	public Wall(int posX, int posY) throws IOException {
		super(ImageIO.read(new File("res/wall.png")), posX, posY);
		// TODO Auto-generated constructor stub
	}

}
