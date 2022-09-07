package sprint_0.product;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class sprint_0_GUI extends Application{
    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(sprint_0_GUI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    @FXML
    private void switchToSecondary() throws IOException {
        sprint_0_GUI.setRoot("secondary");
    }
    public static void main(String[] args) {
        launch();
    }

}
