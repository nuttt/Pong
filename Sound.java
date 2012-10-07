import java.io.File;  
import java.io.IOException;

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Taken from http://www.anyexample.com/programming/java/java_play_wav_sound_file.xml
 
public class Sound extends Thread { 
 
	private static File bgFile = new File("sounds/SoundBg.wav");
	private static File hitYFile = new File("sounds/hitY.wav");
	private static File hitPaddleFile = new File("sounds/hitPaddle.wav");
	private static File winFile = new File("sounds/clap.wav");
	private static File winLongFile = new File("sounds/clap.wav");
	//private static File itemFile = new File("sounds/itemPop.wav");
	private static File[] itemFile = {
		new File("sounds/itemRandom.wav"),
		new File("sounds/itemSplit.wav"),
		new File("sounds/itemDash.wav"),
		new File("sounds/itemBetray.wav"),
		new File("sounds/itemRandom.wav"),
		new File("sounds/itemFast.wav"),
		new File("sounds/itemLong.wav"),
		new File("sounds/itemShort.wav"),
		new File("sounds/itemReverse.wav"),
		new File("sounds/itemMagnet.wav"),
		new File("sounds/itemShock.wav"),
		new File("sounds/itemPop.wav")
		};
	
	
	public static void playSoundBg(){
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream soundFile = AudioSystem.getAudioInputStream(bgFile);
			clip.open(soundFile);
			clip.loop(-1);
		} catch (LineUnavailableException | UnsupportedAudioFileException
				| IOException e) {
			e.printStackTrace();
		}
	}
	public static void playHitY(){
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream soundFile = AudioSystem.getAudioInputStream(hitYFile);
			clip.open(soundFile);
			clip.loop(0);
		} catch (LineUnavailableException | UnsupportedAudioFileException
				| IOException e) {
			e.printStackTrace();
		}
	}
	public static void playHitPaddle(){
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream soundFile = AudioSystem.getAudioInputStream(hitPaddleFile);
			clip.open(soundFile);
			clip.loop(0);
		} catch (LineUnavailableException | UnsupportedAudioFileException
				| IOException e) {
			e.printStackTrace();
		}
	}
	public static void playWin(){
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream soundFile = AudioSystem.getAudioInputStream(winFile);
			clip.open(soundFile);
			clip.loop(0);
		} catch (LineUnavailableException | UnsupportedAudioFileException
				| IOException e) {
			e.printStackTrace();
		}
	}
	public static void playLongFull(){
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream soundFile = AudioSystem.getAudioInputStream(winLongFile);
			clip.open(soundFile);
			clip.loop(0);
		} catch (LineUnavailableException | UnsupportedAudioFileException
				| IOException e) {
			e.printStackTrace();
		}
	}
	public static void playItem(int i){
		try {			
			Clip clip = AudioSystem.getClip();
			AudioInputStream soundFile = AudioSystem.getAudioInputStream(itemFile[i]);
			clip.open(soundFile);
			clip.loop(0);
		} catch (LineUnavailableException | UnsupportedAudioFileException
				| IOException e) {
			e.printStackTrace();
		}
	}
} 
 