package WorldObject;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Das Objekt "LastRoomDoor".
 * Wird verwendet als eine Tür, die man nicht öffnen kann.
 * @version 1.0
 * @author Micha
 *
 */
public class LastRoomDoor extends WorldObject {

	public LastRoomDoor(int posX, int posY) throws IOException {
		super(ImageIO.read(new File("res/door.png")), posX, posY);
		// TODO Auto-generated constructor stub
	}

}
