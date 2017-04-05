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
import Entity.EnemySingleton;
import GUI.Interface.IGUIFrame;
import Music.MusicPlayer;

/**
 * 
 * @author Micha Meystre/Loic Jermann
 * @version 1.0
 * Der Framemanager verwaltet alle GUIs. Mit ihm kann man von einem GUI zu einem anderen wechseln.
 *
 */
public class FrameManager {
	
	private static JFrame frame;
	private static Room actualRoom = null;
	private static IGUIFrame actualFrame = null;
	private static boolean running = true;
	private static int roomNumber = 0;
	
	/**
	 * Konstruktor von Framemanager: Der wird aufgerufen, wenn das Spiel zum ersten mal gestartet wird. Er erstellt ein Fenster und macht das Panel
	 * vom MainMenu hinein. Er startet auch den MusicPlayer
	 * @param title Tittel des Programmes (wird oben in der Leiste angezeigt)
	 */
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
	
	/**
	 * Wechselt zu dem nächsten Raum
	 */
	public static void nextRoom(){
		roomNumber++;
		actualFrame = new Room(3, roomNumber);
		actualRoom = (Room) actualFrame;
		actualFrame.loadGUI();
		frame.setContentPane((Container) actualFrame);
		//frame.addKeyListener(((Room) actualFrame).getPlayer().getPlayerMovement());
		frame.setVisible(true);
	}

	/**
	 * Startet einen Fight mit einem Enemy
	 * @param e Den Gegner gegen den der Spieler kämpfen soll
	 */
	public static void startFight(Enemy e){
		actualFrame = new Fight(e, 10, roomNumber * 10);
		//actualFrame.loadGUI();
		frame.setContentPane((Container) actualFrame);
		frame.setVisible(true);
	}

	/**
	 * Nach einem Kampf, falls dieser gewonnen wurde wird diese Methode aufgerufen, zum wieder ins Spiel zurück zu kommen.
	 * @param e Den Gegner, den man im Kampf besiegt hat
	 */
	public static void backToRoom(Enemy e){
		actualRoom.removeEnemy(e);
		actualFrame = actualRoom;
		frame.setContentPane((Container) actualFrame);
		frame.setVisible(true);
	}
	
	/**
	 * Startet das MainMenu
	 */
	public static void mainMenu(){
		actualFrame = new MainMenu();
		//actualFrame.loadGUI();
		frame.setContentPane((Container) actualFrame);
		frame.setVisible(true);
		EnemySingleton.getInstance().clearEnemies();
	}
	
	/**
	 * Startet den GameOver-Bildschirm
	 */
	public static void gameOver(){
		actualFrame = new GameOver();
		//actualFrame.loadGUI();
		frame.setContentPane((Container) actualFrame);
		frame.setVisible(true);
	}

	/**
	 * Gibt den aktuellen Frame zurück
	 * @return Das aktuelle Frame
	 */
	public static IGUIFrame getActualFrame() {
		return actualFrame;
	}
	
}
