package WorldObject;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Entity;

/**
 * 
 * Das Objekt "Ground"
 * @version 1.0
 * @author Micha Meystre
 *
 */
public class Ground extends WorldObject {

	public Ground(int posX, int posY) throws IOException {
		super(ImageIO.read(new File("res/ground.png")), posX, posY);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCollision(Entity e){
		//nichts passiert
	}

}
