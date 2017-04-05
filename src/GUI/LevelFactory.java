package GUI;

import GUI.Interface.ILevel;

/**
 * 
 * F�r das Laden der Level aus dem Speicher zust�ndig.
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

	
	/**
	 * Gibt die Klasse LevelArrays als ILevel zur�ck.
	 * @return ILevel
	 */
	public ILevel loadLevel() {
		return new LevelArrays();
	}

}
