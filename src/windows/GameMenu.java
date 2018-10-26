package windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class GameMenu 
{
	
	private AnchorPane gameAnchorPane;
	
	public GameMenu()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("gameAnchorMenu.fxml"));
			gameAnchorPane = (AnchorPane) loader.load();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
