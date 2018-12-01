package yhacks2018;

import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;  
import org.bytedeco.javacv.FFmpegFrameGrabber;  
import org.bytedeco.javacv.Frame;  
import org.bytedeco.javacv.FrameGrabber.Exception;  
import org.bytedeco.javacv.Java2DFrameConverter;

public class VideoReader {

	private String videoPath; // path to the video to be processed
	private String imagePath; // path to where the frames of video
	public ArrayList<String> averageColorList; // array of the average color (hex) of the frames
	private int numFrames;
	
	// new empty array is created
	public VideoReader(String videPath, String imagePath) {
		this.videoPath = videPath;
		this.imagePath = imagePath;
		averageColorList = new ArrayList<String>();
		numFrames = 0;
	}

	/**
	 * Breaks down an image into frames, the number of frames is affected by frameJump.
	 * Converts the frame of the image from type Frame to BufferedImage (buff).
	 * The frames of the video are then passed to and ImageReader (reader), and then
	 * the average color is calculated and stored in the array averageColorList. 
	 */
	public void videoToImg(String imgType, int frameJump) throws Exception, IOException {
		Java2DFrameConverter converter = new Java2DFrameConverter();  
		FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(videoPath); 
		ImageReader reader;
		frameGrabber.start();

		Frame frame;  
		double frameRate = frameGrabber.getFrameRate();  
		int imgNum = 0;  
		numFrames = frameGrabber.getLengthInFrames();
		System.out.println("Video has " + numFrames + 
						   " frames and has frame rate of " + frameRate);

		try {           
			for(int i = 1; i <= numFrames; i++){  
				imgNum++;
				frameGrabber.setFrameNumber(i);  
				frame = frameGrabber.grab();  
				BufferedImage buff = converter.convert(frame);  
				String path1 = imagePath + File.separator + imgNum + "." + imgType;
				if (buff == null) {
					continue;
				}
				ImageIO.write(buff, imgType, new File(path1));  
				reader = new ImageReader(path1);
				averageColorList.add(reader.averagePixelValue());
				i += frameJump; 
			}  
			System.out.print("Done"); 
			frameGrabber.stop();  
		} catch (Exception e) {  
			e.printStackTrace();  
		}
	}

	// path of video
	public String getVideoPath() {
		return videoPath;
	}
	
	// path of where images are stored
	public String getImagePath() {
		return imagePath;
	}
	
	public int getNumFrames() {
		return numFrames;
	}
}
