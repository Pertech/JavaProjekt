package GUI.Test;

import java.io.IOException;

import javax.swing.JFrame;

import GUI.LevelFactory;
import GUI.Room;
import WorldObject.WorldObjectSingleton;

public class Test {
	public static void main(String[] args) {
		try {
			WorldObjectSingleton.getInstance().createWorldObjectFromArray(LevelFactory.getInstance().loadLevel().getLevel(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame frame = new JFrame("Game");
		frame.setBounds(0, 0, 1000, 550);
		frame.setContentPane(new Room());
		frame.setVisible(true);
	}
}
