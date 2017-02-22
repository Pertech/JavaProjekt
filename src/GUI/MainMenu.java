package GUI;

import javax.swing.JPanel;

public class MainMenu implements GUIFrame{
	
	JPanel panel;
	
	public MainMenu(){
		
	}
	
	public void startGame(){
		
	}
	
	public void exit(){
		
	}

	@Override
	public JPanel loadGUI() {
		panel = new JPanel();
		return panel;
	}

	@Override
	public JPanel updateGUI() {
		return panel;
	}
}
