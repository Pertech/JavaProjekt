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

public class CollisionDetection {

	private static CollisionDetection instance;
	
	private Player p;
	
	public static synchronized CollisionDetection getInstance() {
	
		if (instance == null) {
		
			instance = new CollisionDetection();
		
		}
		
		return instance;
	
	}
	
	public Player getPlayer() {
		return p;
	}

	public void setPlayer(Player p) {
		this.p = p;
	}

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
