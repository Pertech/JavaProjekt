package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import Collision.CollisionDetection;
import Entity.Enemy;
import Entity.EnemySingleton;
import Entity.NewPlayerMovement;
import Entity.Player;
import GUI.Interface.IGUIFrame;
import WorldObject.Door;
import WorldObject.WorldObject;
import WorldObject.WorldObjectSingleton;
/**
 * 
 * @author Micha Meystre
 * @version 1.0
 * Erstellt das GUI f�r den Room (also Level). Nimmt den aufbau f�r das Level als 2-Dimensionales Array entgegen und baut es so auf. Es erstellt auch die Enemys
 * 
 */
public class Room extends JPanel implements IGUIFrame{
	
	private Player player;
	private int enemyCount;
	private Enemy enemyToRemove;
	private int roomNumber;
	private JLabel enemiesNumberLabel;
	
	public Room(int enemyCount, int roomNumber){
		this.enemyCount = enemyCount;
		this.roomNumber = roomNumber;
		this.setLayout(null);
	}
	
	private void setKeyBindings() {
      ActionMap actionMap = getActionMap();
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition );

      String vkW = "VK_W";
      String vkS = "VK_S";
      String vkA = "VK_A";
      String vkD = "VK_D";
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), vkW);
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), vkS);
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), vkA);
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), vkD);

      actionMap.put(vkW, new NewPlayerMovement(vkW, player));
      actionMap.put(vkS, new NewPlayerMovement(vkS, player));
      actionMap.put(vkA, new NewPlayerMovement(vkA, player));
      actionMap.put(vkD, new NewPlayerMovement(vkD, player));

   }
	
	public Player getPlayer() {
		return player;
	}
	
	@Override
	public void loadGUI() {
		setFocusable(true);
		
		JLabel roomNumberLabel = new JLabel("Room: " + String.valueOf(roomNumber));
		roomNumberLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		roomNumberLabel.setForeground(Color.WHITE);
		roomNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roomNumberLabel.setBounds(0,0,1000,50);
		this.add(roomNumberLabel);

		enemiesNumberLabel = new JLabel("Enemies left: " + String.valueOf(enemyCount));
		enemiesNumberLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		enemiesNumberLabel.setForeground(Color.WHITE);
		enemiesNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enemiesNumberLabel.setBounds(0,500,1000,50);
		this.add(enemiesNumberLabel);
		
		try {
			WorldObjectSingleton.getInstance().createWorldObjectFromArray(LevelFactory.getInstance().loadLevel().getLevel(roomNumber));
			player = new Player(50, 250, 40, 40);
			setKeyBindings();
			CollisionDetection.getInstance().setPlayer(player);
			for(int i = 0; i < enemyCount; i++){
				EnemySingleton.getInstance().addEnemy(CollisionDetection.getInstance().randomSpawnPosition());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateGUI() {
		// TODO Auto-generated method stub
		Random rand = new Random(); 
		for(Enemy e : EnemySingleton.getInstance().getEnemies()){
			if(rand.nextInt(20) == 0){
				e.getMovement().changeDirection();
			}
			e.getMovement().move();
		}
		if(enemyToRemove != null){
			EnemySingleton.getInstance().removeEnemy(enemyToRemove);
			enemyCount = EnemySingleton.getInstance().getEnemies().size();
			if(enemyCount == 0){
				removeDoor();
			}
			enemyToRemove = null;
			enemiesNumberLabel.setText("Enemies left: " + String.valueOf(enemyCount));
		}
		
		repaint();
	}

	private void removeDoor(){
		WorldObject door = null;
		for(WorldObject wo : WorldObjectSingleton.getInstance().getWorldObjects()){
			if(wo instanceof Door){
				door = wo;
			}
		}
		if(door != null){
			WorldObjectSingleton.getInstance().removeWorldObject(door);
		}
		
	}
	
	public void removeEnemy(Enemy e){
		enemyToRemove = e;
		e.setReadyForFight(false);
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(WorldObject wo : WorldObjectSingleton.getInstance().getWorldObjects()){
			g.drawImage(wo.getImage(), wo.getPosX(), wo.getPosY(), this);
		}
		if(player != null){
			g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), this);
		}
		for(Enemy e : EnemySingleton.getInstance().getEnemies()){
			g.drawImage(e.getImage(), e.getPosX(), e.getPosY(), this);
		}
	}
	
}
