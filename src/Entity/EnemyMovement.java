package Entity;

import java.awt.event.KeyEvent;
import java.util.Random;

import Collision.CollisionDetection;
import GUI.Interface.IMovement;

/**
 * 
 * @author Micha Meystre
 * @version 1.0
 * Macht das Movement von den Gegener. Sie bewegen sich in zufällige Richtungen.
 *
 */
public class EnemyMovement implements IMovement{
	
	private Entity e;
	private int speed = 1;
	private int direction = 0;
	
	/**
	 * Speichert den mitgegebenen Emeny ein
	 * @param e Den Aktuellen Enemy, für den man das Movement machen will
	 */
	public EnemyMovement(Entity e) {
		this.e = e;
	}

	@Override
	/**
	 * Macht das eigentliche Movement und falls eine Collision entsteht ruft er die Methode changeDirection auf welche eine andere Richtung zurück gibt
	 */
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
		
		CollisionDetection.getInstance().checkCollision((Entity)e, EnemySingleton.getInstance().getEnemies(), x, y);
		
		if(e.canMove()){
			e.setPosX(e.getPosX() + x);
			e.setPosY(e.getPosY() + y);
		} else {
			changeDirection();
		}
	}

	@Override
	/**
	 * Gibt eine zufällige Richtung zurück. Es sind die Richtungen 0, 1, 2, 3 möglich.
	 */
	public void changeDirection() {
		Random rand = new Random();
		direction = rand.nextInt(4);
	}

}
