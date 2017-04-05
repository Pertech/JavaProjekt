package Music;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

/**
 * 
 * Für das Abspielen von Musik zuständig.
 *
 * @version 1.0
 * @author Micha Meystre
 *
 */
public class MusicPlayer {
	private int actualFileID;
	private ArrayList<String> musicFiles;
	
	/**
	 * Der Konstruktor der Klasse Musicplayer
	 * @param files Name der Musikdateien
	 */
	public MusicPlayer(String[] files){
		musicFiles = new ArrayList<String>();
		for(String file : files){
			musicFiles.add(file);
		}
		playSound(musicFiles.get(0));
	}
	
	/**
	 * Spielt die Musik (mit Playlist Funktion)
	 * @param fileName
	 */
	private void playSound(String fileName){
		File soundFile = new File(fileName);
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10);
			clip.start();
			long length = clip.getMicrosecondLength()/1000;
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	actualFileID++;
			            	if(actualFileID == musicFiles.size()){
			            		actualFileID = 0;
			            	}
			                playSound(musicFiles.get(actualFileID));
			            }
			        }, length
			        
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
