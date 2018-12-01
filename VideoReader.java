package yhacks2018;

import java.awt.Color;
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;  
import javax.imageio.ImageIO;  
import org.bytedeco.javacv.FFmpegFrameGrabber;  
import org.bytedeco.javacv.Frame;  
import org.bytedeco.javacv.FrameGrabber.Exception;  
import org.bytedeco.javacv.Java2DFrameConverter;

public class VideoReader {

	private String videPath;
	private String imagePath;
	public ArrayList<String> averageColorList;
	
	public VideoReader(String videPath, String imagePath) {
		this.videPath = videPath;
		this.imagePath = imagePath;
		averageColorList = new ArrayList<String>();
	}

	public void videoToImg(String imgType, int frameJump) throws Exception, IOException {
		Java2DFrameConverter converter = new Java2DFrameConverter();  
		FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(videPath); 
		ImageReader reader;
		frameGrabber.start();

		Frame frame;  
		double frameRate = frameGrabber.getFrameRate();  
		int imgNum = 0;  
		System.out.println("Video has " + frameGrabber.getLengthInFrames() + " frames and has frame rate of " + frameRate);

		try {           
			for(int i = 1; i <= frameGrabber.getLengthInFrames(); i++){  
				imgNum++;
				frameGrabber.setFrameNumber(i);  
				frame = frameGrabber.grab();  
				BufferedImage bi = converter.convert(frame);  
				String path1 = imagePath + File.separator + imgNum + "." + imgType;
				if (bi == null) {
					continue;
				}
				ImageIO.write(bi, imgType, new File(path1));  
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

	public String getVideoPath() {
		return videPath;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public static void main(String[] args) throws Exception, IOException {
		VideoReader x = new VideoReader("/Users/jfoster/Documents/yhacks/amsterdam.mp4",
				                        "/Users/jfoster/Documents/yhacks/amsterdam_files");
		x.videoToImg("jpg", 0);
		System.out.print(x.averageColorList.size());
		for (int i = 0; i < x.averageColorList.size(); i++) {
			System.out.println(x.averageColorList.get(i));
		}
	}



}
