package Entity;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;

import Collision.CollisionDetection;
import WorldObject.WorldObjectSingleton;

public class NewPlayerMovement extends AbstractAction{
	
	private Player player;
	private int speed = 3;
	
	public NewPlayerMovement(String actionCommand, Player p) {
		// TODO Auto-generated constructor stub
		player = p;
		putValue(ACTION_COMMAND_KEY, actionCommand);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x = 0;
		int y = 0;
		if(e.getActionCommand().equalsIgnoreCase("VK_W")){
			y -= speed;
		}
		if(e.getActionCommand().equalsIgnoreCase("VK_S")){
			y += speed;
		}
		if(e.getActionCommand().equalsIgnoreCase("VK_A")){
			x -= speed;
		}
		if(e.getActionCommand().equalsIgnoreCase("VK_D")){
			x += speed;
		}
		
		CollisionDetection.getInstance().checkCollision((Entity)player, x, y);
		
		if(player.canMove()){
			player.setPosX(player.getPosX() + x);
			player.setPosY(player.getPosY() + y);
		}
	}
}
