package windows;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class Main extends Application 
{
	private static Stage primaryStage;
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
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("rootBorder.fxml"));
		rootBorder = (BorderPane) loader.load();
		
		Scene scene = new Scene(rootBorder);
		
		setSceneAndShow(scene);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void setSceneAndShow(Scene scene)
	{
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public static void closeStage()
	{
		primaryStage.close();
	}
	
	
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}