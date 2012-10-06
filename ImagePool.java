import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImagePool {

	public static Image IMAGE_SPLIT;
	
	public static Image setImage(String ImageURL)
	{
		try {
			return ImageIO.read(new File(ImageURL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
