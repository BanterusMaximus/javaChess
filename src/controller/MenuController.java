package controller;

import javafx.event.ActionEvent;
import board.ChessBoardGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import windows.Main;


public class MenuController 
{
	//Local UI interface variables linking
		@FXML
		private Button againstComputerButton;
		
		@FXML
		private Button twoPlayerButton;
		
		@FXML
		private Button exitGameButton;
		
		@FXML
		private Button onePlayerChallengesButton;
		
		//Event methods
		@FXML
		private void exitApplication(ActionEvent actionEvent)
		{
			Main.closeStage();
		}
		
		@FXML
		private void initTwoPlayerGame(ActionEvent actionEvent)
		{
			ChessBoardGUI.ChessBoardStart();
			System.out.println("Initilising two player game...");
			//System.err.println("!\t\t\t\t!\n   NOT YET IMPLEMENTED - TODO\n!\t\t\t\t!");
		}
		
		@FXML
		private void initAgainstComputerGame(ActionEvent actionEvent)
		{
			System.out.println("Initilising player vs computer game...");
			System.err.println("!\t\t\t\t!\n   NOT YET IMPLEMENTED - TODO\n!\t\t\t\t!");
		}
		
		@FXML
		private void initOnePlayerChallenge(ActionEvent actionEvent)
		{
			System.out.println("Initilising one player challenges...");
			System.err.println("!\t\t\t\t!\n   NOT YET IMPLEMENTED - TODO\n!\t\t\t\t!");
		}
		
}
