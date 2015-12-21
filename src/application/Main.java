package application;

import java.awt.event.KeyEvent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/application/GUI.fxml"));

			Scene scene = new Scene(root);
			
			String css = this.getClass().getResource("/application/application.css").toExternalForm();
			scene.getStylesheets().add(css);

			primaryStage.setTitle("Stripes");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			scene.setOnKeyPressed(
				event -> {
					//System.out.println("sdsds");
				}
		     );
			
			
			// close application on termination
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
				}
			});
			
			//stage.close();
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		launch(args);
	}
}
