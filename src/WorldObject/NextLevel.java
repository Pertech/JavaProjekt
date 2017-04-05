package WorldObject;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Entity;
import GUI.FrameManager;

/**
 * Das Objekt "NextLevel"
 * Es wird verwendet um in das nächste Level zu kommen.
 * @version 1.0
 * @author Micha Meystre
 *
 */
public class NextLevel extends WorldObject {

	public NextLevel(int posX, int posY) throws IOException {
		super(ImageIO.read(new File("res/ground.png")), posX, posY);
		// TODO Auto-generated constructor stub
	}

}
