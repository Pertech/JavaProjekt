package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GUI.Interface.IGUIFrame;

public class MainMenu implements IGUIFrame, ActionListener{
	

	JPanel panel;
	JButton start, exit;
	JLabel title, background;
	
	public MainMenu(){
		loadGUI();
	}
	
	public void startGame(){
		FrameManager.nextRoom();
	}
	
	public void exit(){
		System.exit(0);
	}

	@Override
	public JPanel loadGUI() {

		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1006, 585);
		

		start = new JButton();
		start.setBounds(275, 200, 450, 60);
		ImageIcon image_start = new ImageIcon("res/start_button.png");
		start.setIcon(image_start);
		start.addActionListener(this);
		panel.add(start);
		
		exit = new JButton();
		exit.setBounds(275, 290, 450, 60);
		ImageIcon image_exit = new ImageIcon("res/exit_button.png");
		exit.setIcon(image_exit);
		exit.addActionListener(this);
		panel.add(exit);
		
		
		title = new JLabel("JavaGame");
		title.setBounds(372, 40, 255, 50);
		title.setFont(new Font("Calibri", Font.BOLD, 60));
		title.setForeground(Color.WHITE);
		panel.add(title);
		
		
		ImageIcon image_bg = new ImageIcon("res/background.jpg");
	    background = new JLabel("", image_bg, JLabel.CENTER);
	    background.setBounds(0, 0, panel.getSize().width, panel.getSize().height);
	    panel.add(background);
		
		return panel;
	}

	@Override
	public JPanel updateGUI() {
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start){
			this.startGame();
		}
		else if(e.getSource() == exit){
			this.exit();
		}		
	}
}
