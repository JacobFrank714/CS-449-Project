package sprint_0.app;

import javafx.application.Application;
// import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


// import java.io.IOException;

public class GUI extends Application{

    private Label gameStatus = new Label("B");

	private String fxml = "/resources/board";

	private static Scene scene;

    static private Board board;

	private Square[][] squares;

    @Override
    public void start(Stage stage) throws IOException {

		Parent root = loadFXML(fxml);
        // scene = new Scene(loadFXML(fxml), 1000, 1000);
		stage.setTitle("SOS Game");
		
		if (board == null) {
			board = new Board(8);
		}
		GridPane pane = new GridPane();
		squares = new Square[8][8];
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				pane.add(squares[i][j] = new Square(), j, i);
		
		root.getParent();

		Scene scene = new Scene(root, 900, 600);
		stage.setTitle("SOS Game");
		stage.setScene(scene);
		stage.show();
	}

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

	public class Square extends Pane {
		public Square() {
			setStyle("-fx-border-color: white");
			this.setPrefSize(2000, 2000);
			this.setOnMouseClicked(e -> handleMouseClick());
		}

		private void handleMouseClick() {
		}

	}

    public static void main(String[] args) {
        launch();
    }

}
