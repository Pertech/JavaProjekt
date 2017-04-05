package Entity;

import java.awt.event.KeyEvent;
import java.util.Random;

import Collision.CollisionDetection;
import GUI.Interface.IMovement;

public class EnemyMovement implements IMovement{
	
	private Entity e;
	private int speed = 1;
	private int direction = 0;
	
	public EnemyMovement(Entity e) {
		this.e = e;
	}

	@Override
	public void move() {
		int x = 0;
		int y = 0;
		switch (direction) {
			case 0:
				x -= speed;
				break;
				
			case 1:
				x += speed;
				break;
				
			case 2:
				y -= speed;
				break;
	
			default:
				y += speed;
				break;
		}
		
		CollisionDetection.getInstance().checkCollision((Entity)e, x, y);
		
		if(e.canMove()){
			e.setPosX(e.getPosX() + x);
			e.setPosY(e.getPosY() + y);
		} else {
			changeDirection();
		}
	}

	@Override
	public void changeDirection() {
		Random rand = new Random();
		direction = rand.nextInt(4);
	}

}
