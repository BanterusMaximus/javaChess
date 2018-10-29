package board;

import java.awt.Toolkit;

import javafx.application.Application;
import windows.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ChessBoardGUI  extends Application {
	
	public static MenuBar menuBar;
	
	public static void ChessBoardStart() {
		
		try {
			Main.setStageTitle("2 Player Chess");
			initChessBoard();
			
			
		} catch (Exception error) {
			
			error.printStackTrace();
			System.exit(0);
		}
	}
	
	private static ChessBoard board;
	
	public static void initChessBoard() {
		
		BorderPane root = new BorderPane();
		Scene mainScene = new Scene(root);
		mainScene.getStylesheets().add("windows/application.css");
		
		board = new ChessBoard();

		MenuBar menuBar = generateMenuBar();
		root.setTop(menuBar);
		
		AnchorPane chessCaptureArea = initCaptureAreaPane();

		if ( Main.primaryStage.isFullScreen() == true)
		{
			Main.primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
			Main.setSceneAndShow(mainScene);
			Main.primaryStage.setFullScreen(true);
			board.resize(Toolkit.getDefaultToolkit().getScreenSize().getWidth()- chessCaptureArea.getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight()- menuBar.getHeight());
		}
		
		root.resize(Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		root.setCenter(board);

		double captureAreaDimension = (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - Toolkit.getDefaultToolkit().getScreenSize().getHeight())/ 2;
		String setStlyeSting = String.format("-fx-pref-height: %f; -fx-pref-width: %f",Toolkit.getDefaultToolkit().getScreenSize().getHeight(),captureAreaDimension);
		chessCaptureArea.setStyle(setStlyeSting);
		
		root.setLeft(chessCaptureArea);

		Main.setSceneAndShow(mainScene);
		
	}
	
	private static AnchorPane initCaptureAreaPane() 
	{
		try
		{
		System.out.println("Initalising chess capture area pane...");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("chessCaptureArea.fxml"));
		AnchorPane chessCaptureArea = (AnchorPane) loader.load();
		System.out.println("Initalilised chess capture area pane.\n");
		return chessCaptureArea;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void onQuit() {
		
		Platform.exit();
		System.exit(0);
	}
	
	public static void onDisplayAbout() {
		
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("About");
		infoAlert.setHeaderText(null);	
		infoAlert.setContentText("Designed by Elliot C + Louis F.\n\n");
		infoAlert.showAndWait();
	}
	
	private static MenuBar generateMenuBar() {
		
		menuBar = new MenuBar();
		
		Menu gameMenu = new Menu("Game");
		menuBar.getMenus().add(gameMenu);
		
        MenuItem menuItemQuit = new MenuItem("Quit");
        menuItemQuit.setOnAction(e -> onQuit());
        //menuItemQuit.setGraphic( new ImageView( new Image("assets/icons/quit.png", 16, 16, true, true) ) );
        menuItemQuit.setAccelerator( new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN) );
        gameMenu.getItems().add(menuItemQuit);

        Menu menuHelp = new Menu("Help");
        menuBar.getMenus().add(menuHelp);

        MenuItem menuItemAbout = new MenuItem("About");
        //menuItemAbout.setGraphic( new ImageView( new Image("assets/icons/about.png", 16, 16, true, true) ) );
        // Note: Accelerator F1 does not work if TextField is
        //       in focus. This is a known issue in JavaFX.
        //       https://bugs.openjdk.java.net/browse/JDK-8148857
        menuItemAbout.setAccelerator( new KeyCodeCombination(KeyCode.F1) );
        menuItemAbout.setOnAction(e -> onDisplayAbout());
        menuHelp.getItems().add(menuItemAbout);
        

        return menuBar;
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
