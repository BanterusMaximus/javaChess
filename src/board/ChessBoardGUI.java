package board;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ChessBoardGUI  extends Application {
	
	public static void main(String[] args) {
		
		try {
			launch(args);
			System.exit(0);
		} catch (Exception error) {
			
			error.printStackTrace();
			System.exit(0);
		}
	}
	
	private ChessBoard board;
	
	@Override
	public void start(Stage mainStage) {
		
		mainStage.setTitle("Chess Game");
		
		BorderPane root = new BorderPane();
		Scene mainScene = new Scene(root);
		mainStage.setScene(mainScene);
		
		mainScene.getStylesheets().add("windows/stylesheet.css");
		
		board = new ChessBoard();
		root.setCenter(board);
		
		MenuBar menuBar = generateMenuBar();
		root.setTop(menuBar);
		mainStage.show();
		
	}
	
	public void onQuit() {
		
		Platform.exit();
		System.exit(0);
	}
	
	public void onDisplayAbout() {
		
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("About");
		infoAlert.setHeaderText(null);	
		infoAlert.setContentText("Designed by Elliot C + Louis F.\n\n");
		infoAlert.showAndWait();
	}
	
	private MenuBar generateMenuBar() {
		
		MenuBar menuBar = new MenuBar();
		
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
}
