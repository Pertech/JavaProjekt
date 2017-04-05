package Collision;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import Entity.Enemy;
import Entity.EnemySingleton;
import Entity.Entity;
import Entity.Player;
import GUI.FrameManager;
import WorldObject.Ground;
import WorldObject.NextLevel;
import WorldObject.WorldObject;
import WorldObject.WorldObjectSingleton;

/**
 * 
 * @author Micha Meystre
 * @version 1.0
 * Macht die Colission-Detection. Das bedeudet er checkt, ob z.B. der Spieler eine Wand berührt und da nicht mehr weiterlaufen darf.
 *
 */
public class CollisionDetection {

	private static CollisionDetection instance;
	
	private Player p;
	
	public static synchronized CollisionDetection getInstance() {
	
		if (instance == null) {
		
			instance = new CollisionDetection();
		
		}
		
		return instance;
	
	}
	
	/**
	 * Gibt den Player zurück
	 * @return der aktuelle Player
	 */
	public Player getPlayer() {
		return p;
	}

	/**
	 * Methode zum einen neuen Player zu setzen
	 * @param p Der neue Player
	 */
	public void setPlayer(Player p) {
		this.p = p;
	}

	/**
	 * Checkt ob es eine Kollision gibt.
	 * @param e Das Entity, das sich bewegt
	 * @param x Bewegung auf der X-Achse
	 * @param y Bewegung auf der Y-Achse
	 */
	public void checkCollision(Entity e, int x, int y){
		e.setCanMove(true);
		boolean nextRoom = false;
		Rectangle entityRect = new Rectangle(e.getPosX() + x, e.getPosY() + y, e.getSizeX(), e.getSizeY());
		for (WorldObject wo : WorldObjectSingleton.getInstance().getWorldObjects()) {
			Rectangle woRect = new Rectangle(wo.getPosX(), wo.getPosY(), 50, 50);
			if (entityRect.intersects(woRect)) {
				if(wo instanceof NextLevel){
					nextRoom = true;
				} else {
					wo.onCollision(e);
				}
			}
		}
		
		if (nextRoom){
			FrameManager.nextRoom();
		}
		
		for (Enemy en : EnemySingleton.getInstance().getEnemies()) {
			if(e != en){
				Rectangle woRect = new Rectangle(en.getPosX(), en.getPosY(), en.getSizeX(), en.getSizeY());
				if (entityRect.intersects(woRect)) {
					en.onCollision(e);
				}
			}
		}
		
		if(!(e instanceof Player)){
			Rectangle playerRect = new Rectangle(p.getPosX(), p.getPosY(), p.getSizeX(), p.getSizeY());
			if (entityRect.intersects(playerRect)) {
				p.onCollision(e);
			}
		}
	}
	

	/**
	 * Erstellt einen neuen Enemy mit einem zufälligen Spawn-Punkt. Es wird auch geschaut, dass er nicht in einem anderen Enemy spawnt.
	 * @return Der neu erstellte Enemy
	 */
	public Enemy randomSpawnPosition(){
		boolean collision = true;
		Rectangle enemyRect = null;
		Random rand = new Random();
		while(collision){
			collision = false;
			enemyRect = new Rectangle(rand.nextInt(800) + 100, rand.nextInt(400) + 100, 40, 40);
			
			for (WorldObject wo : WorldObjectSingleton.getInstance().getWorldObjects()) {
				if(!(wo instanceof Ground)){
					Rectangle woRect = new Rectangle(wo.getPosX(), wo.getPosY(), 50, 50);
					if (enemyRect.intersects(woRect)) {
						collision = true;
					}
				}
			}
			
			for (Enemy en : EnemySingleton.getInstance().getEnemies()) {
				Rectangle woRect = new Rectangle(en.getPosX(), en.getPosY(), en.getSizeX(), en.getSizeY());
				if (enemyRect.intersects(woRect)) {
					collision = true;
				}
			}
			
			Rectangle playerRect = new Rectangle(p.getPosX(), p.getPosY(), p.getSizeX(), p.getSizeY());
			if (enemyRect.intersects(playerRect)) {
				collision = true;
			}
		}
		
		try {
			return new Enemy((int)enemyRect.getX(), (int)enemyRect.getY(), 40, 40);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
