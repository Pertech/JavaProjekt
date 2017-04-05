package GUI;

import GUI.Interface.ILevel;

/**
 * 
 * @author Micha Meystre
 * @version 1.0
 * 
 *
 */
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
