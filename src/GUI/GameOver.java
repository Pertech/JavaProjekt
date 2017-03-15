package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Interface.IGUIFrame;

public class GameOver implements IGUIFrame, ActionListener{
	
	JPanel panel;
	JLabel gameOver, background;
	JButton mainMenu;
	
	public GameOver(){
		loadGUI();
	}
	
	@Override
	public JPanel loadGUI() {
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1006, 585);
		
		gameOver = new JLabel("GameOver");
		gameOver.setBounds(280, 100, 500, 100);
		gameOver.setFont(new Font("Calibri", Font.BOLD, 100));
		gameOver.setForeground(Color.WHITE);
		panel.add(gameOver);
		
		mainMenu = new JButton();
		mainMenu.setBounds(275, 300, 450, 60);
		ImageIcon image_start = new ImageIcon("res/mainMenu_button.png");
		mainMenu.setIcon(image_start);
		mainMenu.addActionListener(this);
		panel.add(mainMenu);
		
		ImageIcon image_bg = new ImageIcon("res/background.jpg");
	    background = new JLabel("", image_bg, JLabel.CENTER);
	    background.setBounds(0, 0, panel.getSize().width, panel.getSize().height);
	    panel.add(background);
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainMenu){
			FrameManager.mainMenu();
		}	
	}

	@Override
	public JPanel updateGUI() {
		return panel;
	}

}
