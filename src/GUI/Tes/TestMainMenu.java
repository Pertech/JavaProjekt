package GUI.Tes;

import javax.swing.JFrame;

import GUI.MainMenu;
import GUI.Interface.IGUIFrame;

public class TestMainMenu {
	static JFrame frame;
	static IGUIFrame menu = new MainMenu();
	
	public static void main(String[] args) {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 550);
		frame.setContentPane(menu.loadGUI());
		frame.setVisible(true);
	}
	
	
}
