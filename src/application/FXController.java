package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class FXController implements Initializable{
	
	static int redCount = 0;
	static int greenCount = 0;
	static int blueCount = 0;
	static int yellowCount = 0;
	
	static String userInput;
	
	@FXML Parent root;
	@FXML private GridPane stripesGrid;
	@FXML private Button r1,r2,r3,r4,l1,l2,l3,l4,u1,u2,u3,u4,d1,d2,d3,d4;
	@FXML private Pane MainWindow;
	
	static String[][] board = new String[4][4];
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// create the array for the board
		 String[] colours = { "R", "G", "B", "Y" };
		 String RGBY = null;
		 
		 // populate the array
		 for (int i = 0; i < 4; i++) {
		 	 for (int j = 0; j < 4; j++) {
		 	 	 
		 	 	 RGBY = colourPicker(colours,RGBY);
		 	 	 board[i][j] = RGBY;
		 	 	 colourIncrement(RGBY);
		 	 }
		 }
		 
		 Timeline timeline = new Timeline(new KeyFrame(
			        Duration.millis(100),
			        ae -> printBoard(board)));
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
		 
	}
	
	public static String[][] getBoard() {
		return board;
	}
	
	public static void getValue(int counter) {
		if(counter == 1) {
			moveRight(1, board);
		}
	}
	
	
	private int colourChecker(String RGBY) {
		
		int colourCount = 0;
		
		if (RGBY == "R") 
			colourCount = redCount;
		else if (RGBY == "G") 
			colourCount = greenCount;
		else if (RGBY == "B") 
			colourCount = blueCount;
		else if (RGBY == "Y") 
			colourCount = yellowCount;
		
		return colourCount;
	}
	 
	void colourIncrement(String RGBY) {
		 if (RGBY == "R")
		 	 redCount++;
		 else if (RGBY == "G")
		 	 greenCount++;
		 else if (RGBY == "B")
		 	 blueCount++;
		 else if (RGBY == "Y")
		 	 yellowCount++;
	}
	 
	void printBoard(String board[][]) {

		stripesGrid.getChildren().clear();
		 for (int i = 0; i < 4; i++) {
		 	 for (int j = 0; j < 4; j++) {
		 		StackPane square = new StackPane();
		 		
		 		square.getStyleClass().add("panel");
				square.setStyle("-fx-background-color: " + getColor(board[i][j]) + ";");
				stripesGrid.add(square, j, i);
		 	 }
		 }
	}
	 
	String colourPicker(String colours[], String RGBY) {
	 do {
	 	 int randNum = (int) (Math.random() * 4);
	 
	 	 if (colours[randNum] == "R")
	 	 	 RGBY = "R";
	 	 else if (colours[randNum] == "G")
	 	 	 RGBY = "G";
	 	 else if (colours[randNum] == "B")
	 	 	 RGBY = "B";
	 	 else if (colours[randNum] == "Y")
	 	 	 RGBY = "Y";
	 } while (colourChecker(RGBY) == 4);
	 
	 return RGBY;
	}
	 
	static void moveRight(int row, String board[][]) {
	 
	 String temp_1;
	 String temp_2;
	 
	 temp_1 = board[row][0];
	 board[row][0] = board[row][3];
	 
	 temp_2 = board[row][1];
	 board[row][1] = temp_1;
	 
	 temp_1 = board[row][2];
	 board[row][2] = temp_2;
	 
	 temp_2 = board[row][3];
	 board[row][3] = temp_1;
	 
	}
	 
	static void moveLeft(int row, String board[][]) {
	 
	 String temp_1;
	 String temp_2;
	 
	 temp_1 = board[row][3];
	 board[row][3] = board[row][0];
	 
	 temp_2 = board[row][2];
	 board[row][2] = temp_1;
	 
	 temp_1 = board[row][1];
	 board[row][1] = temp_2;
	 
	 temp_2 = board[row][0];
	 board[row][0] = temp_1;
	 
	}
	 
	static void moveUp(int col, String board[][]) {
	 
	 String temp_1;
	 String temp_2;
	 
	 temp_1 = board[3][col];
	 board[3][col] = board[0][col];
	 
	 temp_2 = board[2][col];
	 board[2][col] = temp_1;
	 
	 temp_1 = board[1][col];
	 board[1][col] = temp_2;
	 
	 temp_2 = board[0][col];
	 board[0][col] = temp_1;
	 
	}
	 
	static void moveDown(int col, String board[][]) {
	 
	 String temp_1;
	 String temp_2;
	 
	 temp_1 = board[0][col];
	 board[0][col] = board[3][col];
	 
	 temp_2 = board[1][col];
	 board[1][col] = temp_1;
	 
	 temp_1 = board[2][col];
	 board[2][col] = temp_2;
	 
	 temp_2 = board[3][col];
	 board[3][col] = temp_1;
	 
	}
	
	String getColor(String boardPiece) {
		String returnColor = "";
		if(boardPiece == "R") 
			returnColor = "red";
		else if(boardPiece == "G") 
			returnColor = "green";
		else if(boardPiece == "B") 
			returnColor = "blue";
		else if(boardPiece == "Y") 
			returnColor = "yellow";
		
		return returnColor;
	}
	

}
