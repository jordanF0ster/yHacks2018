package application;
	

import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * creating a new stage using the GUI.fxml
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
		AnchorPane root = new AnchorPane();
	     root = loader.load();
	    Scene scene = new Scene(root);
	    Image image = new Image("/application/GUIbackground.jpg");
	    BackgroundImage bgImg = new BackgroundImage(image, 
	    	    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
	    	    BackgroundPosition.DEFAULT, 
	    	    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
	    root.setBackground(new Background(bgImg));

	    
	    primaryStage.setScene(scene);
	    primaryStage.show();
	   
	    
	   
	    
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
