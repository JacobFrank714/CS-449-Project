module game.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens game.app to javafx.fxml;
    exports game.app;
}
