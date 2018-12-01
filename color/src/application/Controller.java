package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

public class Controller {
	@FXML
	private Label label1 ;
	@FXML
	private Label label2 ;
	
	@FXML
	private Button File;

	@FXML
	public File onFileClick(MouseEvent event) {
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
	    return file;
	    
	}
	// called by the FXML loader after the labels declared above are injected:
	/*public void initialize() {


	        // trivial example, could also be done directly in the fxml:
	label1.setText("Foo");
	label2.setText("Bar");
	    }*/
}
