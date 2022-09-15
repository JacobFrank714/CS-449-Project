package sprint_0.app;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.BorderPane;

import java.io.IOException;


// import java.io.IOException;

public class GUI extends Application{

	private String fxml = "/resources/board";

	@FXML
    private BorderPane borderPane;

    @Override
    public void start(Stage stage) throws IOException {

		Parent root = loadFXML(fxml);
		Scene scene = new Scene(root, 900, 600);
		stage.setTitle("SOS Game");
		stage.setScene(scene);
		stage.show();
	}

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
