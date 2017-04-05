package WorldObject;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Entity;

/**
 * Beinhaltet alle Worldobjects
 * @version 1.0
 * @author Micha Meystre
 *
 */
public class WorldObjectSingleton {


	private static WorldObjectSingleton instance;
	
	private List<WorldObject> worldObjects = new ArrayList<WorldObject>();
	
	private WorldObjectSingleton() {} 
	
	public static synchronized WorldObjectSingleton getInstance() {
	
		if (instance == null) {
		
			instance = new WorldObjectSingleton();
		
		}
		
		return instance;
	
	}

	/**
	 * Gibt eine Liste aller WorldObjects zurück.
	 * @return
	 */
	public List<WorldObject> getWorldObjects() {
		return worldObjects;
	}
	
	/**
	 * Fügt ein WorldObject der Liste hinzu.
	 * @param wo
	 */
	public void addWorldObject(WorldObject wo){
		worldObjects.add(wo);
	}

	/**
	 * Entfernt ein WorldObject aus der Liste.
	 * @param wo
	 */
	public void removeWorldObject(WorldObject wo){
		worldObjects.remove(wo);
	}
	
	/**
	 * Löscht alle Objekte aus der Liste
	 */
	public void clearWorldObjects(){
		worldObjects.clear();
	}

	/**
	 * Fügt alle Objekte aus einem 2d Array der Liate hinzu.
	 * @param levelArray
	 * @throws IOException
	 */
	public void createWorldObjectFromArray(int[][] levelArray) throws IOException{
		for (int x = 0; x < levelArray.length; x++) {
			for (int y = 0; y < levelArray[x].length; y++) {
				switch (levelArray[x][y]) {
				case 0:
					addWorldObject(new Ground(y * 50, x * 50));
					break;
					
				case 1:
					addWorldObject(new Wall(y * 50, x * 50));
					break;
					
				case 2:
					addWorldObject(new Door(y * 50, x * 50));
					break;
					
				case 3:
					addWorldObject(new LastRoomDoor(y * 50, x * 50));
					break;
					
				case 4:
					addWorldObject(new NextLevel(y * 50, x * 50));
					break;
					
				default:
					break;
				}
			}
		}
	}

}
