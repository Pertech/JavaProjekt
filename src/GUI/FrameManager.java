package GUI;

import javax.swing.JFrame;

import GUI.Interface.IGUIFrame;

public class FrameManager {
	
	private static JFrame frame = new JFrame();
	private static IGUIFrame menu = new MainMenu();
	private static IGUIFrame gameOver = new GameOver();
	private static IGUIFrame room = new Room();
	
	public FrameManager(String title){
		frame.setTitle(title);
		
		frame.setBounds(0, 0, 1006, 585);

		MainMenu menu = new MainMenu();
		frame.setContentPane(menu.loadGUI());

		frame.setVisible(true);
	}
	
	public static void nextRoom(){
		frame.setContentPane(room.loadGUI());
		frame.setVisible(true);
	}

	public static void mainMenu(){
		frame.setContentPane(menu.loadGUI());
		frame.setVisible(true);
	}
	
	public static void gameOver(){
		frame.setContentPane(gameOver.loadGUI());
		frame.setVisible(true);
	}
	
}
