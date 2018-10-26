package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import windows.Main;

public class BorderButtonsController 
{
	@FXML
	private MenuItem ExitMenuItem;
	
	@FXML
	private MenuItem fullscreenToggle;
	
	@FXML
	private void exitApplication(ActionEvent actionEvent)
	{
		Main.closeStage();
	}
	
	@FXML
	private void toggleFullscreen(ActionEvent actionEvent)
	{
		Main.toggleFullscreen();
	}
	
}
