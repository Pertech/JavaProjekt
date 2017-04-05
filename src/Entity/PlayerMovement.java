package Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Collision.CollisionDetection;
import WorldObject.WorldObjectSingleton;

/**
 * 
 * @author Micha Meystre
 * @version 1.0
 * Macht das Player-Movement. Hier ist ausserdem die Geschwindigkeit des Spielers gespeichert.
 *
 */
public class PlayerMovement implements KeyListener{
	
	private Player player;
	private int speed = 3;
	
	/**
	 * Konstruktor: Speichert den migegebenen Player
	 * @param p Der aktuelle Player
	 */
	public PlayerMovement(Player p) {
		// TODO Auto-generated constructor stub
		player = p;
	}
	
	@Override
	/**
	 * Behandelt was passiert, wenn man eine Taste druckt. Checkt, ob es 'W', 'S', 'A' oder 'D' ist und bewegt dann den Spieler in die korrekte Richtung.
	 */
	public void keyPressed(KeyEvent e) {
		int x = 0;
		int y = 0;
		if(e.getKeyCode() == KeyEvent.VK_W){
			y -= speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			y += speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			x -= speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			x += speed;
		}
		
		CollisionDetection.getInstance().checkCollision((Entity)player, x, y);
		
		if(player.canMove()){
			player.setPosX(player.getPosX() + x);
			player.setPosY(player.getPosY() + y);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
