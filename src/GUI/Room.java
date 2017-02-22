package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

import Entity.Player;
import GUI.Interface.IGUIFrame;
import WorldObject.WorldObject;
import WorldObject.WorldObjectSingleton;

public class Room extends JPanel implements IGUIFrame{
	
	Player player;
	
	
	
	@Override
	public JPanel loadGUI() {
		
		return this;
	}

	@Override
	public JPanel updateGUI() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(WorldObject wo : WorldObjectSingleton.getInstance().getWorldObjects()){
			g.drawImage(wo.getImage(), wo.getPosX(), wo.getPosY(), this);
		}
	}
	
}
