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
/**
 * 
 * @author Loic Jermann
 * @version 1.0
 * Erstellt das GUI für den GameOver-Bildschirm. Hat keine spezielle Logik implementiert, nur 1 Button für zum MainMenu gelangen
 *
 */
public class GameOver extends JPanel implements IGUIFrame, ActionListener{
	
	JLabel gameOver, background;
	JButton mainMenu;
	
	public GameOver(){
		loadGUI();
	}
	
	@Override
	public void loadGUI() {
		
		
		setLayout(null);
		setSize(1006, 585);
		
		gameOver = new JLabel("GameOver");
		gameOver.setBounds(280, 100, 500, 100);
		gameOver.setFont(new Font("Calibri", Font.BOLD, 100));
		gameOver.setForeground(Color.WHITE);
		add(gameOver);
		
		mainMenu = new JButton();
		mainMenu.setBounds(275, 300, 450, 60);
		ImageIcon image_start = new ImageIcon("res/mainMenu_button.png");
		mainMenu.setIcon(image_start);
		mainMenu.addActionListener(this);
		add(mainMenu);
		
		ImageIcon image_bg = new ImageIcon("res/background.jpg");
	    background = new JLabel("", image_bg, JLabel.CENTER);
	    background.setBounds(0, 0, getSize().width, getSize().height);
	    add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainMenu){
			FrameManager.mainMenu();
		}	
	}

	@Override
	public void updateGUI() {
		
	}

}
