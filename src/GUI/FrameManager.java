package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.plaf.SliderUI;

import Entity.Enemy;
import GUI.Interface.IGUIFrame;
import Music.MusicPlayer;

public class FrameManager {
	
	private static JFrame frame;
	private static Room actualRoom = null;
	private static IGUIFrame actualFrame = null;
	private static boolean running = true;
	private static int roomNumber = 0;
	
	public FrameManager(String title){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MusicPlayer musicPlayer = new MusicPlayer(new String[]{"res/Itty_Bitty_8_Bit.wav"});
				frame = new JFrame();
				frame.setTitle(title);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setBounds(0, 0, 1006, 585);

				actualFrame = new MainMenu();
				//actualFrame.loadGUI();
				frame.setContentPane((Container) actualFrame);
				frame.setVisible(true);

				
				Timer t = new Timer(10, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						actualFrame.updateGUI();
						
					}
				});
				t.start();
			}
		});
		
	}
	
	public static void nextRoom(){
		roomNumber++;
		actualFrame = new Room(3, roomNumber);
		actualRoom = (Room) actualFrame;
		actualFrame.loadGUI();
		frame.setContentPane((Container) actualFrame);
		//frame.addKeyListener(((Room) actualFrame).getPlayer().getPlayerMovement());
		frame.setVisible(true);
	}

	public static void startFight(Enemy e){
		actualFrame = new Fight(e, 16, 10);
		//actualFrame.loadGUI();
		frame.setContentPane((Container) actualFrame);
		frame.setVisible(true);
	}

	public static void backToRoom(Enemy e){
		actualRoom.removeEnemy(e);
		actualFrame = actualRoom;
		actualFrame.loadGUI();
		frame.setContentPane((Container) actualFrame);
		frame.setVisible(true);
	}
	
	public static void mainMenu(){
		actualFrame = new MainMenu();
		//actualFrame.loadGUI();
		frame.setContentPane((Container) actualFrame);
		frame.setVisible(true);
	}
	
	public static void gameOver(){
		//frame.removeKeyListener(((Room) actualRoom).getPlayer().getPlayerMovement());
		actualFrame = new GameOver();
		//actualFrame.loadGUI();
		frame.setContentPane((Container) actualFrame);
		frame.setVisible(true);
	}

	public static IGUIFrame getActualFrame() {
		return actualFrame;
	}
	
}
