package windows;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;


public class Main extends Application 
{
	public static Stage primaryStage;
	public static String args;
	private BorderPane rootBorder;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Main.primaryStage = primaryStage;
			Main.primaryStage.setTitle("Java Chess");
			rootBorder = new BorderPane();
			
			initRootBorder();
			
			GameMenu menuDisplay = new GameMenu();
			
			rootBorder.setCenter(menuDisplay.getGameAnchorPane());
			
			Scene scene = new Scene(rootBorder);
			setSceneAndShow(scene);
		} 
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void initRootBorder()
	{
		try
		{
		System.out.println("Initalising root border pane...");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("rootBorder.fxml"));
		rootBorder = (BorderPane) loader.load();
		System.out.println("Initalilised root border pane.\n");
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void toggleFullscreen()
	{
		primaryStage.setFullScreen(true);
	}
	
	
	public static void setSceneAndShow(Scene scene)
	{
		System.out.println("---------------------------------------\nUpdating scene...\n---------------------------------------\n");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public static void closeStage()
	{
		System.out.println("Closing stage...");
		primaryStage.close();
	}
	
	public static void setStageTitle(String string)
	{
		primaryStage.setTitle(string);
	}	
	
	public static void main(String[] args) 
	{
		System.out.println("Starting program...\n");
		launch(args);
	}
}