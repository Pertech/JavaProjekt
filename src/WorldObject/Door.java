package WorldObject;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Door extends WorldObject {

	public Door(int posX, int posY) throws IOException {
		super(ImageIO.read(new File("res/door.png")), posX, posY);
		// TODO Auto-generated constructor stub
	}

}
