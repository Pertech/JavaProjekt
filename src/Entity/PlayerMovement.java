package Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import WorldObject.WorldObjectSingleton;

public class PlayerMovement implements KeyListener{
	
	private Player player;
	private int speed = 3;
	
	public PlayerMovement(Player p) {
		// TODO Auto-generated constructor stub
		player = p;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int x = 0;
		int y = 0;
		if(e.getKeyCode() == KeyEvent.VK_W){
			y -= 3;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			y += 3;
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			x -= 3;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			x += 3;
		}
		
		WorldObjectSingleton.getInstance().checkCollision(player, x, y);
		
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
