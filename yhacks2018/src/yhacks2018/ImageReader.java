package yhacks2018;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.HashMap;
import javax.imageio.*;

public class ImageReader {

	private BufferedImage img;
	private String path;
	private int width;
	private int height;
	
	
	public ImageReader(String path) {
		try {
			this.path = path;
		    img = ImageIO.read(new File(path));
		    width = img.getWidth();
		    height = img.getHeight();
		} catch (IOException e) {
			System.out.println("Error" + e);
		}
	}
	/** Computes the average red, green, and blue
	 *  values of all the pixels inside the image
	 */
	public String averagePixelValue() {
		int redTotal = 0, greenTotal = 0, blueTotal = 0;
		int avgRedTotal = 0, avgGreenTotal = 0, avgBlueTotal = 0;
		int area = width * height;
		Color c;
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				c = new Color(img.getRGB(row, col)); //creates color to get individual rgb values
				redTotal += c.getRed();
				greenTotal += c.getGreen();
				blueTotal += c.getBlue();
			}
		}
		avgRedTotal = redTotal / area;
		avgGreenTotal = greenTotal / area;
		avgBlueTotal = blueTotal / area;
		
		return String.format("#%02x%02x%02x", avgRedTotal, avgGreenTotal, avgBlueTotal);
	}
	
	/** Calculates the most frequent color (mode) in the image.
	 *  Creates a HashMap of with keys of every possible Hex color, 
	 *  all with values of 0.
	 */
	
	/*
	public void modePixelValue() {
		HashMap<String, Integer> map = new HashMap<>();
		Color c;
		String key;
		int value = 0;
		
		for (int r = 0; r < 256; r++) {
			for (int g = 0; g < 256; g++) {
				for (int b = 0; b < 256; b++) {
					map.put(String.format("#%02x%02x%02x", r, g, b), 0);
				}
			}
		}
		
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				c = new Color(img.getRGB(row, col)); //creates color to get individual rgb values
				key = String.format("#%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
				map.put(key, map.get(key) + 1);
			}
		}
		
		for (int i = 0; i < map.size(); i++) {
			int freqVal = 0; // most frequent value
			String freqKey = ""; //most frequent key
		}
		
	}
	*/
	
	public BufferedImage getImage() {
		return img;
	}
	
	public String getPath() {
		return path;
	}

	

}