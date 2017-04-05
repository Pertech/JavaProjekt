package Music;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

/**
 * 
 * Für das Abspielen von einzelnen Sounds zuständig
 * @version 1.0
 * @author Micha Meystre
 *
 */
public class SoundEffectPlayer {
	/**
	 * Lässt einen Sound einmalig abspielen
	 * @param fileName Der Name der Datei
	 */
	public void playSoundEffect(String fileName){
		File soundFile = new File(fileName);
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(2);
			clip.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
