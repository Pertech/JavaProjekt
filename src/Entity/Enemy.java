package Entity;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.FrameManager;
import GUI.Interface.IMovement;

/**
 * 
 * @author Micha
 *
 */
public class Enemy extends Entity {

	private IMovement movement;
	
	public Enemy(int posX, int posY, int sizeX, int sizeY) throws IOException {
		super(ImageIO.read(new File("res/enemy.png")), posX, posY, sizeX, sizeY);
		// TODO Auto-generated constructor stub
		
		movement = new EnemyMovement(this);
	}

	public IMovement getMovement() {
		return movement;
	}
	
	@Override
	public void onCollision(Entity e){
		if(e instanceof Player){
			FrameManager.startFight(this);
		}
		e.setCanMove(false);
	}
	
}
