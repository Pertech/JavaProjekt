package GUI;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import Entity.Player;
import GUI.Interface.IGUIFrame;
import WorldObject.WorldObject;
import WorldObject.WorldObjectSingleton;

public class Room extends JPanel implements IGUIFrame{
	
	private Player player;
	
	
	
	public Player getPlayer() {
		return player;
	}

	@Override
	public JPanel loadGUI() {
		try {
			player = new Player(50, 250, 40, 40);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public JPanel updateGUI() {
		// TODO Auto-generated method stub
		repaint();
		return this;
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(WorldObject wo : WorldObjectSingleton.getInstance().getWorldObjects()){
			g.drawImage(wo.getImage(), wo.getPosX(), wo.getPosY(), this);
		}
		if(player != null){
			g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), this);
		}
	}
	
}
