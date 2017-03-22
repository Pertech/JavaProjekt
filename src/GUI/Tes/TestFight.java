package GUI.Tes;

import javax.swing.JFrame;

import GUI.Fight;
import GUI.GameOver;
import GUI.Interface.IGUIFrame;

public class TestFight {
	static JFrame frame;
	static IGUIFrame fight = new Fight();
	
	public static void main(String[] args) {
		frame = new JFrame();
		frame.setBounds(0, 0, 1006, 585);
		frame.setContentPane(fight.loadGUI());
		frame.setVisible(true);
	}
}
