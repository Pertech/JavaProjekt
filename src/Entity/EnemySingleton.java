package Entity;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Entity;

public class EnemySingleton {


	private static EnemySingleton instance;
	
	private List<Enemy> worldObjects = new ArrayList<Enemy>();
	
	private EnemySingleton() {} 
	
	public static synchronized EnemySingleton getInstance() {
	
		if (instance == null) {
		
			instance = new EnemySingleton();
		
		}
		
		return instance;
	
	}

	public List<Enemy> getEnemies() {
		return worldObjects;
	}
	
	public void addEnemy(Enemy e){
		worldObjects.add(e);
	}

	public void removeEnemy(Enemy e){
		worldObjects.remove(e);
	}
	
	public void clearWorldObjects(){
		worldObjects.clear();
	}

}
