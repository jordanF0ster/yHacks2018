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
		    System.out.println("Done reading");
		} catch (IOException e) {
			System.out.println("Error" + e);
		}
	}
	/** Computes the average red, green, and blue
	 *  values of all the pixels inside the image
	 */
	public void averagePixelValue() {
		int redTotal = 0, greenTotal = 0, blueTotal = 0;
		int avgRedTotal = 0, avgGreenTotal = 0, avgBlueTotal = 0;
		int area = width * height;
		Color c;
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				c = new Color(img.getRGB(row, col));
				redTotal += c.getRed();
				greenTotal += c.getGreen();
				blueTotal += c.getBlue();
			}
		}
		avgRedTotal = redTotal / area;
		avgGreenTotal = greenTotal / area;
		avgBlueTotal = blueTotal / area;
		
		System.out.println(avgRedTotal);
		System.out.println(avgGreenTotal);
		System.out.println(avgBlueTotal);
	}
	
	public void modePixelValue() {
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int r = 0; r < 256; r++) {
			for (int g = 0; g < 256; g++) {
				for (int b = 0; b < 256; b++) {
					map.put(String.format("#%02x%02x%02x", r, g, b), 0);
				}
			}
		}
		
		//System.out.println(map);
	}
	
	public BufferedImage getImage() {
		return img;
	}
	
	public String getPath() {
		return path;
	}
	
	public static void main(String[] args) {
		ImageReader x = new ImageReader("/Users/jfoster/Documents/yhacks/amazon.jpg");
		x.averagePixelValue();
		//x.modePixelValue();
	}
	

}
