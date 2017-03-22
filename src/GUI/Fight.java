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
import javax.swing.SwingConstants;

import Entity.Enemy;
import GUI.Interface.IGUIFrame;

public class Fight extends JFrame implements IGUIFrame, ActionListener{
	
	JPanel panel;
	JLabel countClicks, timeLeft, background;
	JButton button_click;
	
	private int clicks, seconds;
	private String str_clicks;
	private Enemy enemy;

	public Fight(Enemy e){
		loadGUI();
		this.enemy = e;
	}

	@Override
	public JPanel loadGUI() {
		FrameManager.backToRoom(enemy);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1000, 550);
		

		
		button_click = new JButton();
		button_click.setBounds(0, 0, 990, 548);
//		ImageIcon image_start = new ImageIcon("res/background_fight.");
//		button_click.setIcon(image_start);
		button_click.setOpaque(false);
		button_click.setContentAreaFilled(false);
		button_click.setBorderPainted(true);
		button_click.addActionListener(this);
		panel.add(button_click);
		
		countClicks = new JLabel("");
		str_clicks = Integer.toString(clicks);
		countClicks.setText(str_clicks);
		countClicks.setBounds(0, 260, 1000, 100);
		countClicks.setFont(new Font("Calibri", Font.BOLD, 120));
		countClicks.setHorizontalAlignment(SwingConstants.CENTER);
		countClicks.setForeground(Color.RED);
		panel.add(countClicks);
		
		
		ImageIcon image_bg = new ImageIcon("res/background_fight.png");
	    background = new JLabel("", image_bg, JLabel.CENTER);
	    background.setBounds(0, 0, panel.getSize().width, panel.getSize().height);
	    panel.add(background);
		
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button_click){
			clicks++;
			str_clicks = Integer.toString(clicks);
			countClicks.setText(str_clicks);
			panel.repaint();
		}			
	}

	@Override
	public JPanel updateGUI() {
		// TODO Auto-generated method stub
		return null;
	}

}
