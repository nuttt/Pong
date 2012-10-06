import java.applet.AudioClip;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
/** <p>An object implementing {@link java.applet.AudioClip java.applet.AudioClip} with the data from hit1.wav hard-coded into it.</p>
 * <p>Created with the <a href="http://stephengware.com/projects/soundtoclass">SoundToClass tool</a>, by Stephen G. Ware.</p>
 * @author Stephen G. Ware */
public class hit1 implements AudioClip {
	private byte[] data;
	private AudioFormat format;
	private DataLine.Info lineInfo = null;
	private PlayThread playThread = null;
	private LoopThread loopThread = null;
	private static final long serialVersionUID = 1224;
	private static byte[] data0(){ return new byte[] {-128,-128,126,127,126,127,-128,127,-125,-127,-127,-128,125,124,123,124,123,125,126,127,-128,-127,-125,126,-127,127,124,124,124,-128,-127,-128,127,-125,126,125,124,124,124,126,-127,127,-126,126,126,-126,-128,127,-127,125,-128,116,123,-119,-117,-118,-123,-127,-128,125,-126,-128,115,118,125,123,116,127,118,121,-124,-125,-118,-123,127,121,-127,-118,125,-128,126,121,126,112,124,127,-123,-124,-126,-125,-126,-128,121,-122,-126,-127,-127,-128,125,122,119,122,122,123,123,-128,-126,-125,127,-115,-111,-125,-125,-126,-126,-125,112,114,118,104,99,103,124,-99,-93,-101,-121,102,79,67,85,127,-88,-68,-69,-90,-111,-116,-126,-128,111,86,93,113,123,-120,-111,-124,124,115,111,111,114,109,108,123,-127,-111,-106,-116,-126,109,104,122,-126,-107,-90,-93,-107,-121,121,115,109,121,-127,-128,-121,-124,126,111,96,101,118,-128,-106,-100,-114,127,125,114,118,111,121,-121,-115,-115,-124,115,102,92,111,-122,-115,-106,-108,123,118,122,117,-117,-109,-93,-93,-117,-119,117,94,83,91,89,115,-116,-111,-104,-108,123,112,115,104,108,116,121,-120,-85,-112,-122,125,94,96,119,126,-123,-128,-127,-95,-109,-112,-94,70,104,-68,-89,-100,-46,-125,94,-108,68,71,53,45,70,113,-91,-59,-54,-45,-90,103,106,107,119,98,65,67,59,80,-101,-62,-107,116,123,-109,-65,-75,127,-120,67,49,119,-122,127,-113,-121,-93,-57,-80,-49,-87,120,65,75,86,62,65,104,-108,79,114,-118,-113,-71,104,92,55,-104,122,124,-103,-105,-48,121,118,86,113,121,107,-121,-95,-68,-44,-43,-52,-45,-69,-100,121,76,-128,89,3,61,82,18,23,114,-123,-122,-47,-37,-48,-94,99,84,43,13,1,69,96,-76,-43,-50,-50,-68,123,70,46,68,126,-110,-117,-93,-50,-49,-43,-50,-53,-58,-79,75,47,42,26,27,49,100,-93,-83,-73,-62,-79,-102,-122,101,60,42,54,81,-112,-90,-65,-61,-67,-82,82,70,52,71,73,94,114,118,-113,126,-100,-93,-91,-86,-102,-111,114,87,84,122,-125,-125,-110,-107,-103,-112,-95,-113,116,112,121,102,97,111,109,101,-120,-106,-122,-117,-116,113,108,116,121,-124,107,89,117,-125,-118,-104,-111,-122,124,121,-122,-99,-119,-108,-109,-110,-121,124,89,107,-120,-92,-82,-106,-113,115,122,115,113,124,119,98,99,-123,-121,-120,-103,-109,115,88,98,110,117,126,-107,-108,-121,103,86,71,78,103,-122,-100,-102,-95,-93,-84,-86,-103,120,124,112,127,124,123,117,108,114,104,116,98,113,113,-123,-110,127,-128,116,112,126,124,-125,-109,-103,-118,-123,-113,-127,-123,112,101,113,117,125,-110,-114,-120,125,113,111,125,-117,-113,-112,-100,-115,-122,-119,-124,-114,126,109,106,103,98,108,100,100,119,-128,-123,-113,-128,123,117,122,114,121,116,-128,-118,-128,-120,-118,-118,-125,-112,-127,126,126,-120,-113,-115,-116,-112,-109,-110,-104,-113,-126,127,120,122,106,95,82,88,97,98,115,109,123,-119,127,126,124,116,122,-122,-112,-113,-108,-106,-99,-96,-117,-120,-123,125,114,113,125,126,127,-123,121,117,115,120,-125,-127,119,113,111,107,120,121,-111,-124,-126,-123,116,119,114,119,-122,-116,-121,-112,-114,-121,-114,-123,-124,-119,-128,-126,118,114,108,119,119,112,127,124,126,-128,-128,-118,-116,-119,127,-127,-128,126,125,-125,-120,-105,-109,-111,-116,-128,117,111,109,108,123,126,-121,-119,123,121,108,103,104,104,115,124,-123,-119,-117,-121,-127,-128,-127,-128,-120,-120,-117,-125,-115,124,120,111,112,117,121,122,121,-121,-126,-123,-123,123,116,114,126,-126,-116,-113,-114,-125,-128,126,119,116,119,-128,-122,-128,-120,-122,122,-127,127,126,-125,-122,-126,-121,-124,-128,124,120,112,119,122,-126,-121,-118,-118,-123,-127,117,117,120,119,124,127,125,124,123,116,118,119,109,116,124,125,127,-121,-127,-127,122,125,125,-125,-124,-127,-126,-126,-122,-120,-118,-124,-119,-123,-114,-119,-121,-124,123,117,116,116,112,118,119,126,-128,126,125,123,123,127,-126,-123,-126,-128,-127,-127,-124,-125,-123,-124,-127,-128,124,-128,-125,-127,127,-128,120,127,-128,-126,-121,-121,-124,-128,-127,117,122,119,123,124,-126,126,-127,-128,124,-126,122,125,124,126,119,126,-128,124,125,-127,126,120,121,121,127,-128,-127,-127,-127,-125,-124,-124,125,123,125,125,127,-123,-124,-125,-124,-126,127,-127,125,124,-126,126,-128,125,126,125,124,127,122,119,125,121,124,126,127,-128,-125,-123,-123,-125,-124,-125,-126,-124,-127,-128,127,126,124,124,125,123,125,120,122,122,122,-126,-124,-125,127,-127,-128,127,-127,-127,126,-126,-126,-127,-123,-128,-128,120,117,119,122,116,121,127,-128,-128,126,125,-128,126,-128,125,-128,124,125,127,-126,-125,-124,126,-126,-125,-125,-127,-125,-128,-127,-126,127,-128,-128,127,126,-127,119,121,120,118,122,125,-128,-127,-127,124,121,122,123,125,127,-123,-121,-120,-120,-122,-122,-121,-123,-125,-128,-127,127,-127,126,124,125,122,121}; }
	private static byte[] data1(){ return new byte[] {119,120,124,124,124,126,-127,126,127,126,124,123,125,-127,-125,-126,-128,-126,127,-127,-128,127,-127,126,124,-127,-126,-126,-127,-128,-128,125,125,123,127,-128,-128,126,127,-127,-128,-128,-128,-127,127,-127,-127,-127,-128,-127,-128,126,125,-127,-128,-128,127,126,123,123,122,127,-128,-128,-128,-127,-128,127,127,126,127,125,125,125,127,127,-127,-127,-124,-125,-128,-127,-127,-125,-128,-128,125,123,122,124,125,123,125,125,127,-128,-128,126,125,125,126,-128,-127,-128,-126,-127,127,-128,125,127,-128,127,127,125,126,-128,127,-127,-128,-128,125,127,-128,-128,125,126,-128,-127,-128,-128,-128,-128,127,-126,127,-127,-128,127,-128,-128,-128,127,126,-128,-128,126,126,126,126,-128,-128,127,127,125,126,127,127,-128,-128,-127,-128,-128,-128,125,124,126,125,126,126,126,-128,-128,-128,-128,-128,127,127,-128,-128,127,-128,-127,-128,127,126,126,126,-127,-128,-128,-128,-126,-128,-128,-128,-128,-127,127,-128,127}; }
	private static byte[] getData(){
		byte[] data = new byte[1224];
		System.arraycopy(data0(), 0, data, 0, 1024);
		System.arraycopy(data1(), 0, data, 1024, 200);
		return data;
	}
	/** Constructs a new AudioClip with the data from hit1.wav. */
	public hit1(){
		data = getData();
		format = new AudioFormat(AudioFormat.Encoding.PCM_UNSIGNED, (float)(8000.0), 8, 1, 1, (float)(8000.0), false);
		lineInfo = new DataLine.Info(SourceDataLine.class, format, AudioSystem.NOT_SPECIFIED);
		try{ AudioSystem.getLine(lineInfo); }
		catch(IllegalArgumentException ex){ lineInfo = null; }
		catch(LineUnavailableException e){}
	}
	/** A separate thread for playing hit1.wav. */
	private class PlayThread extends Thread {
		private byte[] data;
		private AudioFormat format;
		private DataLine.Info lineInfo;
		private SourceDataLine line = null;
		private boolean playing = true;
		public PlayThread(byte[] d, AudioFormat f, DataLine.Info i){ data = d; format = f; lineInfo = i; }
		public void run(){
			try{
				line = (SourceDataLine) AudioSystem.getLine(lineInfo);
				line.open(format, AudioSystem.NOT_SPECIFIED);
				line.start();
				int written = 0;
				int available;
				while(written < data.length && playing){
					available = Math.min(line.available(), data.length - written);
					line.write(data, written, available);
					written += available;
				}
				int frames = data.length / format.getFrameSize();
				while(line.getFramePosition() < frames && playing) Thread.sleep(0);
			}
			catch(InterruptedException ex){ playing = false; }
			catch(LineUnavailableException ex){}
			if(line != null){ line.stop(); line.flush(); line.close(); }
			playing = false;
		}
		public void interrupt(){ playing = false; }
		public boolean isPlaying(){ return playing; }
	}
	/** A separate thread for looping play of hit1.wav. */
	private class LoopThread extends Thread {
		private hit1 clip;
		private boolean looping = true;
		public LoopThread(hit1 c){ clip = c; }
		public void run(){
			while(looping){
				clip.play();
				while(clip.isPlaying() && looping){
					try{ Thread.sleep(0); }
					catch(InterruptedException ex){ looping = false; break; }
				}
			}
			if(!clip.isLooping()) clip.stop();
		}
		public void interrupt(){ looping = false; }
		public boolean isLooping(){ return looping; }
	}
	/** Plays hit1.wav from the beginning, even if it is already playing or looping. */
	public void play(){ if(lineInfo == null) return; doPlay(); }
	private synchronized void doPlay(){
		doStopPlay();
		playThread = new PlayThread(data, format, lineInfo);
		playThread.start();
	}
	/** Plays hit1.wav continuously until stopped. */
	public void loop(){ if(lineInfo == null) return; doLoop(); }
	private synchronized void doLoop(){
		doStopLoop();
		loopThread = new LoopThread(this);
		loopThread.start();
	}
	/** Stops play and looping of hit1.wav. */
	public void stop(){ if(lineInfo == null) return; doStop(); }
	private synchronized void doStop(){
		doStopPlay();
		doStopLoop();
	}
	private void doStopPlay(){
		if(playThread == null) return;
		if(playThread.isPlaying()) playThread.interrupt();
		playThread = null;
	}
	private void doStopLoop(){
		if(loopThread == null) return;
		if(loopThread.isLooping()) loopThread.interrupt();
		loopThread = null;
	}
	/** Tests if hit1.wav is currently playing or looping.
	 * @return <tt>true</tt> if playing or looping, <tt>false</tt> otherwise */
	public boolean isPlaying(){ if(lineInfo == null) return false; return doIsPlaying(); }
	private synchronized boolean doIsPlaying(){
		if(loopThread == null && playThread == null) return false;
		else if(loopThread == null) return playThread.isPlaying();
		else if(playThread == null) return loopThread.isLooping();
		else return loopThread.isLooping() && playThread.isPlaying();
	}
	/** Tests if hit1.wav is currently looping.
	 * @return <tt>true</tt> if looping, <tt>false</tt> otherwise */
	public boolean isLooping(){ if(lineInfo == null) return false; return doIsLooping(); }
	private synchronized boolean doIsLooping(){
		if(loopThread == null) return false;
		else return loopThread.isLooping();
	}
}