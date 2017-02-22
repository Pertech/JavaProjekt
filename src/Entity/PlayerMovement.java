package Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import WorldObject.WorldObjectSingleton;

public class PlayerMovement implements KeyListener{
	
	Player player;
	
	public PlayerMovement(Player p) {
		// TODO Auto-generated constructor stub
		player = p;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int x = 0;
		int y = 0;
		if(e.getKeyCode() == KeyEvent.VK_W){
			y--;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			y++;
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			x--;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			x++;
		}
		
		WorldObjectSingleton.getInstance().checkCollision(player, x, y);
		
		if(player.canMove()){
			player.setPosX(player.getPosX() + x);
			player.setPosX(player.getPosY() + y);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
