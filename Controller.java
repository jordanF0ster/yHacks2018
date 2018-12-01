package application;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable  {
	@FXML
	private Label label1 ;
	@FXML
	private Label label2 ;
	
	@FXML
	private Button File;
	
	@FXML
	private ProgressBar progressBar;
	public static ProgressBar statprogressBar;
	
	@FXML 
	private Label progress;
	public static Label label;
	
		class bg_Thread implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			try {
				progressBar.setProgress(i/100.0);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} 
		
	}
	
} 
	@FXML
	public void HandleButton(ActionEvent Event) {
		Thread th = new Thread(new bg_Thread());
		th.start();
	}


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		progressBar.setProgress(0.0);
	
	} 
	
	@FXML
	public File onFileClick(MouseEvent event) throws IOException {
		ArrayList<String> fileType = new ArrayList<>();
		fileType.add("*.mov");
		fileType.add("*.mp4");
		fileType.add("*.wmv");
		fileType.add("*.avi");
		fileType.add("*.flv");
	    FileChooser chooser = new FileChooser();
	    chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video formats", fileType));
	    chooser.setTitle("Open File");
	    File file = chooser.showOpenDialog(new Stage());
	    File.setVisible(false);
	    return file;
	    
	}


	
	
	
	
	
	

	
	
	
}
	







	

