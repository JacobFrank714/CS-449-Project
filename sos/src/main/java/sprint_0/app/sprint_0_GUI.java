package sprint_0.app;

import javafx.application.Application;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

// import java.io.IOException;

public class sprint_0_GUI extends Application{

    private Square[][] squares;

    private Label gameStatus = new Label("Player 1's Turn");

    static private sprint_0_Board board;

    @Override
    public void start(Stage primaryStage) {
		if (board == null) {
			board = new sprint_0_Board(8);
		}
		GridPane pane = new GridPane();
		squares = new Square[8][8];
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				pane.add(squares[i][j] = new Square(), j, i);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(gameStatus);

		Scene scene = new Scene(borderPane, 700, 700);
		primaryStage.setTitle("SOS Game");
		primaryStage.setScene(scene);
		primaryStage.show();
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

    // static void setRoot(String fxml) throws IOException {
    //     scene.setRoot(loadFXML(fxml));
    // }

    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(sprint_0_GUI.class.getResource(fxml + ".fxml"));
    //     return fxmlLoader.load();
    // }

    // @FXML
    // private void switchToSecondary() throws IOException {
    //     sprint_0_GUI.setRoot("secondary");
    // }

    // public class Square extends Pane {
	// 	public Square() {
	// 		setStyle("-fx-border-color: white");
	// 		this.setPrefSize(2000, 2000);
	// 		this.setOnMouseClicked(e -> handleMouseClick());
	// 	}

	// 	private void handleMouseClick() {
	// 	}

	// }
    public static void main(String[] args) {
        launch();
    }

}
