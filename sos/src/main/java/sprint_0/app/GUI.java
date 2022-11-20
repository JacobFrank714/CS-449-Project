package sprint_0.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GUI extends Application{

	private static String fxml = "SimpleGame";
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(fxml), 900, 600);
		stage.setTitle("SOS Game");
		stage.setScene(scene);
		stage.show();
	}

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        Game.setBlueMove("S");
        Game.setRedMove("S");
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
