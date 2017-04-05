package Entity;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Entity;

public class EnemySingleton {


	private static EnemySingleton instance;
	
	private List<Enemy> enemies = new ArrayList<Enemy>();
	
	private EnemySingleton() {} 
	
	public static synchronized EnemySingleton getInstance() {
	
		if (instance == null) {
		
			instance = new EnemySingleton();
		
		}
		
		return instance;
	
	}

	/**
	 * Gibt eine Liste aller Gegner zurück
	 * @return List<Enemy> - Liste aller Gegner
	 */
	public List<Enemy> getEnemies() {
		return enemies;
	}
	
	/**
	 * Fügt einen neuen Gegner zur Liste hinzu.
	 * @param e - Neuer Gegner
	 */
	public void addEnemy(Enemy e){
		enemies.add(e);
	}

	/**
	 * Löscht einen Gegner von der Liste
	 * @param e
	 */
	public void removeEnemy(Enemy e){
		enemies.remove(e);
	}
	
	
	/**
	 * Löscht alle Gegner von der Liste
	 */
	public void clearEnemies(){
		enemies.clear();
	}

}
