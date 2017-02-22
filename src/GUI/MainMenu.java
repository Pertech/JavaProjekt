package GUI;

import javax.swing.JPanel;

import GUI.Interface.IGUIFrame;

public class MainMenu implements IGUIFrame{
	
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
