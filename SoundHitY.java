import java.applet.AudioClip;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
/** <p>An object implementing {@link java.applet.AudioClip java.applet.AudioClip} with the data from HitY.WAV hard-coded into it.</p>
 * <p>Created with the <a href="http://stephengware.com/projects/soundtoclass">SoundToClass tool</a>, by Stephen G. Ware.</p>
 * @author Stephen G. Ware */
public class SoundHitY implements AudioClip {
	private byte[] data;
	private AudioFormat format;
	private DataLine.Info lineInfo = null;
	private PlayThread playThread = null;
	private LoopThread loopThread = null;
	private static final long serialVersionUID = 8192;
	private static byte[] data0(){ return new byte[] {21,-1,40,-1,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,21,-1,-1,-2,-1,-2,21,-1,-1,-2,21,-1,-1,-2,-1,-2,-1,-2,-1,-2,21,-1,-1,-2,21,-1,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,21,-1,-1,-2,21,-1,-1,-2,-1,-2,-1,-2,21,-1,21,-1,-1,-2,-1,-2,-1,-2,-1,-2,21,-1,-1,-2,-1,-2,21,-1,-1,-2,21,-1,-1,-2,21,-1,-1,-2,-1,-2,-1,-2,40,-1,-1,-2,-1,-2,21,-1,-1,-2,-1,-2,21,-1,-1,-2,-1,-2,21,-1,-1,-2,21,-1,21,-1,-1,-2,-1,-2,-1,-2,-1,-2,21,-1,-1,-2,21,-1,-1,-2,-1,-2,-1,-2,21,-1,-1,-2,21,-1,21,-1,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,21,-1,-1,-2,-1,-2,21,-1,-1,-2,21,-1,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,21,-1,21,-1,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-24,-2,-48,-3,-97,-5,125,-14,56,-25,-36,-33,-57,-39,-57,-39,-57,-39,-57,-39,-57,-39,-57,-39,81,-42,-117,-46,110,-50,-15,-55,12,-59,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,12,-59,-74,-65,-74,-65,-74,-65,-74,-65,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-74,-65,-74,-65,-28,-71,-28,-71,-74,-65,-74,-65,-74,-65,-28,-71,-28,-71,-74,-65,-117,-46,-117,-46,12,-59,-74,-65,-74,-65,-15,-55,81,-42,81,-42,-15,-55,-74,-65,-28,-71,-74,-65,81,-42,56,-25,-28,-20,-36,-33,12,-59,-96,-84,-40,-100,20,-91,-117,-77,-15,-55,41,-21,100,12,13,35,-110,49,15,54,-110,49,-81,41,13,35,121,29,36,32,13,35,57,38,117,45,117,45,117,45,117,45,117,45,-81,41,-81,41,117,45,-110,49,-12,58,74,64,74,64,74,64,74,64,74,64,74,64,-12,58,-12,58,74,64,74,64,28,70,117,76,117,76,117,76,96,83,96,83,96,83,96,83,96,83,96,83,96,83,96,83,96,83,96,83,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,40,99,40,99,40,99,40,99,40,99,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,96,83,96,83,96,83,96,83,96,83,96,83,96,83,96,83,96,83,117,76,117,76,117,76,117,76,28,70,28,70,28,70,28,70,28,70,28,70,28,70,74,64,74,64,74,64,-12,58,-12,58,15,54,-110,49,-110,49,-110,49,117,45,117,45,-81,41,-81,41,57,38,13,35,-112,33,121,29,-56,24,-41,20,-122,17,-125,13,-115,9,-62,8,8,8,53,5,2,2,-99,-3,-97,-5,82,-6,-8,-9,-107,-11,125,-14,122,-18,-28,-20,41,-21,56,-25,-7,-28,-36,-33,-36,-33,-13,-36,-13,-36,-13,-36,-57,-39,-57,-39,81,-42,81,-42,110,-50,-15,-55,-15,-55,12,-59,12,-59,-74,-65,-74,-65,-74,-65,-74,-65,-28,-71,-28,-71,-117,-77,-117,-77,-117,-77,-117,-77,-96,-84,-96,-84,-96,-84,-96,-84,-96,-84,-96,-84,-96,-84,20,-91,20,-91,20,-91,20,-91,-40,-100,-40,-100,-40,-100,-40,-100,-40,-100,-40,-100,-40,-100,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,21,-118,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-33,-109,-40,-100,-40,-100,-40,-100,-40,-100,-40,-100,-40,-100,-40,-100,-40,-100,-40,-100,20,-91,20,-91,20,-91,20,-91,20,-91,20,-91,20,-91,20,-91,-96,-84,-96,-84,-96,-84,-96,-84,-96,-84,-117,-77,-117,-77,-117,-77,-117,-77,-117,-77,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-74,-65,-74,-65,-74,-65,-74,-65,12,-59,12,-59,-15,-55,-15,-55,-15,-55,110,-50,110,-50,-117,-46,-117,-46,-117,-46,81,-42,81,-42,-57,-39,-57,-39,-13,-36,-13,-36,-36,-33,-36,-33,-121,-30,56,-25,70,-23,41,-21,-28,-20,122,-18,-17,-17,-17,-17,125,-14,-92,-12,-107,-11,62,-9,-94,-8,-53,-6,82,-4,-48,-3,-104,0,99,2,-58,4,-63,6,-62,8,-31,10,100,12,-68,14,17,16,-122,17,28,19,-41,20,-70,22,-56,24,57,28,121,29,36,32,36,32,13,35,13,35,57,38,57,38,57,38,-81,41,-81,41,117,45,117,45,117,45,-110,49}; }
	private static byte[] data1(){ return new byte[] {-110,49,15,54,15,54,15,54,-12,58,-12,58,-12,58,74,64,74,64,74,64,74,64,28,70,28,70,28,70,28,70,28,70,28,70,117,76,117,76,117,76,117,76,117,76,117,76,117,76,96,83,96,83,96,83,96,83,96,83,96,83,96,83,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,33,108,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,40,99,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,-20,90,96,83,96,83,96,83,96,83,96,83,117,76,117,76,117,76,117,76,117,76,117,76,117,76,117,76,117,76,28,70,28,70,28,70,28,70,28,70,74,64,74,64,74,64,74,64,74,64,-12,58,-12,58,-12,58,-12,58,15,54,15,54,15,54,-110,49,-110,49,-110,49,117,45,117,45,-81,41,-81,41,57,38,57,38,13,35,13,35,36,32,36,32,36,32,121,29,121,29,7,27,-56,24,-56,24,-70,22,-70,22,-41,20,28,19,28,19,-122,17,17,16,-68,14,100,12,107,10,-62,8,14,7,53,5,4,4,99,2,1,1,-49,-2,-99,-3,82,-4,58,-5,82,-6,-94,-8,-8,-9,115,-10,-107,-11,-92,-12,125,-14,-17,-17,122,-18,-28,-20,41,-21,70,-23,56,-25,-7,-28,-7,-28,-121,-30,-36,-33,-36,-33,-36,-33,-13,-36,-13,-36,-13,-36,-13,-36,-57,-39,-57,-39,-57,-39,-57,-39,81,-42,81,-42,81,-42,81,-42,-117,-46,-117,-46,-117,-46,-117,-46,110,-50,110,-50,110,-50,-15,-55,-15,-55,-15,-55,-15,-55,12,-59,12,-59,12,-59,12,-59,12,-59,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-28,-71,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,-74,-65,12,-59,12,-59,12,-59,12,-59,12,-59,12,-59,12,-59,12,-59,-15,-55,-15,-55,-15,-55,-15,-55,110,-50,110,-50,110,-50,110,-50,110,-50,110,-50,-117,-46,-117,-46,-117,-46,-117,-46,-117,-46,-117,-46,-117,-46,-117,-46,-117,-46,81,-42,81,-42,81,-42,81,-42,-57,-39,-57,-39,-57,-39,-57,-39,-57,-39,-57,-39,-57,-39,-13,-36,-13,-36,-13,-36,-13,-36,-13,-36,-13,-36,-13,-36,-36,-33,-36,-33,-36,-33,-36,-33,-36,-33,-121,-30,-121,-30,-7,-28,-7,-28,-7,-28,56,-25,56,-25,56,-25,70,-23,70,-23,70,-23,41,-21,41,-21,41,-21,41,-21,-28,-20,-28,-20,-28,-20,122,-18,122,-18,122,-18,122,-18,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,-100,-13,-100,-13,-100,-13,-100,-13,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-92,-12,-92,-12,-92,-12,-92,-12,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-92,-12,-92,-12,-92,-12,-100,-13,-100,-13,-100,-13,-100,-13,125,-14,125,-14,125,-14,68,-15,68,-15,68,-15,68,-15,68,-15,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,122,-18,122,-18,122,-18,122,-18,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,70,-23}; }
	private static byte[] data2(){ return new byte[] {70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,68,-15,68,-15,125,-14,125,-14,-100,-13,-100,-13,-100,-13,-92,-12,-92,-12,-107,-11,-107,-11,115,-10,115,-10,115,-10,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,-8,-9,-8,-9,-8,-9,-94,-8,63,-7,-49,-7,82,-6,-53,-6,-97,-5,-4,-5,-24,-4,102,-3,-2,-3,-77,-2,75,-1,-40,0,107,1,24,2,-102,2,24,3,-82,3,49,4,97,4,-3,4,53,5,-82,5,49,6,-63,6,94,7,8,8,-62,8,-115,9,-115,9,92,11,100,12,-125,13,-125,13,-68,14,17,16,17,16,-56,16,17,16,-122,17,-122,17,-122,17,28,19,28,19,28,19,28,19,-41,20,-61,21,-41,20,-70,22,-70,22,-56,24,-56,24,7,27,7,27,121,29,121,29,36,32,36,32,36,32,36,32,36,32,36,32,36,32,13,35,13,35,13,35,13,35,13,35,57,38,57,38,57,38,57,38,57,38,-81,41,-81,41,-81,41,-81,41,-81,41,-81,41,117,45,117,45,117,45,117,45,117,45,117,45,117,45,-110,49,-110,49,-110,49,-110,49,-110,49,15,54,15,54,15,54,15,54,15,54,15,54,-12,58,-12,58,-12,58,-12,58,-12,58,-12,58,-12,58,-12,58,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,28,70,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,74,64,-12,58,-12,58,-12,58,-12,58,-12,58,-12,58,15,54,15,54,15,54,15,54,15,54,-110,49,-110,49,-110,49,-110,49,-110,49,-110,49,-110,49,117,45,117,45,117,45,117,45,117,45,117,45,-81,41,-81,41,-81,41,-81,41,-81,41,57,38,57,38,57,38,57,38,57,38,13,35,13,35,13,35,13,35,13,35,36,32,36,32,36,32,36,32,121,29,121,29,57,28,7,27,-56,24,-56,24,-70,22,-70,22,-70,22,-41,20,-41,20,-12,19,28,19,-122,17,-122,17,17,16,-56,16,17,16,-68,14,-125,13,-125,13,100,12,92,11,107,10,-115,9,-115,9,-62,8,8,8,8,8,94,7,-63,6,49,6,53,5,-58,4,4,4,-41,2,2,2,49,1,-128,-1,-24,-2,80,-2,-48,-3,41,-3,82,-4,-4,-5,58,-5,82,-6,-49,-7,-94,-8,-8,-9,62,-9,62,-9,115,-10,115,-10,-107,-11,-107,-11,-92,-12,-92,-12,-100,-13,-100,-13,125,-14,125,-14,68,-15,68,-15,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,122,-18,122,-18,122,-18,122,-18,122,-18,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,-7,-28,-7,-28,-7,-28,-7,-28,-7,-28,-7,-28,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,-7,-28,56,-25,-7,-28,-7,-28,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25}; }
	private static byte[] data3(){ return new byte[] {56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,56,-25,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,70,-23,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,41,-21,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,-28,-20,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,122,-18,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,68,-15,68,-15,68,-15,68,-15,68,-15,125,-14,125,-14,125,-14,125,-14,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,-17,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,68,-15,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,125,-14,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-100,-13,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-94,-8,-94,-8,63,-7,63,-7,63,-7,-49,-7,-49,-7,-49,-7,-49,-7,-49,-7,82,-6,82,-6,82,-6,82,-6,-53,-6,-53,-6,-53,-6,58,-5,58,-5,-97,-5,-97,-5,-97,-5,-4,-5,-4,-5,-4,-5,82,-4,82,-4,82,-4,82,-4,-96,-4,-96,-4,-24,-4,-24,-4,41,-3,102,-3,102,-3,102,-3,-48,-3,-48,-3,-2,-3,41,-2,116,-2,-77,-2,-49,-2,-1,-2,58,-1,75,-1,-128,0,-104,0,-75,0,-21,0,24,1,77,1,-116,1,-80,1,2,2,2,2,48,2,48,2,99,2,48,2,99,2,-102,2,-102,2,-102,2,-41,2,-9,2,24,3,96,3,-82,3,-40,3,4,4,4,4,4,4,4,4,97,4,-109,4,-58,4,-58,4,-58,4,-3,4,-58,4,53,5,53,5,-82,5,-82,5,-18,5,49,6,49,6,-63,6,14,7,-63,6,94,7,94,7,8,8,8,8,8,8,8,8,8,8,99,8,8,8,8,8,-62,8,-62,8,-62,8,-62,8,38,9,-62,8,-62,8,38,9,-62,8,-62,8,-62,8,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-6,9,-115,9,-6,9,-115,9,107,10,107,10,107,10,107,10,-31,10,107,10,92,11,92,11,92,11,-35,11,92,11,-35,11,92,11,-35,11,92,11,-35,11,92,11,92,11,92,11,92,11,92,11,92,11,-35,11,92,11,-35,11,92,11,-35,11,92,11,-35,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11}; }
	private static byte[] data4(){ return new byte[] {92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,92,11,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,-115,9,-6,9,-115,9,-6,9,-115,9,-115,9,-115,9,-6,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-6,9,-115,9,-6,9,-115,9,-115,9,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,107,10,-31,10,107,10,107,10,107,10,-115,9,-115,9,-6,9,-115,9,-6,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-115,9,-62,8,38,9,-62,8,38,9,-62,8,-62,8,-62,8,-62,8,8,8,8,8,99,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,94,7,94,7,94,7,94,7,94,7,94,7,14,7,-63,6,-63,6,-63,6,120,6,49,6,49,6,49,6,-18,5,-82,5,-82,5,-82,5,-82,5,53,5,112,5,53,5,53,5,53,5,53,5,53,5,53,5,-3,4,-58,4,-3,4,-58,4,-3,4,-58,4,-3,4,-58,4,-58,4,-58,4,97,4,-109,4,97,4,4,4,97,4,97,4,97,4,4,4,4,4,4,4,4,4,4,4,97,4,97,4,97,4,97,4,4,4,97,4,97,4,97,4,97,4,4,4,4,4,4,4,4,4,49,4,4,4,49,4,4,4,4,4,4,4,4,4,4,4,4,4,-82,3,-82,3,-82,3,-122,3,96,3,-122,3,96,3,-82,3,-82,3,-82,3,-82,3,-82,3,-82,3,-82,3,4,4,-40,3,4,4,4,4,4,4,4,4,-40,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,97,4,97,4,97,4,97,4,97,4,97,4,97,4,-58,4,-58,4,-58,4,-58,4,-3,4,-58,4,53,5,53,5,53,5,112,5,-82,5,-82,5,53,5,-18,5,-82,5,-18,5,-82,5,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,49,6,120,6,49,6,49,6,-63,6,-63,6,14,7,-63,6,94,7,94,7,94,7,94,7,94,7,94,7,94,7,94,7,94,7,94,7,14,7,-63,6,14,7,-63,6,-63,6,-63,6,-63,6,-63,6,49,6,49,6,120,6,49,6,49,6,-63,6,-63,6,-63,6,-63,6,-63,6,-63,6,49,6,49,6,120,6,49,6,49,6,49,6,49,6,49,6,-18,5,-82,5,-82,5,-82,5,-82,5,112,5,53,5,53,5,53,5,53,5,53,5,53,5,53,5,53,5,53,5,53,5,53,5,53,5,53,5,53,5,-58,4,53,5,53,5,53,5,53,5,53,5,53,5,-3,4,-58,4,-3,4,-58,4,-58,4,-58,4,97,4,-109,4,97,4,4,4,4,4,49,4,4,4,4,4,-40,3,96,3,96,3,24,3,-9,2,-41,2,-41,2,-102,2,99,2,99,2,99,2,2,2,2,2,2,2,-41,1,-41,1,-80,1,-116,1,107,1,77,1,49,1,1,1,1,1,1,1,-40,0,-75,0,-75,0,-116,0,-116,0,-116,0,90,-1,75,-1,58,-1,58,-1,21,-1,-1,-2,-1,-2,-1,-2,-24,-2,-24,-2,-77,-2,-107,-2,-107,-2,-107,-2,116,-2,116,-2,80,-2,80,-2,41,-2,-2,-3,41,-2,-2,-3,-2,-3,-2,-3,-48,-3,-48,-3,-48,-3,-48,-3,102,-3,102,-3,102,-3,41,-3,41,-3,41,-3,-24,-4,-24,-4,-96,-4,-96,-4,82,-4,-4,-5,-4,-5,-4,-5,-97,-5,-97,-5,-97,-5,-97,-5,-97,-5,58,-5,58,-5,58,-5,-53,-6,-53,-6,-53,-6,-53,-6,-53,-6,-53,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,-49,-7,-49,-7,-49,-7,-49,-7,-49,-7,-49,-7,-49,-7,-49,-7,-49,-7,-49,-7,-49,-7,63,-7,63,-7,63,-7,63,-7,-94,-8,-94,-8,-94,-8,-94,-8,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12}; }
	private static byte[] data5(){ return new byte[] {-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-92,-12,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,-107,-11,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,115,-10,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,62,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-8,-9,-94,-8,-94,-8,-94,-8,-94,-8,-94,-8,-94,-8,63,-7,63,-7,63,-7,63,-7,63,-7,-49,-7,-49,-7,-49,-7,-49,-7,-49,-7,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,82,-6,-53,-6,-53,-6,-53,-6,-53,-6,-53,-6,-53,-6,-53,-6,58,-5,58,-5,58,-5,58,-5,58,-5,-97,-5,-97,-5,-97,-5,-4,-5,-4,-5,-4,-5,-4,-5,-4,-5,-4,-5,82,-4,82,-4,-96,-4,-96,-4,-96,-4,-24,-4,-24,-4,-24,-4,41,-3,41,-3,41,-3,41,-3,102,-3,102,-3,102,-3,102,-3,-99,-3,-99,-3,-99,-3,-48,-3,-48,-3,-2,-3,-2,-3,41,-2,80,-2,116,-2,-77,-2,-77,-2,-49,-2,-49,-2,-24,-2,-1,-2,21,-1,-1,-2,90,-1,90,-1,-128,0,-128,-1,-116,0,-104,0,-116,0,-116,0,-116,0,-90,0,-90,0,-90,0,-40,0,-40,0,-21,0,-21,0,-21,0,1,1,1,1,1,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,49,1,77,1,77,1,49,1,107,1,77,1,92,1,77,1,107,1,107,1,-116,1,-116,1,-99,1,-80,1,-80,1,-80,1,-116,1,-99,1,-116,1,107,1,107,1,-116,1,107,1,107,1,-116,1,77,1,77,1,107,1,107,1,107,1,77,1,77,1,77,1,77,1,77,1,49,1,49,1,77,1,77,1,49,1,49,1,77,1,24,1,49,1,77,1,49,1,49,1,49,1,24,1,77,1,49,1,49,1,24,1,49,1,1,1,1,1,1,1,-21,0,-40,0,-58,0,-58,0,-58,0,-104,0,-104,0,-104,0,-128,0,-128,0,90,-1,75,-1,90,-1,75,-1,58,-1,58,-1,58,-1,40,-1,58,-1,40,-1,40,-1,40,-1,40,-1,40,-1,40,-1,-1,-2,-1,-2,21,-1,-1,-2,-1,-2,40,-1,40,-1,58,-1,40,-1,-1,-2,40,-1,40,-1,21,-1,-1,-2,-1,-2,-1,-2,-1,-2,-49,-2,-49,-2,-77,-2,-77,-2,-107,-2,-107,-2,116,-2,80,-2,80,-2,41,-2,-2,-3,-2,-3,-2,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-99,-3,-48,-3,-48,-3,-48,-3,-99,-3,-48,-3,-99,-3,-48,-3,-99,-3,-48,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,102,-3,-99,-3,-99,-3,-99,-3,-99,-3,102,-3,-99,-3,-99,-3,102,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,102,-3,-99,-3,-99,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,-99,-3,102,-3,102,-3,-99,-3,-99,-3,-99,-3,-48,-3,-99,-3,-48,-3,-99,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,102,-3,-99,-3,-99,-3,102,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-48,-3,-48,-3,-99,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,41,-2,41,-2,41,-2,80,-2,80,-2,116,-2,116,-2,116,-2,-107,-2,-107,-2,-77,-2,-77,-2,-77,-2,-49,-2,-49,-2,-24,-2,-24,-2,-1,-2,-1,-2,58,-1,58,-1,75,-1,90,-1,-116,0,-128,-1,-116,0,-104,0,-75,0,-90,0,-75,0,-40,0,-40,0,1,1,-21,0,1,1,24,1,24,1,49,1,77,1,49,1,107,1,107,1,123,1,-116,1,-116,1,-116,1,-116,1,-80,1,-80,1,-41,1,-41,1,-41,1,-41,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2}; }
	private static byte[] data6(){ return new byte[] {48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,2,2,48,2,48,2,2,2,48,2,2,2,2,2,48,2,2,2,2,2,48,2,48,2,99,2,99,2,99,2,99,2,99,2,99,2,99,2,-102,2,-102,2,-102,2,-72,2,-102,2,-41,2,-41,2,-41,2,-41,2,-41,2,-41,2,-41,2,-41,2,-41,2,-41,2,-72,2,-41,2,-41,2,-41,2,-102,2,-41,2,-41,2,-41,2,-72,2,-102,2,-72,2,-102,2,-102,2,-102,2,99,2,-102,2,99,2,-102,2,-102,2,-102,2,-102,2,-72,2,-102,2,99,2,99,2,-72,2,-102,2,-102,2,-102,2,-102,2,-102,2,99,2,-102,2,99,2,-102,2,99,2,-102,2,-102,2,-102,2,99,2,-102,2,-102,2,-102,2,-102,2,-102,2,-102,2,-102,2,-102,2,99,2,99,2,-102,2,99,2,126,2,-102,2,99,2,99,2,-102,2,-102,2,-102,2,-102,2,-102,2,-102,2,-102,2,99,2,-102,2,-102,2,99,2,99,2,-102,2,99,2,-102,2,-102,2,-102,2,-102,2,99,2,99,2,99,2,99,2,99,2,99,2,48,2,99,2,99,2,99,2,99,2,99,2,99,2,99,2,48,2,99,2,99,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,99,2,99,2,99,2,48,2,99,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,2,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,48,2,2,2,2,2,2,2,2,2,48,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,-41,1,2,2,2,2,-20,1,-41,1,2,2,-41,1,-41,1,-41,1,-41,1,-20,1,-41,1,-41,1,-41,1,-41,1,-41,1,-41,1,-41,1,-41,1,-80,1,-41,1,-80,1,-41,1,-80,1,-80,1,-80,1,-116,1,-116,1,-116,1,-116,1,-116,1,-116,1,-116,1,-116,1,107,1,107,1,107,1,-116,1,107,1,-116,1,107,1,77,1,107,1,77,1,123,1,107,1,77,1,107,1,77,1,107,1,107,1,107,1,107,1,77,1,107,1,49,1,77,1,49,1,49,1,49,1,49,1,49,1,49,1,63,1,24,1,49,1,24,1,24,1,49,1,49,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,49,1,24,1,24,1,24,1,24,1,24,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-21,0,1,1,1,1,-40,0,-21,0,1,1,-40,0,-21,0,-75,0,-75,0,-75,0,-90,0,-90,0,-104,0,-90,0,-116,0,-104,0,-116,0,-116,0,-116,0,-128,-1,-116,0,-104,0,-104,0,-128,0,-116,0,-104,0,-104,0,-116,0,-116,0,-104,0,-90,0,-116,0,-116,0,-116,0,-104,0,-116,0,-104,0,-104,0,-90,0,-116,0,-104,0,-104,0,-75,0,-90,0,-90,0,-90,0,-75,0,-90,0,-75,0,-75,0,-58,0,-75,0,-40,0,-58,0,-58,0,-40,0,-58,0,1,1,-40,0,-21,0,-21,0,-40,0,-58,0,-40,0,-40,0,-21,0,-40,0,-40,0,-58,0,-58,0,-75,0,-90,0,-75,0,-90,0,-90,0,-75,0,-75,0,-90,0,-75,0,-104,0,-75,0,-90,0,-75,0,-75,0,-75,0,-90,0,-90,0,-90,0,-104,0,-90,0,-75,0,-104,0,-90,0,-104,0,-104,0,-90,0,-104,0,-116,0,-104,0,-104,0,-104,0,-104,0,-128,-1,-128,-1,-104,0,-128,-1,-116,0,-104,0,-116,0,-128,0,-128,-1,-116,0,-116,0,-104,0,-116,0,-104,0,-128,-1,-116,0,-128,-1,-128,-1,-116,0,-128,-1,-128,0,-116,0,-116,0,-128,0,90,-1,-128,-1,104,-1,90,-1,75,-1,75,-1,75,-1,58,-1,40,-1,40,-1,40,-1,21,-1,21,-1,-1,-2,-1,-2,-1,-2,-1,-2,-24,-2,-1,-2,-24,-2,-24,-2,-24,-2,-24,-2,-24,-2,-49,-2,-49,-2,-49,-2,-49,-2,-77,-2,-77,-2,-77,-2,-77,-2,-107,-2,-107,-2,-107,-2,-107,-2,-107,-2,-107,-2,-107,-2,116,-2,116,-2,80,-2,80,-2,80,-2,80,-2,80,-2,80,-2,41,-2}; }
	private static byte[] data7(){ return new byte[] {41,-2,41,-2,41,-2,-2,-3,41,-2,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-99,-3,-99,-3,-99,-3,-99,-3,102,-3,-99,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,41,-3,102,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-96,-4,-24,-4,-96,-4,-24,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-24,-4,-96,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-96,-4,-24,-4,-96,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,41,-3,-24,-4,-24,-4,-24,-4,-24,-4,41,-3,-24,-4,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,-24,-4,41,-3,-24,-4,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,41,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,102,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-99,-3,-48,-3,-48,-3,-99,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-48,-3,-2,-3,-2,-3,-2,-3,-2,-3,-48,-3,-48,-3,-48,-3,-2,-3,-2,-3,-48,-3,-2,-3,-48,-3,-48,-3,-48,-3,-48,-3,-2,-3,-48,-3,-2,-3,-2,-3,-48,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,-2,-3,41,-2,41,-2,41,-2,41,-2,80,-2,80,-2,80,-2,80,-2,80,-2,80,-2,116,-2,116,-2,116,-2,-107,-2,-107,-2,-107,-2,-107,-2,-107,-2,-107,-2,-77,-2,-107,-2,-77,-2,-49,-2,-77,-2,-49,-2,-49,-2,-49,-2,-24,-2,-24,-2,-24,-2,-1,-2,-1,-2,-1,-2,-1,-2,40,-1,-1,-2,40,-1,58,-1,58,-1,58,-1,58,-1,90,-1,90,-1,90,-1,116,-1,-128,0,-128,0,-110,0,-128,-1,-104,0,-116,0,-116,0,-116,0,-90,0,-90,0,-75,0,-90,0,-58,0,-75,0,-75,0,-75,0,-75,0,-40,0,-58,0,-58,0,-58,0,-40,0,-58,0,-58,0,-40,0,-40,0,-58,0,-75,0,-21,0,-40,0,-21,0,-58,0,-40,0,-40,0,1,1,-40,0,1,1,-21,0,-21,0,-40,0,-40,0,-40,0,-40,0,1,1,-21,0,-21,0,-21,0,-21,0,-40,0,1,1,-40,0,-21,0,-40,0,-40,0,-21,0,-40,0,-40,0,-40,0,-58,0,-58,0,-58,0,-58,0,-58,0,-40,0,-58,0,-58,0,-40,0,-58,0,-58,0,-58,0,-40,0,-40,0,-58,0,-58,0,-58,0,-58,0,-58,0,1,1,-58,0,-58,0,-21,0,-40,0,-58,0,-21,0,-21,0,-40,0,-40,0,-58,0,-40,0,-21,0,1,1,-21,0,1,1,-21,0,1,1,-21,0,1,1,1,1,1,1,1,1,1,1,1,1,-21,0,1,1,-21,0,1,1,-21,0,-40,0,1,1,1,1,-40,0,-21,0,1,1,-40,0,-40,0,-40,0,-58,0,-21,0,-58,0,-40,0,-40,0,-40,0,-40,0,-58,0,-58,0,-58,0,-58,0,-75,0,-58,0,-40,0,-75,0,-58,0,-40,0,-58,0,-58,0,-58,0,-40,0,-40,0,-58,0,-58,0,-40,0,-40,0,-40,0,-21,0,-40,0,-21,0,-40,0,-58,0,-40,0,-58,0,-58,0,-58,0,-40,0,-58,0,-40,0,-40,0,-21,0,-40,0,-40,0,-40,0,1,1,-21,0,-58,0,-40,0,-40,0,-21,0,-40,0,-40,0,-40,0,-21,0,-40,0,-21,0,1,1,1,1,-40,0,1,1,1,1,1,1,-21,0,1,1,1,1,1,1,1,1,-21,0,1,1,-21,0,1,1,-21,0,1,1,1,1,-40,0,-21,0,1,1,-40,0,-58,0,-21,0,-75,0,-75,0,-90,0,-75,0,-75,0,-75,0}; }
	private static byte[] getData(){
		byte[] data = new byte[8192];
		System.arraycopy(data0(), 0, data, 0, 1024);
		System.arraycopy(data1(), 0, data, 1024, 1024);
		System.arraycopy(data2(), 0, data, 2048, 1024);
		System.arraycopy(data3(), 0, data, 3072, 1024);
		System.arraycopy(data4(), 0, data, 4096, 1024);
		System.arraycopy(data5(), 0, data, 5120, 1024);
		System.arraycopy(data6(), 0, data, 6144, 1024);
		System.arraycopy(data7(), 0, data, 7168, 1024);
		return data;
	}
	/** Constructs a new AudioClip with the data from HitY.WAV. */
	public SoundHitY(){
		data = getData();
		format = new AudioFormat(AudioFormat.Encoding.PCM_UNSIGNED, (float)(24000.0), 16, 1, 2, (float)(24000.0), false);
		lineInfo = new DataLine.Info(SourceDataLine.class, format, AudioSystem.NOT_SPECIFIED);
		try{ AudioSystem.getLine(lineInfo); }
		catch(IllegalArgumentException ex){ lineInfo = null; }
		catch(LineUnavailableException e){}
	}
	/** A separate thread for playing HitY.WAV. */
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
	/** A separate thread for looping play of HitY.WAV. */
	private class LoopThread extends Thread {
		private SoundHitY clip;
		private boolean looping = true;
		public LoopThread(SoundHitY c){ clip = c; }
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
	/** Plays HitY.WAV from the beginning, even if it is already playing or looping. */
	public void play(){ if(lineInfo == null) return; doPlay(); }
	private synchronized void doPlay(){
		doStopPlay();
		playThread = new PlayThread(data, format, lineInfo);
		playThread.start();
	}
	/** Plays HitY.WAV continuously until stopped. */
	public void loop(){ if(lineInfo == null) return; doLoop(); }
	private synchronized void doLoop(){
		doStopLoop();
		loopThread = new LoopThread(this);
		loopThread.start();
	}
	/** Stops play and looping of HitY.WAV. */
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
	/** Tests if HitY.WAV is currently playing or looping.
	 * @return <tt>true</tt> if playing or looping, <tt>false</tt> otherwise */
	public boolean isPlaying(){ if(lineInfo == null) return false; return doIsPlaying(); }
	private synchronized boolean doIsPlaying(){
		if(loopThread == null && playThread == null) return false;
		else if(loopThread == null) return playThread.isPlaying();
		else if(playThread == null) return loopThread.isLooping();
		else return loopThread.isLooping() && playThread.isPlaying();
	}
	/** Tests if HitY.WAV is currently looping.
	 * @return <tt>true</tt> if looping, <tt>false</tt> otherwise */
	public boolean isLooping(){ if(lineInfo == null) return false; return doIsLooping(); }
	private synchronized boolean doIsLooping(){
		if(loopThread == null) return false;
		else return loopThread.isLooping();
	}
}