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
	
	boolean horizontalMode = true;
	int rowCol = 0;
	
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
			
			scene.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {

				@Override
				public void handle(javafx.scene.input.KeyEvent event) {
					
					if(event.getCode() == KeyCode.SPACE) {
						horizontalMode = !horizontalMode;
					}
					
					if(horizontalMode) {
						if(event.getCode() == KeyCode.RIGHT) {
							FXController.moveRight(rowCol, FXController.board);
						}
						else if(event.getCode() == KeyCode.LEFT) {
							FXController.moveLeft(rowCol, FXController.board);
						}
						else if(event.getCode() == KeyCode.UP) {
							if(rowCol == 0)
								rowCol = 3;
							else
								rowCol--;
						}
						else if(event.getCode() == KeyCode.DOWN) {
							if(rowCol == 3)
								rowCol = 0;
							else
								rowCol++;
						}
					}
					else {
						if(event.getCode() == KeyCode.RIGHT) {
							if(rowCol == 3)
								rowCol = 0;
							else
								rowCol++;
						}
						else if(event.getCode() == KeyCode.LEFT) {
							if(rowCol == 0)
								rowCol = 3;
							else
								rowCol--;
						}
						else if(event.getCode() == KeyCode.UP) {
							FXController.moveUp(rowCol, FXController.board);
						}
						else if(event.getCode() == KeyCode.DOWN) {
							FXController.moveDown(rowCol, FXController.board);
						}
					}
					
				}
				
			});

			
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
