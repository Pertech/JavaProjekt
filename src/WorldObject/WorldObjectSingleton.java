package WorldObject;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Entity;

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

	public List<WorldObject> getWorldObjects() {
		return worldObjects;
	}
	
	public void addWorldObject(WorldObject wo){
		worldObjects.add(wo);
		//a
	}

	public void removeWorldObject(WorldObject wo){
		worldObjects.remove(wo);
	}
	
	public void clearWorldObjects(){
		worldObjects.clear();
	}

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
