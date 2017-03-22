package GUI.Test;

import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;

import Entity.Player;
import GUI.FrameManager;
import GUI.LevelFactory;
import GUI.Room;
import GUI.Interface.IGUIFrame;
import WorldObject.WorldObjectSingleton;

public class Test {
	private static boolean running = true;
	public static void main(String[] args) {
		/*JFrame frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1006, 585);
		frame.setResizable(false);
		IGUIFrame levelTest = new Room(2);
		levelTest.loadGUI();
		frame.setContentPane((Container) levelTest);
		frame.setVisible(true);
		frame.addKeyListener(((Room) levelTest).getPlayer().getPlayerMovement());
		
		while(running){
			levelTest.updateGUI();
		}
		
		System.exit(0);*/
		
		FrameManager fm = new FrameManager("Game");
	}
}
