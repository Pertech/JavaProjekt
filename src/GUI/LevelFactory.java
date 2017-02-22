package GUI;

import GUI.Interface.ILevel;

public class LevelFactory {


	private static LevelFactory instance;
	
	private LevelFactory() {} 
	
	public static synchronized LevelFactory getInstance() {
	
		if (instance == null) {
		
			instance = new LevelFactory();
		
		}
		
		return instance;
	
	}

	public ILevel loadLevel() {
		return new LevelArrays();
	}

}
