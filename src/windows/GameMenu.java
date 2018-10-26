package windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class GameMenu 
{
	
	private AnchorPane gameAnchorPane;
	
	public GameMenu()
	{
		try
		{
			System.out.println("Initalising menu anchor pane...");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("gameAnchorMenu.fxml"));
			setGameAnchorPane( (AnchorPane) loader.load() );
			System.out.println("Initalised menu anchor pane.\n");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public AnchorPane getGameAnchorPane() 
	{
		return gameAnchorPane;
	}

	public void setGameAnchorPane(AnchorPane newGameAnchorPane) 
	{
		gameAnchorPane = newGameAnchorPane;
	}
}
