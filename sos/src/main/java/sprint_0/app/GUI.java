package sprint_0.app;

import javafx.application.Application;
// import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
// import javafx.scene.control.Label;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.Pane;

import java.io.IOException;


// import java.io.IOException;

public class GUI extends Application{

    private Label gameStatus = new Label("Red Player's Turn");

	private String fxml = "/resources/main";

	private static Scene scene;

    // static private Board board;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(fxml));
        stage.setScene(scene);
        stage.show();
		// if (board == null) {
		// 	board = new Board(8);
		// }
		// GridPane pane = new GridPane();
		// squares = new Square[8][8];
		// for (int i = 0; i < 8; i++)
		// 	for (int j = 0; j < 8; j++)
		// 		pane.add(squares[i][j] = new Square(), j, i);

		// BorderPane borderPane = new BorderPane();
		// borderPane.setCenter(pane);
		// borderPane.setBottom(gameStatus);

		// Scene scene = new Scene(borderPane, 800, 800);
		// primaryStage.setTitle("SOS Game");
		// primaryStage.setScene(scene);
		// primaryStage.show();
	}

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
