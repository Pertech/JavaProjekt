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

import java.util.Timer;
import java.util.TimerTask;

import Entity.Enemy;
import GUI.Interface.IGUIFrame;

public class Fight extends JPanel implements IGUIFrame, ActionListener{
	
	static Timer timer;
	

	JLabel countClicks, timeLeft, clicksToBeat, background;
	JButton button_click;
	
	private int clicks;
	private static int seconds, i_clicksToBeat;
	private String str_clicks, str_seconds, str_clicksToBeat;
	private Enemy enemy;

	public Fight(Enemy e, int secs, int clicks){
		
	    seconds = secs;
	    i_clicksToBeat = clicks;
		loadGUI();
		this.enemy = e;
		
		int delay = 1000;
	    int period = 1000;
	    timer = new Timer();
	    
	    timer.scheduleAtFixedRate(new TimerTask() {

	        public void run() {
				str_seconds = Integer.toString(setInterval());
				timeLeft.setText(str_seconds);
	        }
	    }, delay, period);
	    
	    

		
	}
	
	private static final int setInterval() {
		//hallo
	    if (seconds == 1){
	        timer.cancel();
	    	FrameManager.gameOver();
	    }
	    return --seconds;
	}

	@Override
	public void loadGUI() {
//		FrameManager.backToRoom(enemy);
		
		setLayout(null);
		setSize(1000, 550);
		

		
		button_click = new JButton();
		button_click.setBounds(0, 0, 990, 548);
//		ImageIcon image_start = new ImageIcon("res/background_fight.");
//		button_click.setIcon(image_start);
		button_click.setOpaque(false);
		button_click.setContentAreaFilled(false);
		button_click.setBorderPainted(true);
		button_click.addActionListener(this);
		add(button_click);
		
		countClicks = new JLabel("");
		str_clicks = Integer.toString(clicks);
		countClicks.setText(str_clicks);
		countClicks.setBounds(0, 260, 1000, 100);
		countClicks.setFont(new Font("Calibri", Font.BOLD, 120));
		countClicks.setHorizontalAlignment(SwingConstants.CENTER);
		countClicks.setForeground(Color.RED);
		add(countClicks);
		
		timeLeft = new JLabel(str_seconds);
		timeLeft.setBounds(900, 490, 200, 50);
		timeLeft.setFont(new Font("Calibri", Font.BOLD, 50));
		timeLeft.setForeground(Color.BLACK);
		add(timeLeft);
		
		str_clicksToBeat = Integer.toString(i_clicksToBeat);
		clicksToBeat = new JLabel(str_clicksToBeat);
		clicksToBeat.setBounds(270, 490, 200, 50);
		clicksToBeat.setFont(new Font("Calibri", Font.BOLD, 50));
		clicksToBeat.setForeground(Color.BLACK);
		add(clicksToBeat);
		
		ImageIcon image_bg = new ImageIcon("res/background_fight.png");
	    background = new JLabel("", image_bg, JLabel.CENTER);
	    background.setBounds(0, 0, getSize().width, getSize().height);
	    add(background);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button_click){
			
		    if (this.clicks >= i_clicksToBeat){
		        timer.cancel();
		    	FrameManager.backToRoom(this.enemy);
		    }
			clicks++;
			str_clicks = Integer.toString(clicks);
			countClicks.setText(str_clicks);
			repaint();
		}			
	}

	@Override
	public void updateGUI() {
		// TODO Auto-generated method stub
	}

}
